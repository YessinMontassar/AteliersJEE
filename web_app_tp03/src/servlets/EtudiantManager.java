package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Etudiant;

/**
 * Servlet implementation class EtudiantManager
 */
@WebServlet("/EtudiantManager")
public class EtudiantManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Servlet: EtudiantManager..");
		// création d'un bean Etudiant e
		Etudiant e = new Etudiant();
		e.setNom("Ayyadi");
		e.setPrenom("Slim");
		e.setNumero(1);
		//Stocker le bean "e" dans l'objet "request"
		request.setAttribute("etdRequest", e);
		// création d'un bean Etudiant e2
		Etudiant e2 = new Etudiant();
		e2.setNom("Ben Omar");
		e2.setPrenom("Ali");
		e2.setNumero(2);
		//Stocker le bean "e" dans l'objet "session"
		HttpSession session = request.getSession(true);
		session.setAttribute("etdSession", e2);
		// création d'un bean Etudiant e3
		Etudiant e3 = new Etudiant();
		e3.setNom("Tounsi");
		e3.setPrenom("Samira");
		e3.setNumero(3);
		//Stocker le bean "e" dans l'objet "application" (ServletContext)
		this.getServletContext().setAttribute("etdApplication", e3);
		// passer à la page "affichageEtudiant.jsp"

		 
		this.getServletContext().getRequestDispatcher("/affichageEtudiant.jsp").forward(request, 
		response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
