package com.sameperson.newswebsite.model.database;

import com.sameperson.newswebsite.model.Article;
import com.sameperson.newswebsite.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDatabase {

    private static SessionFactory sessionFactory = HibernateSessionFactoryProvider.SESSION_FACTORY;

    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public static void update(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public static List<User> fetchAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createCriteria(User.class)
                .list();
        session.close();
        return users;
    }

    public static int save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer id = (Integer)session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("User "+user.getUsername()+" added!");
        return id;
    }

    public static void delete(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public static boolean containsUsername(String username) {
        for(User user : fetchAllUsers()) {
            if(user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static User getUser(String username) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        System.out.println("Getting user...");
        User user = (User)criteria.uniqueResult();
        session.close();
        return user;
    }

    public static void addNewsToUsersArchive(User user, Article article) {
        user.getArchive().add(NewsDatabase.getNews(article.getTitle()));
        update(user);
    }
}
