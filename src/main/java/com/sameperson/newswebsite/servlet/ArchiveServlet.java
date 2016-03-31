package com.sameperson.newswebsite.servlet;

import com.sameperson.newswebsite.model.ArchiveList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/archive")
public class ArchiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArchiveList archiveList = ArchiveList.getInstance();

        String username = (String)req.getSession().getAttribute("username");
        req.setAttribute("username", username);
        req.setAttribute("newsList", archiveList.getUsersArchive(username));
        getServletContext().getRequestDispatcher("/WEB-INF/archive.jsp").forward(req, resp);


    }
}
