package com.sameperson.newswebsite.model.database;

import com.sameperson.newswebsite.model.Article;
import com.sameperson.newswebsite.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class NewsDatabase {

    private static SessionFactory sessionFactory = HibernateSessionFactoryProvider.SESSION_FACTORY;

    public Article getArticleById(int id) {
        Session session = sessionFactory.openSession();
        Article article = session.get(Article.class, id);
        session.close();
        return article;
    }

    public static void update(Article article) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(article);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public static List<Article> fetchAllNews() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Article.class);
        criteria.addOrder(Order.desc("id"));
        List<Article> news = criteria.list();
        session.close();
        return news;
    }

    public static int save(Article article) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer id = (Integer)session.save(article);
        session.getTransaction().commit();
        session.close();
        System.out.println("User "+ article.getTitle() +" added!");
        return id;
    }

    public static void delete(User contact) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(contact);
        session.getTransaction().commit();
        session.close();
    }

    public static boolean containsArticle(String title) {
        for(Article article : fetchAllNews()) {
            if(article.getName().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public static Article getNews(String title) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Article.class);
        criteria.add(Restrictions.eq("title", title));
        System.out.println("Getting news...");
        Article article = (Article)criteria.uniqueResult();
        session.close();
        return article;
    }

}
