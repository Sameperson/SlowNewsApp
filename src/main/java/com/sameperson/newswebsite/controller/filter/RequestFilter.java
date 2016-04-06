package com.sameperson.newswebsite.controller.filter;

import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        client = ClientBuilder.newClient();
        currentTime = System.currentTimeMillis();
        weatherCurrently = getCurrentWeather();
    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain filterChain)
            throws IOException, ServletException {
        if (System.currentTimeMillis() - currentTime > 60000) {
            weatherCurrently = getCurrentWeather();
        }
        servletReq.setAttribute("weather", "Weather in Kiev: " + weatherCurrently.getString("summary") +
                "    " + weatherCurrently.getDouble("temperature") + "\u00b0");
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
