package controleur;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ProduitSessionRemote;
import domaine.Produit;
/**
 * Servlet implementation class ShowProductsServlet
 */
@WebServlet("/ShowProductsServlet")
public class ShowProductsServlet extends HttpServlet {
	@EJB(lookup ="ejb:/ejb_app_tp09/PR!services.ProduitSessionRemote")
	private ProduitSessionRemote metier;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductsServlet() {
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
	        
	        request.getRequestDispatcher("products.jsp").forward(request, response);
	 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
