<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Scope</title></head>
<body>
BienVenue: <br>
<%
//utiliser les variables pré-définies (request, session, application)
 String prenom = request.getParameter("prenom");
//Afficher les valeus 
out.println("depuis la requete :"+prenom+"<br>");
out.println("depuis la session:"+(String)session.getAttribute("prenom")+"<br>");
out.println("depuis le contexte:"+(String)application.getAttribute("prenom")+"<br>");
%>
</body></html>