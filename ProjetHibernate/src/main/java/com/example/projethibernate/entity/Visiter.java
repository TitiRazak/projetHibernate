package com.example.projethibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.sql.Date;

@Entity
@Table(appliesTo = "visiter")
public class Visiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codemed")
    private String codeMed;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codepat")
    private String codePat;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date")
    private Date date;

    public String getCodeMed() {
        return codeMed;
    }

    public void setCodeMed(String codeMed) {
        this.codeMed = codeMed;
    }

    public String getCodePat() {
        return codePat;
    }

    public void setCodePat(String codePat) {
        this.codePat = codePat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}