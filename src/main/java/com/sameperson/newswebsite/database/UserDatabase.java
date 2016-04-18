package com.sameperson.newswebsite.database;

import com.sameperson.newswebsite.model.Article;
import com.sameperson.newswebsite.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class UserDatabase {

    private SessionFactory sessionFactory = HibernateSessionFactoryProvider.SESSION_FACTORY;

    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<User> fetchAllUsers() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public synchronized int save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer id = (Integer)session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("User "+user.getUsername()+" added!");
        return id;
    }

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public boolean containsUsername(String username) {
        for(User user : fetchAllUsers()) {
            if(user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        System.out.println("Getting user...");
        User user = (User)criteria.uniqueResult();
        session.close();
        return user;
    }

    public synchronized void addNewsToUsersArchive(User user, Article article) {
        user.getArchive().add(NewsDatabase.getNews(article.getTitle()));
        update(user);
    }

    public boolean hasNewsInArchive(User user, Article news) {
        for(Article article : user.getArchive()) {
            if(article.getTitle().equals(news.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
