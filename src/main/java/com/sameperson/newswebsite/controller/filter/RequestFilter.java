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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain filterChain)
            throws IOException, ServletException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.forecast.io/forecast/").path("ccc9e70f9fbe7b36c2ceea0201205811/50.450100,30.523400");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        JSONObject currently = new JSONObject(response).getJSONObject("currently");
        servletReq.setAttribute("weather", "Weather in Kiev: " + currently.getString("summary") +
                "    " + (long)Math.floor(((currently.getDouble("temperature") - 32)*5)/9 + 0.5d) +"\u00b0");
        filterChain.doFilter(servletReq, servletResp);
    }

    @Override
    public void destroy() {

    }
}
