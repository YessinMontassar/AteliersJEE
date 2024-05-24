package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import domaine.Produit;

@Stateless(name = "PR")
public class ProduitSession implements ProduitSessionLocal, ProduitSessionRemote {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Produit addProduit(Produit p) {
		em.persist(p);
		return p;
	}

	@Override
	public Produit getProduit(Long id) {
		Produit p = (Produit) em.find(Produit.class, id);
		return p;
	}

	@Override
	public List<Produit> getAllProduits() {
		Query sql = em.createQuery("select p from Produit p");
		return sql.getResultList();
	}

	@Override
	public Produit updateProduit(Produit p) {
		Produit pu = (Produit) em.find(Produit.class, p.getId());
		pu.setDateAchat(p.getDateAchat());
		pu.setDesignation(p.getDesignation());
		pu.setPrix(p.getPrix());
		pu.setQuantite(p.getQuantite());
		pu = em.merge(pu);
		return pu;
	}

	@Override
	public void deleteProduit(Long id) {
		Produit pd = (Produit) em.find(Produit.class, id);
		em.remove(pd);
	}
}











