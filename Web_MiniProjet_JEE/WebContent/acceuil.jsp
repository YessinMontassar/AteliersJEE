<%@ page language="java" contentType="text/html; charset=UTF-8" import="domaine.Conge"
import ="java.util.List, java.util.Iterator"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des congés</title>
    <!-- Intégration de Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.7.2/font/bootstrap-icons.css" rel="stylesheet">
    
    <!-- Vous pouvez également utiliser une version locale de Bootstrap si nécessaire -->
    <!-- <link href="chemin/vers/bootstrap.min.css" rel="stylesheet"> -->
    <style>
        .sollicite { color: blue; }
        .valide { color: green; }
        .refuse { color: red; }
        .annule { color: orange; } 
        .en_cours { color: purple; } 
        .arrete { color: brown; } 
        .fini { color: teal; } 
    </style>
</head>
<body>
    <!-- Barre de navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Votre Application</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Accueil <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0 justify-content-end">
            <input class="form-control mr-sm-2" type="search" placeholder="Rechercher" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
        </form>
            <form class="form-inline my-2 my-lg-0" action="Deconnexion" method="Get">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Déconnexion</button>
            </form>
        </div>
    </nav>
    <!-- Contenu principal -->
    <div class="container mt-4">
        <h1>Liste des congés</h1>
        
        <form action="CongeWebEJB" method="Post">
        <label for="etat">Filtrer par état :</label>
        <select class="form-select" id="etat" name="etat">
            <option value="">Tous les Conge</option>
            <option value="SOLLICITE">Sollicité</option>
            <option value="VALIDE">Validé</option>
            <option value="REFUSE">Refusé</option>
            <option value="ANNULE">Annulé</option>
            <option value="EN_COURS">En cours</option>
            <option value="ARRETE">Arrêté</option>
            <option value="FINI">Fini</option>
        </select>
        <label for="year">Année :</label>
        <input type="number" name="year" id="year">
        
        <button type="submit">Filtrer</button>
    </form>
    <!-- Bouton "Demande Congé" qui ouvre la fenêtre modale -->
<div style="padding-left: 922px;">
    <button type="button" class="btn btn-outline-secondary btn-lg" data-toggle="modal" data-target="#exampleModal">Demande Congé</button>
</div>
 <div>
        <h2 style="color:red;">Nombre jours restant :<%= 30-(int)session.getAttribute("NbJourConge") %></h2>
        </div>
        
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Description</th>
                    <th scope="col">Date de début</th>
                    <th scope="col">Date de fin</th>
                    <th scope="col">Date de repture</th>
                    <th scope="col">État</th>
                     <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Conge> listConge = (List<Conge>) session.getAttribute("listConge");
                if (listConge != null) {
                    for (Conge conge : listConge) {
                    %>
                    <tr>
                        <td><%= conge.getId() %></td>
                        <td><%= conge.getDescription() %></td>
                        <td><%= conge.getDateDebut() %></td>
                        <td><%= conge.getDateFin() %></td>
                        <td><%= conge.getDateRepture() %></td>
						<td class="<%= conge.getEtat().toLowerCase() %>">
						    <%= conge.getEtat() %>
						    
						</td>  
						<td><% if ("SOLLICITE".equals(conge.getEtat())) { %>
								    <form action="DeleteConge" method="Get">
								    <input type="hidden" name="id" value="<%=conge.getId()%>">
								    <button class="btn btn-danger" type="submit" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce Conge ?')">Supprimer</button>
								</form>
								<br/>
								
								    <input type="hidden" name="id" value="<%=conge.getId()%>">
								    <button type="button" class="btn btn-info " data-toggle="modal" data-target="#exampleModal1">Modifier</button>
								
								
								<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modifier Congé</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="UpdateConge" method="post">
                    <div class="form-group">
                    <input type="hidden" name="id" value="<%= conge.getId() %>">
                        <label for="description">Description:</label>
                        <input value="<%= conge.getDescription() %>" type="text" class="form-control" id="designation" name="description">
                    </div>
                    
                    <div class="form-group">
                        <label for="datedebut">Date Debut:</label>
                        <input value="<%= conge.getDateDebut() %>" type="date" class="form-control" id="datedebut" name="datedebut">
                    </div>
                    
                    <div class="form-group">
                        <label for="datefin">Date Fin:</label>
                        <input value="<%= conge.getDateFin() %>" type="date" class="form-control" id="datefin" name="datefin">
                    </div>
            
               
                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                </form>
            </div>
        </div>
    </div>
</div>
						        
						    <% } %></td>                 
						 </tr>
                    <% 
                    }
                } else {
                %>
                <tr>
                    <td colspan="5">Aucun congé trouvé.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
       
        <div style="padding-left:922px;">
         
       
       
        </div>
        
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Demander un nouveau Congé</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="AddCongeServlet" method="post">
                    <div class="form-group">
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
               
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </form>
            </div>
        </div>
    </div>
</div>


        
        <!-- Ajoutez ici votre contenu pour la demande de congé -->
    </div>
    <!-- Intégration du JavaScript de Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Vous pouvez également utiliser une version locale du JavaScript de Bootstrap si nécessaire -->
    <!-- <script src="chemin/vers/bootstrap.min.js"></script> -->
</body>
</html>
