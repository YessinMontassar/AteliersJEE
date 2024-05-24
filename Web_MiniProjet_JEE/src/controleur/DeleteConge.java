package controleur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Utilisateur;
import services.CongeSessionRemote;

/**
 * Servlet implementation class DeleteConge
 */
@WebServlet("/DeleteConge")
public class DeleteConge extends HttpServlet {
	@EJB(lookup = "ejb:/Ejb_MiniProjet_JEE/CR!services.CongeSessionRemote")
    private CongeSessionRemote metierC;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteConge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String congeId = request.getParameter("id");

        Long id = Long.parseLong(congeId);
        metierC.deleteConge(id);
        Utilisateur u = (Utilisateur)session.getAttribute("utilisateur");
        session.setAttribute("listConge", metierC.getCongesByUtilisateur(u.getId()));
		request.getRequestDispatcher("acceuil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
