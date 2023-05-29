package com.example.projethibernate.controller;

import com.example.projethibernate.dao.MedecinDAO;
import com.example.projethibernate.entity.Medecin;
import java.util.List;

public class MedecinController {
    private final MedecinDAO medecinDAO;

    public MedecinController() {
        medecinDAO = new MedecinDAO();
    }

    public List<Medecin> getAllMedecins() {
        return medecinDAO.getAllMedecins();
    }

    public void addMedecin(Medecin medecin) {
        medecinDAO.addMedecin(medecin);
    }

    public void updateMedecin(Medecin medecin) {
        medecinDAO.updateMedecin(medecin);
    }

    public void deleteMedecin(int id) {
        medecinDAO.deleteMedecin(id);
    }

    public Medecin getMedecin(int id) {
        return medecinDAO.getMedecin(id);
    }
}