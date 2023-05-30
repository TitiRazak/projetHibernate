package com.example.projethibernate.DAO;

import com.example.projethibernate.entity.Medecin;

import java.util.List;

public interface medecinDAO {

    void addMedecin(Medecin medecin);


    void updateMedecin(Medecin medecin);

    void deleteMedecin(int codemed);

    List<Medecin> getAllMedecins();

    Medecin getMedecin(int codemed);
}
