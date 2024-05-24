package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Panier
 */
@WebServlet("/Panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Récupère la session sans en créer une nouvelle si elle n'existe pas déjà

        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("Deconnexion.jsp");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession(true);
	    String P = request.getParameter("P");
	    ArrayList<String> Produits = (ArrayList<String>) session.getAttribute("Produits");
	    if (Produits == null) {
	        Produits = new ArrayList<String>();
	    }
	    Produits.add(P);
	    session.setAttribute("Produits", Produits);
	    response.sendRedirect("Afficher.jsp");
	}


}
