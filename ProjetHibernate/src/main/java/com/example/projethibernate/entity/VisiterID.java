package com.example.projethibernate.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class VisiterID implements Serializable {
    private Medecin medecin;
    private Patient patient;
    private Date date;

    // Constructors

    public VisiterID() {
    }

    public VisiterID(Medecin medecin, Patient patient, Date date) {
        this.medecin = medecin;
        this.patient = patient;
        this.date = date;
    }

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

    // Implement equals() and hashCode() methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisiterID)) return false;
        VisiterID that = (VisiterID) o;
        return Objects.equals(getMedecin(), that.getMedecin()) &&
                Objects.equals(getPatient(), that.getPatient()) &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMedecin(), getPatient(), getDate());
    }
}
