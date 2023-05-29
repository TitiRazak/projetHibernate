<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AJOUT MEDECIN</title>
</head>
<body>
<form action="/addMedecin" method="post">
    <label for="codemed">Code:</label>
    <input type="text" id="codemed" name="codemed"><br>
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom"><br>
    <label for="prenom">Prenom:</label>
    <input type="text" id="prenom" name="prenom"><br>
    <label for="grade">Grade:</label>
    <input type="text" id="grade" name="grade"><br>
    <input type="submit" value="Submit">
</form>
</body>
