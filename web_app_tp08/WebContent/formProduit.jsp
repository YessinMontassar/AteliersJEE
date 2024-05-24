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
    <form action="FormProduitController" method="post">
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
        
         
        <br>
        
        <input type="submit" value="Ajouter">
    </form>
</body>
</html>
