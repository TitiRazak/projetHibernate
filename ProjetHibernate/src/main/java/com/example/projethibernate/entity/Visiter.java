package com.example.projethibernate.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "visiter")
@IdClass(VisiterID.class)
public class Visiter {
    @Id
    @ManyToOne
    @JoinColumn(name = "codemed", referencedColumnName = "codemed")
    private Medecin medecin;

    @Id
    @ManyToOne
    @JoinColumn(name = "codepat", referencedColumnName = "codepat")
    private Patient patient;

    @Id
    @Column(name = "date")
    private Date date;

    // Getters and Setters

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
