package controleur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.CategorieSessionRemote;

/**
 * Servlet implementation class DeleteCategorieServlet
 */
@WebServlet("/DeleteCategorieServlet")
public class DeleteCategorieServlet extends HttpServlet {
	@EJB(lookup ="ejb:/web_app_tp09/CR!services.CategorieSessionRemote")
	private CategorieSessionRemote metier1;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String categorieId = request.getParameter("idc");

        Long id = Long.parseLong(categorieId);

        metier1.deleteCategorie(id);

        request.setAttribute("categories", metier1.getAllCategories());
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
