<%@ page language="java" contentType="text/html; charset=UTF-8" import="javax.naming.InitialContext, services.CongeSession" pageEncoding="UTF-8"%>
<%@ page import="java.util.Hashtable" %>
<%
    try {
        // Initialisation du contexte JNDI
        Hashtable<String, String> env = new Hashtable<>();
        env.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
        InitialContext context = new InitialContext(env);

        // Recherche du bean de session CongeSession
        CongeSession congeSession = (CongeSession) context.lookup("CongeSessionRemote");

        // Récupération de l'identifiant du congé à supprimer depuis les paramètres de requête
        String idConge = request.getParameter("id");

        // Vérification de la validité de l'identifiant du congé
        if (idConge != null && !idConge.isEmpty()) {
        	Long id = Long.parseLong(idConge);

            // Appel de la méthode de suppression du congé
            congeSession.deleteConge(id);

            // Redirection vers une autre page après la suppression
            response.sendRedirect("acceuil.jsp");
        } else {
            // Gestion des erreurs si l'identifiant est invalide
            out.println("Identifiant du congé non valide.");
        }
    } catch (Exception e) {
        // Gestion des erreurs éventuelles
        out.println("Erreur lors de la suppression du congé : " + e.getMessage());
    }
%>
