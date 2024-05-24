<%@ page language="java" import ="java.util.ArrayList, java.util.Iterator" contentType="text/html;  charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Contenu de votre panier </h1>
<%
ArrayList<String> Produits = (ArrayList<String>) session.getAttribute("Produits");

%>
<ul>
<% for(Iterator<String> it =Produits.iterator(); it.hasNext();)
{%>
<li> <%=it.next()%></li>
<% } %>
</ul>
<form action="ListProduits.jsp" method="post">
        <input type="submit" value="ajouter un autre produit">
    </form>
    <form action="Panier" method="Get">
        <input type="submit" value="Deconnexion">
    </form>

</body>
</html>