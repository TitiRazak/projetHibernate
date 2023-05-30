package com.example.projethibernate.servlet;

import com.example.projethibernate.DAO.visiterController;
import com.example.projethibernate.DAO.visiterDAO;
import com.example.projethibernate.entity.Visiter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

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
            String codemed = request.getParameter("codemed");
            String codepat = request.getParameter("codepat");
            String date = request.getParameter("date");

            Visiter visiter = new Visiter();
            visiter.setCodeMed(codemed);
            visiter.setCodePat(codepat);
            visiter.setDate(Date.valueOf(date));

            visiterDAO.addVisiter(visiter);
        }

        List<Visiter> visiters = visiterDAO.getAllVisites();
        request.setAttribute("visiters", visiters);
        request.getRequestDispatcher("/visiter.jsp").forward(request, response);
    }
}
