package com.sameperson.newswebsite.servlet;

import com.sameperson.newswebsite.model.UserList;
import org.apache.catalina.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserList userList = UserList.getInstance();
        HttpSession session = req.getSession();
        String usernameFromPost = req.getParameter("username");
        if(userList.containsUser(usernameFromPost)
                && userList.findByName(usernameFromPost).getPassword().equals(req.getParameter("password"))) {
            session.setAttribute("username", usernameFromPost);
            req.setAttribute("logged", true);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("logged", false);
            resp.sendRedirect("/login");
        }

    }
}
