<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des catégories</title>
</head>
<body>
    <h1>Liste des catégories</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Libellé</th>
        </tr>        
        <c:forEach var="categorie" items="${categories}">
            <tr>
                <td>${categorie.id}</td>
                <td>${categorie.libelle}</td>
                <td>
			<form action="EditCategorieServlet" method="get">
			    <input type="hidden" name="idc" value="${categorie.id}">
			    <button type="submit">Modifier</button>
			</form>
			
			<form action="DeleteCategorieServlet" method="post">
			    <input type="hidden" name="idc" value="${categorie.id}">
			    <button type="submit" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce categorie ?')">Supprimer</button>
			</form>
            </td>
            </tr>
        </c:forEach>
    </table>
    <form action="NewCategorieServlet" method="get">
	<button type="submit">Ajouter un nouveau produit</button>
</form>
</body>
</html>
