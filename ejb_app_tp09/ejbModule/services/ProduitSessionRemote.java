package services;

import java.util.List;
import javax.ejb.Remote;

import domaine.Categorie;
import domaine.Produit;

@Remote
public interface ProduitSessionRemote 
{
	public Produit addProduit(Produit p);
	public Produit updateProduit(Produit p);
	public void deleteProduit(Long id);
	public Produit getProduit(Long id);
	public List<Produit> getAllProduits();
}
