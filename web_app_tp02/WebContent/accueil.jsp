<%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Connexion</title>
<link rel ="stylesheet" type ="text/css" 
href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
<% String login = (String) session.getAttribute("login");
 String password = (String) session.getAttribute("password");
 //tester l'existence des attributs dans la session
 if ((login==null) || (password==null))
{
 //retourner à la page d'authentification
 request.getRequestDispatcher("connexion.jsp").forward(request, response);
}
%>
<div>
BienVenue: <%=login %>
</div>
</body>
</html>