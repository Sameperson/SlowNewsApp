package com.sameperson.newswebsite.controller.filter;

import com.sameperson.newswebsite.logic.NewsUnmarshaler;
import com.sameperson.newswebsite.model.NewsList;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;


@WebFilter("/*")
public class RequestFilter implements Filter {

    private long currentTime;
    private Client client;
    private JSONObject weatherCurrently;
    private NewsList list = NewsList.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        client = ClientBuilder.newClient();
        currentTime = System.currentTimeMillis();
        weatherCurrently = getCurrentWeather();
        NewsUnmarshaler.unmarshal(list);
    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain filterChain)
            throws IOException, ServletException {
        if (System.currentTimeMillis() - currentTime > 600000) {
            currentTime = System.currentTimeMillis();
            weatherCurrently = getCurrentWeather();
            NewsUnmarshaler.unmarshal(list);
        }
        servletReq.setAttribute("newsList", list.getList());
        servletReq.setAttribute("weather", "Weather in Kiev: " + weatherCurrently.getString("summary") +
                "    " + weatherCurrently.getDouble("temperature") + "\u00b0");
        servletReq.setAttribute("username", ((HttpServletRequest)servletReq).getSession().getAttribute("username"));
        filterChain.doFilter(servletReq, servletResp);
    }

    private JSONObject getCurrentWeather() {
        return new JSONObject(client.target("https://api.forecast.io/forecast/ccc9e70f9fbe7b36c2ceea0201205811/50.450100,30.523400?units=si")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class))
                .getJSONObject("currently");
    }

    @Override
    public void destroy() {

    }
}
