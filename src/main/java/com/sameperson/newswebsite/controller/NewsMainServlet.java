package com.sameperson.newswebsite.controller;

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

    private long currentTime;
    private NewsList list = NewsList.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        currentTime = System.currentTimeMillis();
        unmarshal(list);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(System.currentTimeMillis()-currentTime>60000) {
            currentTime = System.currentTimeMillis();
            unmarshal(list);
        }
        System.out.println(list.toString());
        req.setAttribute("newsList", list.getList());
        req.setAttribute("username", req.getSession().getAttribute("username"));
        getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(req, resp);
    }

    private boolean unmarshal(NewsList newsList) {
        try {
            newsList = (NewsList) JAXBContext.newInstance(NewsList.class)
                    .createUnmarshaller()
                    .unmarshal(new URL("https://rss.sciencedaily.com/all.xml"));
            return true;
        } catch (JAXBException e) {
            return false;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
