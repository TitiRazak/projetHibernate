package com.example.projethibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.sql.Date;

@Entity
@Table(appliesTo = "VISITER")
public class Visiter {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="codemed")
    private int codeMed;

    public Object getCodeMed() {
        return codeMed;
    }

    public void setCodeMed(int codeMed) {
        this.codeMed = codeMed;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="codepat")
    private int codePat;

    public Object getCodePat() {
        return codePat;
    }

    public void setCodePat(int codePat) {
        this.codePat = codePat;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="date")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}