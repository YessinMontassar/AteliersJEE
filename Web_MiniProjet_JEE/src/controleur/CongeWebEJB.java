package controleur;

import java.io.IOException;
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
import services.CongeSessionRemote;

/**
 * Servlet implementation class CongeWebEJB
 */
@WebServlet("/CongeWebEJB")
public class CongeWebEJB extends HttpServlet {
	@EJB(lookup = "ejb:/Ejb_MiniProjet_JEE/CR!services.CongeSessionRemote")
    private CongeSessionRemote metierC;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CongeWebEJB() {
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
		doGet(request, response);
		 HttpSession session = request.getSession(true);
		 Utilisateur u = (Utilisateur)session.getAttribute("utilisateur");
	
		 String etat = request.getParameter("etat");
		 String year = request.getParameter("year");
		
	            

		 if(etat.equals("") && year.equals("")) {
			 List<Conge> listConge = metierC.getCongesByUtilisateur(u.getId());
			 request.getSession().setAttribute("listConge", listConge);
		 }
		 else
		 {
			 List<Conge> listConge = metierC.getCongesByEtatorYear(etat, year);
			 request.getSession().setAttribute("listConge", listConge);
		 }
		    
		    
		    request.getRequestDispatcher("acceuil.jsp").forward(request, response);
	}

}
