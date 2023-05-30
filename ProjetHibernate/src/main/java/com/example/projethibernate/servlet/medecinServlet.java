package com.example.projethibernate.servlet;

import com.example.projethibernate.DAO.medecinController;
import com.example.projethibernate.DAO.medecinDAO;
import com.example.projethibernate.entity.Medecin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class medecinServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private medecinDAO medecinDAO;

    public void init() {
        // Initialisation du MedecinDAO (vous devrez l'adapter selon votre configuration)
        medecinDAO = new medecinController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addMedecin(request, response);
                    break;
                case "update":
                    updateMedecin(request, response);
                    break;
                case "delete":
                    deleteMedecin(request, response);
                    break;
            }
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

    private void addMedecin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codemed = request.getParameter("codemed");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String grade = request.getParameter("grade");

        Medecin medecin = new Medecin(codemed, nom, prenom, grade);
        medecinDAO.addMedecin(medecin);

        response.sendRedirect(request.getContextPath());
    }

    private void updateMedecin(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int codemed = Integer.parseInt(request.getParameter("codemed"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String grade = request.getParameter("grade");

        Medecin medecin = medecinDAO.getMedecin(codemed);
        if (medecin != null) {
            medecin.setNom(nom);
            medecin.setPrenom(prenom);
            medecin.setGrade(grade);

            medecinDAO.updateMedecin(medecin);
        }

        response.sendRedirect(request.getContextPath());
    }

    private void deleteMedecin(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int codemed = Integer.parseInt(request.getParameter("codemed"));

        medecinDAO.deleteMedecin(codemed);

        response.sendRedirect(request.getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Medecin> medecins = medecinDAO.getAllMedecins();
        request.setAttribute("medecins", medecins);

        request.getRequestDispatcher("/medecin.jsp").forward(request, response);
    }
}


