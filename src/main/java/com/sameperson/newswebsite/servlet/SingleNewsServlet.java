package com.sameperson.newswebsite.servlet;


import com.sameperson.newswebsite.model.ArchiveList;
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
    private volatile ArchiveList archiveList;

    @Override
    public void init() throws ServletException {
        super.init();
        newsList = NewsList.getInstance();
        archiveList = ArchiveList.getInstance();
        System.out.println("SingleNewsServlet initialized");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/newsInstance.jsp");

        String newsUri = req.getPathInfo();
        String newsName = newsUri.substring(1, newsUri.length());
        NewsBean newsInstance = newsList.findByName(newsName);
        String username = (String)req.getSession().getAttribute("username");
        req.setAttribute("newsInstance", newsInstance);
        req.setAttribute("username", username);
        if(archiveList.hasNewsInArchive(username, newsInstance.getName())) {
            req.setAttribute("hideArchiveButton", true);
        }
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsBean newsBean = newsList.findByName(req.getParameter("name"));
        String username = (String)req.getSession().getAttribute("username");
        archiveList.getUsersArchive(username).add(newsBean);
        resp.sendRedirect("/");
    }
}
