package com.example.projethibernate.DAO;

import com.example.projethibernate.entity.Visiter;
import com.example.projethibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class visiterController implements visiterDAO {
    public void addVisiter(Visiter visiter) {
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

    public List<Visiter> getAllVisites() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Visiter> visiter = session.createQuery("from Visiter").list();
        session.close();
        return visiter;
    }
}
