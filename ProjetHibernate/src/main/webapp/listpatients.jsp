<%@ page import="java.util.List" %>
<%@ page import="com.example.projethibernate.dao.PatientDAO" %>
<%@ page import="com.example.projethibernate.entity.Patient" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LIST PATIENTS</title>
</head>
<body>
<%!
    private com.example.projethibernate.dao.PatientDAO patientDAO;
%><%
List<Patient> patients = PatientDAO.getAllPatients();
%>

<table>
    <tr>
        <th>Code</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Sexe</th>
        <th>Adresse</th>
    </tr>
    <% for (Patient patient : patients) { %>
        <tr>
            <td><%=patient.getCodepat()%></td>
            <td><%=patient.getNom()%></td>
            <td><%=patient.getPrenom()%></td>
            <td><%=patient.getSexe()%></td>
            <td><%=patient.getAdresse()%></td>
        </tr>
    <% } %>
</table>
</body>