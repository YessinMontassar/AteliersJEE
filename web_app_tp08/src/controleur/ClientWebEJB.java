package controleur;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ClientWebEJB
 */
@WebServlet("/ClientWebEJB")
public class ClientWebEJB extends HttpServlet {
// injecter une instance d’un bean session qui implémente cette interface
	@EJB(lookup = "ejb:/ejb_app_tp08/PR!services.ProduitSessionRemote")
	private ProduitSessionRemote metier;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientWebEJB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// Récupérer l'objet d'écriture de la réponse
		PrintWriter out = response.getWriter();
		out.println("Accès au composant EJB...<br>");
		// Créer un produit (sans propriétés)
		Produit p = new Produit();
		// Appeler la méthode distante 'ajouterProduit'
		metier.addProduit(p);
		// Afficher la liste des produits existants dans la BD
		List<Produit> lp = metier.getAllProduits();
		out.println("------Liste des produits------<br>");
		for (Produit pi : lp) {
			out.println(pi);
			out.println("<br>");
		}
		out.println("------------------------------<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
