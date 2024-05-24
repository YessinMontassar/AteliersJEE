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

import domaine.Categorie;
import domaine.Produit;
import services.CategorieSessionRemote;
import services.ProduitSessionRemote;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	@EJB(lookup ="ejb:/ejb_app_tp09/PR!services.ProduitSessionRemote")
	private ProduitSessionRemote metier;
	
	@EJB(lookup ="ejb:/web_app_tp09/CR!services.CategorieSessionRemote")
	private CategorieSessionRemote metier1;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		 String designation = request.getParameter("designation");
	        double prix = Double.parseDouble(request.getParameter("prix"));
	        int quantite = Integer.parseInt(request.getParameter("quantite"));
	        Date dateAchat = null;
	        try {
	            dateAchat = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateAchat"));
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        Long categorieId = Long.parseLong(request.getParameter("categorie"));
	        Categorie categorie = metier1.getCategorie(categorieId);

	        Produit produit = new Produit();
	        produit.setDesignation(designation);
	        produit.setPrix(prix);
	        produit.setQuantite(quantite);
	        produit.setDateAchat(dateAchat);
	        produit.setCategorie(categorie);

	        metier.addProduit(produit);

	        response.sendRedirect(request.getContextPath() + "/index.jsp");


		}	

}
