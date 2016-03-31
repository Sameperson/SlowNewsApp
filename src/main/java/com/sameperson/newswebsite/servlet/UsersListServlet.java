package com.sameperson.newswebsite.servlet;

import com.sameperson.newswebsite.model.UserList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userlist")
public class UsersListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userList", UserList.getInstance().getList());
        getServletContext().getRequestDispatcher("/WEB-INF/userList.jsp").forward(req, resp);
    }
}
