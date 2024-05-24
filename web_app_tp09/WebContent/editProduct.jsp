<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Produit</title>
</head>
<body>
    <h1>Modifier Produit</h1>
    
    <form action="UpdateProductServlet" method="post">
        <input type="hidden" name="id" value="${product.id}">
        
        <label for="designation">Désignation:</label>
        <input type="text" id="designation" name="designation" value="${product.designation}">
        <br>
        
        <label for="prix">Prix:</label>
        <input type="text" id="prix" name="prix" value="${product.prix}">
        <br>
        
        <label for="quantite">Quantité:</label>
        <input type="text" id="quantite" name="quantite" value="${product.quantite}">
        <br>
        
        <label for="dateAchat">Date d'Achat:</label>
        <input type="text" id="dateAchat" name="dateAchat" value="${product.dateAchat}">
        <br>
        
        <label for="categorie">Catégorie:</label>
        <input type="text" id="categorie" name="categorie" value="${product.categorie.libelle}">
        <br>
        
        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>
