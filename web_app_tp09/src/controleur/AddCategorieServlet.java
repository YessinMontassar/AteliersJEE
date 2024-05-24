package controleur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Categorie;
import services.CategorieSessionRemote;
import services.ProduitSessionRemote;

/**
 * Servlet implementation class AddCategorieServlet
 */
@WebServlet("/AddCategorieServlet")
public class AddCategorieServlet extends HttpServlet {
	@EJB(lookup ="ejb:/ejb_app_tp09/PR!services.ProduitSessionRemote")
	private ProduitSessionRemote metier;
	
	@EJB(lookup ="ejb:/web_app_tp09/CR!services.CategorieSessionRemote")
	private CategorieSessionRemote metier1;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategorieServlet() {
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
		String libelle = request.getParameter("libelle");
		Categorie categorie = new Categorie();
		categorie.setLibelle(libelle);
		metier1.addCategorie(categorie);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
	}

}
