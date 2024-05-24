package controleur;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Conge;
import services.CongeSessionRemote;

/**
 * Servlet implementation class UpdateConge
 */
@WebServlet("/UpdateConge")
public class UpdateConge extends HttpServlet {
	@EJB(lookup = "ejb:/Ejb_MiniProjet_JEE/CR!services.CongeSessionRemote")
    private CongeSessionRemote metierC;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConge() {
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
		Long id = Long.parseLong(request.getParameter("id"));
		String description = request.getParameter("description");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datedebut = null;
		Date datefin = null;
		try {
			datedebut = sdf.parse(request.getParameter("datedebut"));
			datefin = sdf.parse(request.getParameter("datefin"));
		} catch (ParseException e) {
		    e.printStackTrace(); // ou tout autre gestion d'erreur appropriée
		}
		Conge conge = metierC.getConge(id);
		conge.setDateDebut(datedebut);
		conge.setDateFin(datefin);
		conge.setDescription(description);
		metierC.updateConge(conge);
	}

}
