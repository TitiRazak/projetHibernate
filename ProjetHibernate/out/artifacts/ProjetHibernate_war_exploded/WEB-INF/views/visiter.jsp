<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projethibernate.entity.Medecin" %>
<%@ page import="com.example.projethibernate.entity.Patient" %>
<%@ page import="com.example.projethibernate.entity.Visiter" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Visiteurs</title>
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
<h1>Visiteurs</h1>

<form action="visitercontroller" method="POST">
    <input type="hidden" name="action" value="add">

    <label for="codemed">Médecin:</label>
    <select id="codemed" name="codemed" required>
        <jsp:useBean id="medecins" scope="request" class="com.example.projethibernate.entity.Medecin"
                     type="java.util.List"/>
        <c:forEach var="medecin" items="${medecins}">
            <option value="${medecin.getCodemed}">${medecin.nom} ${medecin.prenom}</option>
        </c:forEach>
    </select><br><br>

    <label for="codepat">Patient:</label>
    <select id="codepat" name="codepat" required>
        <jsp:useBean id="patients" scope="request" class="com.example.projethibernate.entity.Patient"
                     type="java.util.List"/>
        <c:forEach var="patient" items="${patients}">
            <option value="${patient.getCodepat}">${patient.nom} ${patient.prenom}</option>
        </c:forEach>
    </select><br><br>

    <label for="date">Date de visite:</label>
    <input type="date" id="date" name="date" required><br><br>

    <button type="submit">Ajouter</button>
</form>

<br>

<table>
    <tr>
        <th>Code médecin</th>
        <th>Code patient</th>
        <th>Date de visite</th>
        <th>Actions</th>
    </tr>
    <jsp:useBean id="visiters" scope="request" class="com.example.projethibernate.entity.Visiter"
                 type="java.util.List"/>
    <c:forEach var="visiter" items="${visiters}">
        <tr>
            <td>${visiter.medecin.codemed}</td>
            <td>${visiter.patient.codepat}</td>
            <td>${visiter.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
