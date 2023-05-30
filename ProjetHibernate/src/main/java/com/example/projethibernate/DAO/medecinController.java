package com.example.projethibernate.DAO;

import com.example.projethibernate.entity.Medecin;
import com.example.projethibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class medecinController implements medecinDAO {

    public void setSessionFactory(SessionFactory sessionFactory) {
    }

    public void addMedecin(Medecin medecin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(medecin);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateMedecin(Medecin medecin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(medecin);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteMedecin(int codemed) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Medecin medecin = session.get(Medecin.class, codemed);
            session.remove(medecin);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Medecin getMedecin(int codemed) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Medecin.class, codemed);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Medecin> getAllMedecins() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Medecin> medecins = session.createQuery("from Medecin ").list();
            session.close();
            return medecins;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
