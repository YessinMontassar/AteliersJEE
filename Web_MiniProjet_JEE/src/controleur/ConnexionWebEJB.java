package controleur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Conge;
import domaine.Utilisateur;
import services.UtilisateurSessionRemote;
import services.CongeSessionRemote;;

/**
 * Servlet implementation class ClientWebEJB
 */@WebServlet("/ConnexionWebEJB")
 public class ConnexionWebEJB extends HttpServlet {
	    @EJB(lookup = "ejb:/Ejb_MiniProjet_JEE/PR!services.UtilisateurSessionRemote")
	    private UtilisateurSessionRemote metier;
	    
	    @EJB(lookup = "ejb:/Ejb_MiniProjet_JEE/CR!services.CongeSessionRemote")
	    private CongeSessionRemote metierC;
	    
	    
	    /**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
		
		}

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession(true);
	        
	        try {
	            String login = request.getParameter("login");
	            String password = request.getParameter("pwd");
	            
	            Utilisateur u = metier.getUtilisateurByLogin(login, password);
	           
	            
	            if (u != null) {
	            	 List<Conge> listConge1 = metierC.getAllConges();
	   	          //Mettre � jours les les etats des Conge au d�marrage
	   	            for(Conge c :listConge1) {
	   	            	LocalDate datedebut = ((Date)c.getDateDebut()).toLocalDate();
	   	            	LocalDate datefin = ((Date)c.getDateFin()).toLocalDate();
	   	            	if(c.getEtat().equals("VALIDE") && datedebut.compareTo(LocalDate.now())>=0 ) {
	   	            		c.setEtat("EN_COURS");
	   	            		metierC.updateConge(c);
	   	            		
	   	            	}
	   	            	if(c.getEtat().equals("EN_COURS") && datefin.compareTo(LocalDate.now())<=0 )
	   	            	{
	   	            		c.setEtat("FINI");
	   	            		metierC.updateConge(c);
	   	            		
	   	            	}
	   	            }
	                
	                if ("EMPLOYE".equals(u.getType())) {
	                    session.setAttribute("utilisateur", u);
	                    int NbJourConge =0;	
	                    List<Conge> listConge = metierC.getCongesByUtilisateur(u.getId());
	                    session.setAttribute("listConge", listConge);
	                    for(Conge c : listConge) {
	                        if(c.getEtat().equals("FINI")) {
	                            LocalDate date1 = ((Date) c.getDateDebut()).toLocalDate();
	                            LocalDate date2 = ((Date) c.getDateFin()).toLocalDate();
	                            Period periode = Period.between(date1, date2);
	                            NbJourConge += periode.getDays() + 1; 
	                        }
	                        if(c.getEtat().equals("ARRETE")) {
	                            LocalDate date1 = ((Date) c.getDateDebut()).toLocalDate();
	                            LocalDate date2 = ((Date) c.getDateRepture()).toLocalDate();
	                            Period periode = Period.between(date1, date2);
	                            NbJourConge += periode.getDays() + 1; 
	                        }
	                        if(c.getEtat().equals("EN_COURS")) {
	                            LocalDate date1 = ((Date) c.getDateDebut()).toLocalDate();
	                            LocalDate date2 = LocalDate.now();
	                            Period periode = Period.between(date1, date2);
	                            NbJourConge += periode.getDays() + 1; 
	                        }
	                    }
	                    session.setAttribute("NbJourConge", NbJourConge);
	                    
	                    
	                    
	                    
	                    
	                    // Redirige vers la page d'accueil
	                    request.getRequestDispatcher("acceuil.jsp").forward(request, response);
	                } else if("ADMIN".equals(u.getType())) {
	                	//redirection ver page admin
	                    out.println("Acc�s admin");
	                }
	            } else {
	                out.println("Utilisateur non trouv�");
	            }
	        } catch (Exception e) {
	            // Gestion des exceptions
	            out.println("Erreur lors de la connexion : " + e.getMessage());
	            e.printStackTrace(out);
	        }
	    }
	}
