package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domaine.Produit;
import services.ProduitSessionRemote;

/**
 * Servlet implementation class ClientWebEJBTomcat
 */
@WebServlet("/ClientWebEJBTomcat")
public class ClientWebEJBTomcat extends HttpServlet {
	private static final long serialVersionUID = 1L;
// D�claration de la structure qui contient les propri�t�s:
	Hashtable<String, String> props = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientWebEJBTomcat() {
		super();
// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// R�cup�rer l'objet d'�criture de la r�ponse
		PrintWriter out = response.getWriter();
		out.println("Acc�s au composant EJB � partir de tomcat...<br>");
		try {
// Initialiser le contexte de connextion au serveurEJB (WildFly)
			Context ctx = new InitialContext(props);
// Sp�cifier le nom de publication du bean "ProduitSession" dans JNDI
			String jndiBeanName = "ejb:/ejb_app_tp08/PR!services.ProduitSessionRemote";
// r�cup�rer une r�f�rence au bean distant (comme un proxy)
			ProduitSessionRemote beanRemote = (ProduitSessionRemote) ctx.lookup(jndiBeanName);
//Acc�der aux m�thodes � distance (selon le protocole RMI)
//Cr�er un produit (sans propri�t�s)
			Produit p = new Produit();
//Appeler la m�thode distante 'ajouterProduit'
			beanRemote.addProduit(p);
//Afficher la liste des produits existants dans la BD
			List<Produit> lp = beanRemote.getAllProduits();
			out.println("-------------------");
			for (Produit pi : lp) {
				out.println(pi);
			}
			System.out.println("-------------------");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		out.println("------------------------------<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
//TODO Auto-generated method stub
		super.init(config);
//Charger les prori�t�s utiles
		props = new Hashtable<String, String>();
//propri�t�s du fichier "jndi.properties
		props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
		props.put("endpoint.name", "client-endpoint");
		props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
		props.put("remote.connections", "default");
		props.put("remote.connection.default.host", "127.0.0.1");
		props.put("remote.connection.default.port", "8686");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
	}
}
