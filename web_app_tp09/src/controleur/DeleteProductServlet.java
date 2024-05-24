package controleur;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ProduitSessionRemote;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    @EJB(lookup ="ejb:/ejb_app_tp09/PR!services.ProduitSessionRemote")
    private ProduitSessionRemote metier;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");

        Long id = Long.parseLong(productId);

        metier.deleteProduit(id);

        request.setAttribute("products", metier.getAllProduits());
		request.getRequestDispatcher("products.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        doGet(request, response);
    }
}
