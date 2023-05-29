package com.example.projethibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "MEDECIN")
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codemed")
    private Integer codemed;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Grade")
    private String grade;

    public int getCodemed() {
        return codemed;
    }

    public void setCodemed(int codemed) {
        this.codemed = codemed;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }}
