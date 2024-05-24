package controller;

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
 * Servlet implementation class ConnexionAction
 */
@WebServlet("/ConnexionAction")
public class ConnexionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionAction() {
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
		doGet(request, response);
		PrintWriter out = response.getWriter();
		//Récupérer la valeur du paramètre login"
		String l = request.getParameter("login");
		//Afficher la valeur du paramètre
		out.println("La valeur du nom est:"+l);
		//Récupérer la valeur du paramètre password"
		String pwd = request.getParameter("password");
		//Afficher la valeur du paramètre
		out.println("La valeur du mot de passe est:"+pwd);
		// Création d'un tableau vide d"erreurs
		ArrayList<String> erreurs =new ArrayList<String>();
		// validation
		String message ="";
		if (l!=null && l.equals(""))
		{
			erreurs.add("Champs login vide. Merci de spécifier une valeur..");
		}
		if (pwd!=null && pwd.equals(""))
		{
		erreurs.add("Champs password vide. Merci de spécifier une valeur..");
		}
		if (erreurs.isEmpty())
		 {
		HttpSession session =request.getSession(true);
		//Placer le login comme un attribut nommé "login" dans l'objet "session"
		session.setAttribute("login", l);
		//Placer le password comme un attribut nommé "password" dans l'objet "session"
		session.setAttribute("password", pwd);
		// Aller à la page d'accueil
		request.getRequestDispatcher("accueil.jsp").forward(request, response);
		}
else
		{
		//Placer le login comme un attribut nommé "login" dans l'objet "request"
		request.setAttribute("login", l);
		//Placer le password comme un attribut nommé "password" dans l'objet "request"
		request.setAttribute("password", pwd);
		//Placer le tableau des erreurs comme attribut "tab_err" dans l'objet "request"
		request.setAttribute("tab_err", erreurs);
		//Se rediriger vers la page "connexion.jsp"
		request.getRequestDispatcher("connexion.jsp").forward(request, response);
		}

	}

}
