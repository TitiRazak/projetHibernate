package com.example.projethibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "PATIENT")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codepat")
    private int codepat;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Sexe")
    private String sexe;

    @Column(name = "Adresse")
    private String adresse;

    public int getCodepat() {
        return codepat;
    }

    public void setCodepat(int codepat) {
        this.codepat = codepat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

