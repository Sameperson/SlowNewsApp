package com.sameperson.newswebsite.controller;

import com.sameperson.newswebsite.model.NewsList;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


@WebServlet("")
public class NewsMainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsList list = NewsList.getInstance();
        try {
            list = (NewsList)JAXBContext.newInstance(NewsList.class)
                    .createUnmarshaller()
                    .unmarshal(new URL("https://rss.sciencedaily.com/all.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        req.setAttribute("newsList", list.getList());
        req.setAttribute("username", req.getSession().getAttribute("username"));
        getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(req, resp);
    }
}
