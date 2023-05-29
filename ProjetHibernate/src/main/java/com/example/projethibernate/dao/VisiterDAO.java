package com.example.projethibernate.dao;

import com.example.projethibernate.entity.Visiter;
import com.example.projethibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VisiterDAO {
    public void saveVisiter(Visiter visiter) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(visiter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
