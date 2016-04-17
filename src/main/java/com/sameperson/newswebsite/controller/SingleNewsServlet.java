package com.sameperson.newswebsite.controller;


import com.sameperson.newswebsite.model.ArchiveList;
import com.sameperson.newswebsite.model.Article;
import com.sameperson.newswebsite.model.NewsList;
import com.sameperson.newswebsite.model.database.NewsDatabase;
import com.sameperson.newswebsite.model.database.UserDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/news/*")
public class SingleNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/newsInstance.jsp");

        String newsUri = req.getPathInfo();
        String newsName = newsUri.substring(1, newsUri.length());
        Article newsInstance = NewsDatabase.getNews(newsName);
        String username = (String)req.getSession().getAttribute("username");
        req.setAttribute("newsInstance", newsInstance);
        req.setAttribute("username", username);
//        if(ArchiveList.getInstance().hasNewsInArchive(username, newsInstance.getName())) {
//            req.setAttribute("hideArchiveButton", true);
//        }
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDatabase.addNewsToUsersArchive(UserDatabase.getUser((String)req.getSession().getAttribute("username")),
                NewsDatabase.getNews(req.getParameter("name")));
        //Article newsBean = NewsDatabase.getNews(req.getParameter("name"));
        //String username = (String)req.getSession().getAttribute("username");
        //ArchiveList.getInstance().getUsersArchive(username).add(newsBean);
        resp.sendRedirect("/");
    }
}
