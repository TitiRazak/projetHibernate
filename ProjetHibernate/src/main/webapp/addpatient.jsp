<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AJOUT PATIENT</title>
</head>
<body>
<form action="listpatients.jsp" method="post">
    <label for="codepat">Code:</label>
    <input type="text" id="codepat" name="codepat"><br>
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom"><br>
    <label for="prenom">Prenom:</label>
    <input type="text" id="prenom" name="prenom"><br>
    <label for="sexe">Sexe:
        <select id="sexe" name="item">
            <option value="M">Male</option>
            <option value="F">Femelle</option>
        </select>
    </label><br>
    <label for="adresse">Adresse:</label>
    <input type="text" id="adresse" name="adresse"><br>
    <input type="submit" value="Submit">
</form>
</body>
