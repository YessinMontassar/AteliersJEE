package services;

import java.util.List;
import javax.ejb.Local;

import domaine.Categorie;
import domaine.Produit;

@Local
public interface ProduitSessionLocal {
	public Produit addProduit(Produit p);
	public Produit updateProduit(Produit p);
	public void deleteProduit(Long id);
	public Produit getProduit(Long id);
	public List<Produit> getAllProduits();
}
