package com.sameperson.newswebsite.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactoryProvider {
    public static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        System.out.println("Building session factory...");
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
}
