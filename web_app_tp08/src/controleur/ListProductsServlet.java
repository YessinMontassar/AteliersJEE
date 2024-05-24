package controleur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Produit;
import services.ProduitSessionRemote;

/**
 * Servlet implementation class ListProductsServlet
 */
@WebServlet("/ListProductsServlet")
public class ListProductsServlet extends HttpServlet {
	@EJB(lookup ="ejb:/ejb_app_tp08/PR!services.ProduitSessionRemote")
	private ProduitSessionRemote metier;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Produit> products = metier.getAllProduits();
        
        request.setAttribute("products", products);
        
        request.getRequestDispatcher("ListProduits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
