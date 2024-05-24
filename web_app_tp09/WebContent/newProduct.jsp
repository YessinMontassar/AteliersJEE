<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un nouveau produit</title>
</head>
<body>
    <h1>Ajouter un nouveau produit</h1>
    <form action="AddProductServlet" method="post">
        <label for="designation">Désignation:</label>
        <input type="text" id="designation" name="designation">
        <br>
        
        <label for="prix">Prix:</label>
        <input type="text" id="prix" name="prix">
        <br>
        
        <label for="quantite">Quantité:</label>
        <input type="text" id="quantite" name="quantite">
        <br>
        
        <label for="dateAchat">Date d'Achat:</label>
        <input type="text" id="dateAchat" name="dateAchat">
        <br>
        
          <label for="categorie">Catégorie:</label>
        <select id="categorie" name="categorie">
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.libelle}</option>
            </c:forEach>
        </select>
        <br>
        
        <input type="submit" value="Ajouter">
    </form>
</body>
</html>
