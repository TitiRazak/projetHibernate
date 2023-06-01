package com.example.projethibernate.servlet;

import com.example.projethibernate.DAO.medecinDAO;
import com.example.projethibernate.DAO.patientDAO;
import com.example.projethibernate.DAO.visiterController;
import com.example.projethibernate.DAO.visiterDAO;
import com.example.projethibernate.entity.Medecin;
import com.example.projethibernate.entity.Patient;
import com.example.projethibernate.entity.Visiter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/visiterServlet")
public class visiterServlet extends HttpServlet {
    private visiterDAO visiterDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        visiterDAO = new visiterController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Visiter> visiters = visiterDAO.getAllVisites();
        request.setAttribute("visiters", visiters);
        request.getRequestDispatcher("/visiter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String medecinId = request.getParameter("codemed");
            String patientId = request.getParameter("codepat");
            String date = request.getParameter("date");

            // Retrieve Medecin and Patient records from the database
            Medecin medecin = medecinDAO.getMedecin(medecinId);
            Patient patient = patientDAO.getPatient(patientId);

            if (medecin != null && patient != null) {
                Visiter visiter = new Visiter();
                visiter.setMedecin(medecin);
                visiter.setPatient(patient);
                visiter.setDate(Date.valueOf(date));

                visiterDAO.addVisiter(visiter);
            }
        }

        List<Visiter> visiters = visiterDAO.getAllVisites();
        request.setAttribute("visiters", visiters);
        request.getRequestDispatcher("/visiter.jsp").forward(request, response);
    }
}
