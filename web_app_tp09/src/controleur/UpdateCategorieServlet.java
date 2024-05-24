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

/**
 * Servlet implementation class UpdateCategorieServlet
 */
@WebServlet("/UpdateCategorieServlet")
public class UpdateCategorieServlet extends HttpServlet {
	@EJB(lookup ="ejb:/web_app_tp09/CR!services.CategorieSessionRemote")
	private CategorieSessionRemote metier1;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategorieServlet() {
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
		Long id = Long.parseLong(request.getParameter("idc"));
		String libelle = request.getParameter("libelle");
		Categorie categorie =metier1.getCategorie(id);
		categorie.setLibelle(libelle);
		metier1.updateCategorie(categorie);
		request.setAttribute("categories", metier1.getAllCategories());
		request.getRequestDispatcher("categories.jsp").forward(request, response);
		
	}

}
