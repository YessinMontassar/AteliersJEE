package controleur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Categorie;
import services.CategorieSessionRemote;

/**
 * Servlet implementation class ShowCategoriesServlet
 */
@WebServlet("/ShowCategoriesServlet")
public class ShowCategoriesServlet extends HttpServlet {
	@EJB(lookup ="ejb:/web_app_tp09/CR!services.CategorieSessionRemote")
	private CategorieSessionRemote metier;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCategoriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  	List<Categorie> categories = metier.getAllCategories();
	        request.setAttribute("categories", categories);
	        request.getRequestDispatcher("categories.jsp").forward(request, response);	
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
