<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

<h2>Ajouter ou mettre à jour un patient</h2>
<form action="patientServlet?action=add" method="post">
    <label for="codepat">Code:</label>
    <input type="text" id="codepat" name="codepat"><br><br>
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom"><br><br>
    <label for="prenom">Prénom:</label>
    <input type="text" id="prenom" name="prenom"><br><br>
    <label for="sexe">Sexe:</label>
    <select id="sexe" name="sexe">
        <option value="male">Male</option>
        <option value="female">Female</option>
    </select>
    <label for="adresse">Adresse:</label>
    <input type="text" id="adresse" name="adresse"><br><br>
    <br><br>
    <input type="submit" value="Enregistrer">
</form>


<h1>Liste des patients</h1>

<form action="patientServlet" method="GET">
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
                <a href="patientServlet?action=delete&codepat=${patient.getCodepat()}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
