package com.sameperson.newswebsite.controller;

import com.sameperson.newswebsite.model.User;
import com.sameperson.newswebsite.database.UserDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/archive")
public class ArchiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new UserDatabase().getUser((String)req.getSession().getAttribute("username"));

        String username = (String)req.getSession().getAttribute("username");
        req.setAttribute("username", username);
        req.setAttribute("newsList", user.getArchive());
        getServletContext().getRequestDispatcher("/WEB-INF/archive.jsp").forward(req, resp);
    }
}
