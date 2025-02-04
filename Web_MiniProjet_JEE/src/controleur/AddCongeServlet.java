package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Conge;
import domaine.Utilisateur;
import services.CongeSessionRemote;

/**
 * Servlet implementation class AddCongeServlet
 */
@WebServlet("/AddCongeServlet")
public class AddCongeServlet extends HttpServlet {
	@EJB(lookup = "ejb:/Ejb_MiniProjet_JEE/CR!services.CongeSessionRemote")
    private CongeSessionRemote metierC;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCongeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		String description = request.getParameter("description");
		Utilisateur u = (Utilisateur)session.getAttribute("utilisateur");
		Date datedebut = null;
		Date datefin = null;

        try {
        	datedebut = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datedebut"));
        	datefin = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datefin"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = datefin.getTime() - datedebut.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        
        
        LocalDate date1 = ((java.sql.Date) u.getDateEmbauchement()).toLocalDate();
        LocalDate date2 = LocalDate.now();
        Period periode = Period.between(date1, date2);
        int ansDepuisEmbauche = periode.getYears();
        int nbj =(int)session.getAttribute("NbJourConge");
        
         
        
        
        
       if(ansDepuisEmbauche>=1 && nbj - (int)diffDays >= 0 && datedebut.compareTo(datefin)<=0) {
        	Conge conge = new Conge();	
            conge.setDateDebut(datedebut);
            conge.setDateFin(datefin);
            conge.setDescription(description);
            conge.setEtat("SOLLICITE");
           
            conge.setUtilisateur(u);;
            metierC.addConge(conge);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
       }
       else {
    	   response.sendRedirect(request.getContextPath() + "/error.jsp");
       }
       
        
        
        
	}

}
