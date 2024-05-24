<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demander un nouveau Conge</title>
    <!-- Inclure les fichiers CSS Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Demander un nouveau conge</h1>
        <form action="AddCongeServlet" method="post">
            <div class="form-group mt-3">
                <label for="description">Description:</label>
                <input type="text" class="form-control" id="designation" name="description">
            </div>
            
            <div class="form-group">
                <label for="datedebut">Date Debut:</label>
                <input type="date" class="form-control" id="datedebut" name="datedebut">
            </div>
            
            <div class="form-group">
                <label for="datefin">Date Fin:</label>
                <input type="date" class="form-control" id="datefin" name="datefin">
            </div>
       
            <button type="submit" class="btn btn-primary mt-3">Ajouter</button>
        </form>
    </div>

    <!-- Inclure les fichiers JavaScript Bootstrap (jQuery requis avant) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
