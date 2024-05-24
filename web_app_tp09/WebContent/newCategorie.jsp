<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un nouveau categorie</title>
</head>
<body>
    <h1>Ajouter un nouveau categorie</h1>
    <form action="AddCategorieServlet" method="Post">
        <label for="designation">Libelle:</label>
        <input type="text" id="libelle" name="libelle">
        <br>
        
        
        
        
        <input type="submit" value="Ajouter">
    </form>
</body>
</html>
