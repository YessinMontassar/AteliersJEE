package presentation;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
// utilisation des comosants du projet EJB
import domaine.Produit;
import services.ProduitSessionRemote;

public class ClientEJBRemote {
	public static void main(String[] args) {
		try {
//Initialiser le contexte de connextion au serveur EJB (WildFly)
			Context ctx = new InitialContext();
//Sp�cifier le nom de publication du bean "ProduitSession" dans JNDI
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
			System.out.println("-------------------");
			for (Produit pi : lp) {
				System.out.println(pi);
			}
			System.out.println("-------------------");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}