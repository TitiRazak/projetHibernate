package com.example.projethibernate.DAO;

import com.example.projethibernate.entity.Medecin;
import com.example.projethibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public interface medecinDAO {

    static Medecin getMedecin(String codemed) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Medecin.class, codemed);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void addMedecin(Medecin medecin);

    void updateMedecin(Medecin medecin);

    void deleteMedecin(String codemed);

    List<Medecin> getAllMedecins();
}
