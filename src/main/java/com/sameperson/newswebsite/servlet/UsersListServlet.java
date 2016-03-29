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

    private volatile UserList userList;

    @Override
    public void init() throws ServletException {
        super.init();
        userList = UserList.getInstance();
        System.out.println("News main servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/userList.jsp");

        userList = UserList.getInstance();
        req.setAttribute("userList", userList.getList());
        requestDispatcher.forward(req, resp);
    }
}
