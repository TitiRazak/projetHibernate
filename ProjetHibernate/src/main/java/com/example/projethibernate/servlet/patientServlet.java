package com.example.projethibernate.servlet;

import com.example.projethibernate.DAO.patientController;
import com.example.projethibernate.DAO.patientDAO;
import com.example.projethibernate.entity.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/patientServlet")
public class patientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private patientDAO patientDAO;

    public void init() {
        // Initialisation du PatientDAO (vous devrez l'adapter selon votre configuration)
        patientDAO = new patientController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addPatient(request, response);
                    break;
                case "update":
                    updatePatient(request, response);
                    break;
                case "delete":
                    deletePatient(request, response);
                    break;
            }
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

    private void addPatient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codepat = request.getParameter("codepat");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        String adresse = request.getParameter("adresse");

        Patient patient = new Patient(codepat, nom, prenom, sexe, adresse);
        patientDAO.addPatient(patient);

        response.sendRedirect(request.getContextPath());
    }

    private void updatePatient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codepat = request.getParameter("codepat");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        String adresse = request.getParameter("adresse");

        List<Patient> patients = patientDAO.searchPatients(codepat, "");
        if (!patients.isEmpty()) {
            Patient patient = patients.get(0);
            patient.setNom(nom);
            patient.setPrenom(prenom);
            patient.setSexe(sexe);
            patient.setAdresse(adresse);

            patientDAO.updatePatient(patient);
        }

        response.sendRedirect(request.getContextPath());
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codepat = request.getParameter("codepat");

        patientDAO.deletePatient(codepat);

        response.sendRedirect(request.getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("search")) {
            searchPatients(request, response);
        } else {
            List<Patient> patients = patientDAO.getAllPatients();
            request.setAttribute("patients", patients);

            request.getRequestDispatcher("/patient.jsp").forward(request, response);
        }
    }

    private void searchPatients(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");

        List<Patient> patients = null;
        if (searchType != null && searchType.equals("code")) {
            patients = patientDAO.searchPatients(searchTerm, "");
        } else if (searchType != null && searchType.equals("nom")) {
            patients = patientDAO.searchPatients("", searchTerm);
        }

        request.setAttribute("patients", patients);
        request.getRequestDispatcher("/patient.jsp").forward(request, response);
    }
}
