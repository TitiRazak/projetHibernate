<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projethibernate.entity.Patient" %>
<%@ page import="com.example.projethibernate.servlet.patientServlet" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des patients</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<h1>Liste des patients</h1>

<form action="patientcontroller" method="GET">
    <input type="hidden" name="action" value="search">
    <label>
        <select name="searchType">
            <option value="code">Code</option>
            <option value="nom">Nom</option>
        </select>
    </label>
    <label>
        <input type="text" name="searchTerm" placeholder="Rechercher...">
    </label>
    <button type="submit">Rechercher</button>
</form>

<br>

<table>
    <tr>
        <th>Code</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Sexe</th>
        <th>Adresse</th>
        <th>Actions</th>
    </tr>
    <% List<Patient> patients = (List<Patient>) request.getAttribute("patients"); %>
    <jsp:useBean id="patients" scope="request" class="com.example.projethibernate.entity.Patient"
                 type="java.util.List"/>
    <c:forEach var="patient" items="${patients}">
        <tr>
            <td>${patient.getCodepat()}</td>
            <td>${patient.getNom()}</td>
            <td>${patient.getPrenom()}</td>
            <td>${patient.getSexe()}</td>
            <td>${patient.getAdresse()}</td>
            <td>
                <a href="patientcontroller?action=delete&codepat=${patient.getCodepat}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
