<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des produits</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Désignation</th>
        <th>Prix</th>
        <th>Quantité</th>
        <th>Date d'Achat</th>
        <th>Catégorie</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.designation}</td>
            <td>${product.prix}</td>
            <td>${product.quantite}</td>
            <td>${product.dateAchat}</td>
            <td>${product.categorie.libelle}</td>
            <td>
			<form action="EditProductServlet" method="get">
			    <input type="hidden" name="id" value="${product.id}">
			    <button type="submit">Modifier</button>
			</form>
			
			<form action="DeleteProductServlet" method="post">
			    <input type="hidden" name="id" value="${product.id}">
			    <button type="submit" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?')">Supprimer</button>
			</form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="NewProductServlet" method="get">
	<button type="submit">Ajouter un nouveau produit</button>
</form>
</body>
</html>