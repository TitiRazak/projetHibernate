package com.example.projethibernate.DAO;

import com.example.projethibernate.entity.Patient;
import com.example.projethibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public interface patientDAO {

    static Patient getPatient(String codepat) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Patient.class, codepat);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void addPatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(String codepat);

    List<Patient> getAllPatients();

    List<Patient> searchPatients(String code, String nom);
}
