<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Categorie</title>
</head>
<body>
    <h1>Modifier Categorie</h1>
    
    <form action="UpdateCategorieServlet" method="post">
        <input type="hidden" name="idc" value="${categorie.id}">
        
        <label for="designation">Libelle:</label>
        <input type="text" id="libelle" name="libelle" value="${categorie.libelle}">
        <br>
        
        
        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>
