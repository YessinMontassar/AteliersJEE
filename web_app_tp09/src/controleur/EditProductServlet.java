package controleur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Produit;
import services.ProduitSessionRemote;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	@EJB(lookup ="ejb:/ejb_app_tp09/PR!services.ProduitSessionRemote")
	private ProduitSessionRemote metier;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId = request.getParameter("id");
	    
	    Produit product = metier.getProduit(Long.parseLong(productId));
	    
	    request.setAttribute("product", product);
	    request.getRequestDispatcher("editProduct.jsp").forward(request, response);	
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
