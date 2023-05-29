<%@ page import="com.example.projethibernate.entity.Medecin" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.projethibernate.dao.MedecinDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LIST MEDECINS</title>
</head>
<body>
<%!
    private com.example.projethibernate.dao.MedecinDAO MedecinDAO;
%><%
List<Medecin> medecins = MedecinDAO.getAllMedecins();
%>

<table>
    <tr>
        <th>Code</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Grade</th>
    </tr>
    <% for (Medecin medecin : medecins) { %>
        <tr>
            <td><%=medecin.getCodemed()%></td>
            <td><%=medecin.getNom()%></td>
            <td><%=medecin.getPrenom()%></td>
            <td><%=medecin.getGrade()%></td>
        </tr>
    <% } %>
</table>
</body>