package com.sameperson.newswebsite.servlet;


import com.sameperson.newswebsite.model.NewsBean;
import com.sameperson.newswebsite.model.NewsList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/news/*")
public class SingleNewsServlet extends HttpServlet {

    private volatile NewsList newsList;

    @Override
    public void init() throws ServletException {
        super.init();
        newsList = NewsList.getInstance();
        System.out.println("SingleNewsServlet initialized");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/newsInstance.jsp");

        String newsUri = req.getPathInfo();
        String newsName = newsUri.substring(1, newsUri.length());
        NewsBean newsInstance = newsList.findByName(newsName);
        req.setAttribute("newsInstance", newsInstance);

        requestDispatcher.forward(req, resp);
    }
}
