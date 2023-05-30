<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Création d'un médecin</title>
</head>
<body>
<h1>Création d'un médecin</h1>

<form action="views/medecin.jsp" method="post">
    <label for="codeMed">Code :</label>
    <input type="text" name="codeMed" id="codeMed"><br>

    <label for="nom">Nom :</label>
    <input type="text" name="nom" id="nom"><br>

    <label for="prenom">Prénom :</label>
    <input type="text" name="prenom" id="prenom"><br>

    <label for="grade">Grade :</label>
    <input type="text" name="grade" id="grade"><br>

    <input type="submit" value="Enregistrer">
</form>
</body>
</html>