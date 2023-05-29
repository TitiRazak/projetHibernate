package com.example.projethibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author rozee
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            String configFile="conf/hibernate.cfg.xml";
            String path = System.getProperty("user.dir");
            path = path +"/"+configFile;
            sessionFactory = new AnnotationConfiguration().configure(new File(path)).buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Exception stack Trace ************** begin");
            System.err.println("Hibernate : Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            System.err.println("Exception Stack Trace ********* END");
            throw new ExceptionInInitializerError(ex);


        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}