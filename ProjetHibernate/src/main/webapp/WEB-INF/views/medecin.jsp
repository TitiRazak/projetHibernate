<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.projethibernate.entity.Medecin" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des médecins</title>
</head>
<body>
<h1>Gestion des médecins</h1>

<h2>Ajouter ou mettre à jour un médecin</h2>
<form action="medecinServlet?action=add" method="post">
    <label for="codemed">Code Médecin:</label>
    <input type="text" id="codemed" name="codemed"><br><br>
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom"><br><br>
    <label for="prenom">Prénom:</label>
    <input type="text" id="prenom" name="prenom"><br><br>
    <label for="grade">Grade:</label>
    <input type="text" id="grade" name="grade"><br><br>
    <input type="submit" value="Enregistrer">
</form>

<h2>Liste des médecins</h2>
<table>
    <tr>
        <th>Code Médecin</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Grade</th>
        <th>Actions</th>
    </tr>
    <% List<Medecin> medecins = (List<Medecin>) request.getAttribute("medecins"); %>
    <% if (medecins != null) { %>
    <% for (Medecin medecin : medecins) { %>
    <tr>
        <td><%= medecin.getCodemed() %>
        </td>
        <td><%= medecin.getNom() %>
        </td>
        <td><%= medecin.getPrenom() %>
        </td>
        <td><%= medecin.getGrade() %>
        </td>
        <td>
            <a href="medecinServlet?action=delete&codemed=<%= medecin.getCodemed() %>">Supprimer</a>
        </td>
    </tr>
    <% } %>
    <% } %>
</table>
</body>
</html>
