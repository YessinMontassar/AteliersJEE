<%@page import="beans.Etudiant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage des propriétés du bean </title>
</head>
<body>
<h1> Affichage des étudiants...</h1>
 <%
Etudiant etdRequest = (Etudiant) request.getAttribute("etdRequest"); 
 out.println("Etudiant request : "+etdRequest);
 %>
 <hr>
 <%
 Etudiant etdSession = (Etudiant) session.getAttribute("etdSession"); 
 out.println("Etudiant session : "+etdSession);
 %>
 <hr>
 <%
 Etudiant etdApplication = (Etudiant) application.getAttribute("etdApplication"); 
 out.println("Etudiant application : "+etdApplication);
 
 %>
 
</body>
</html>