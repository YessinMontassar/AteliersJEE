package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// validation
		if (l!=null && l.equals("") && l.trim().equals(""))
		{
		out.append("Champs login vide. Merci de spécifier une valeur..");
		}
		if (pwd!=null && pwd.equals(""))
		{
		out.append("Champs password vide. Merci de spécifier une valeur..");
		}
	}

}
