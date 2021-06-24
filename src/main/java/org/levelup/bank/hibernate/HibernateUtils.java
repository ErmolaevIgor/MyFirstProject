package org.levelup.bank.hibernate;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory factory = loadFactory();

    private static SessionFactory loadFactory() {
        Configuration config = new Configuration().configure();
        return config.buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }

}
