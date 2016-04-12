package com.sameperson.newswebsite.controller;

import com.sameperson.newswebsite.logic.NewsUnmarshaler;
import com.sameperson.newswebsite.model.NewsList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


@WebServlet("")
public class NewsMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("username", req.getSession().getAttribute("username"));
        getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(req, resp);
    }
}
