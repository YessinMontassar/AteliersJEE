<%@ page language="java" import="domaine.Produit"
import ="java.util.ArrayList, java.util.Iterator"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des produits</h1>
<table border="1">
 <% ArrayList<Produit> products = (ArrayList<Produit>)request.getAttribute("products"); %>
    <tr>
        <th>ID</th>
        <th>Désignation</th>
        <th>Prix</th>
        <th>Quantité</th>
        <th>Date d'Achat</th>
    </tr>
    <% for ( Produit product : products) { %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getDesignation() %></td>
            <td><%= product.getPrix() %></td>
            <td><%= product.getQuantite() %></td>
            <td><%= product.getDateAchat() %></td>
        </tr>
    <% } %>
</table>

<a href="formProduit.jsp">
    <button type="submit">Ajouter un nouveau produit</button>
</a>
</body>
</html>
