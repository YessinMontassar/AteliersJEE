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

import domaine.Produit;
import services.ProduitSessionRemote;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	@EJB(lookup ="ejb:/ejb_app_tp09/PR!services.ProduitSessionRemote")
	private ProduitSessionRemote metier;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		Long id = Long.parseLong(request.getParameter("id"));
		String designation = request.getParameter("designation");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateAchat = null;
		try {
		    dateAchat = sdf.parse(request.getParameter("dateAchat"));
		} catch (ParseException e) {
		    e.printStackTrace(); // ou tout autre gestion d'erreur appropriée
		}

		Produit produit = metier.getProduit(id);

		produit.setDesignation(designation);
		produit.setPrix(prix);
		produit.setQuantite(quantite);
		produit.setDateAchat(dateAchat);

		metier.updateProduit(produit);

		request.setAttribute("products", metier.getAllProduits());
		request.getRequestDispatcher("products.jsp").forward(request, response);

    }

}
