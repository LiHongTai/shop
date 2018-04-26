package com.roger.shop.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static String configFile = CONFIG_FILE_LOCATION;

    private static SessionFactory sessionFactory;

    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static Configuration configuration = new Configuration();

    static {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private HibernateSessionFactory() {
        //定义私有构造函数，避免外部创建
    }

    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null)
                rebuildSessionFactory();
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }

        return session;
    }

    private static void rebuildSessionFactory() {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void closeSession() throws HibernateException{
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if(session != null)
            session.close();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Configuration getConfiguration(){
        return configuration;
    }

    public void setConfigFile(String configFile) {
        HibernateSessionFactory.CONFIG_FILE_LOCATION = configFile;
        sessionFactory = null;
    }
}
