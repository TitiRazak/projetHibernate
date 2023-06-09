package com.example.projethibernate.DAO;

import com.example.projethibernate.entity.Patient;
import com.example.projethibernate.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class patientController implements patientDAO {
    public void addPatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updatePatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletePatient(String codepat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, codepat);
            session.remove(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Patient> patients = session.createQuery("from Patient").list();
        session.close();
        return patients;
    }

    public List<Patient> searchPatients(String code, String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Patient> criteria = builder.createQuery(Patient.class);
        Root<Patient> root = criteria.from(Patient.class);
        criteria.select(root).where(builder.or(
                builder.equal(root.get("codePat"), code),
                builder.like(root.get("nom"), "%" + nom + "%")
        ));
        List<Patient> patients = session.createQuery(criteria).getResultList();
        session.close();
        return patients;
    }
}
