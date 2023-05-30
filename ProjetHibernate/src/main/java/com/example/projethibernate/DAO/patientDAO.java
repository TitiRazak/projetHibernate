package com.example.projethibernate.DAO;

import com.example.projethibernate.entity.Patient;

import java.util.List;

public interface patientDAO {

    void addPatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(String codepat);

    List<Patient> getAllPatients();

    List<Patient> searchPatients(String code, String nom);
}
