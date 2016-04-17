package com.sameperson.newswebsite.controller.filter;

import com.sameperson.newswebsite.logic.NewsUnmarshaler;
import com.sameperson.newswebsite.model.Article;
import com.sameperson.newswebsite.model.NewsList;
import com.sameperson.newswebsite.model.database.NewsDatabase;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
        addNewsToDatabase(list);
        System.out.println("List length: " + list.getList().size());
    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain filterChain)
            throws IOException, ServletException {
        if (System.currentTimeMillis() - currentTime > 600000) {
            currentTime = System.currentTimeMillis();
            weatherCurrently = getCurrentWeather();
            NewsUnmarshaler.unmarshal(list);
            addNewsToDatabase(list);
            System.out.println("Refreshing news...");
        }
        servletReq.setAttribute("newsList", NewsDatabase.fetchAllNews());
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

    private void addNewsToDatabase(NewsList newsList) {
        newsList.getList().stream().filter(article -> !NewsDatabase
                .containsArticle(article.getTitle()))
                .forEach(NewsDatabase::save);
        System.out.println("Adding news to the database...");
    }

    @Override
    public void destroy() {

    }
}
