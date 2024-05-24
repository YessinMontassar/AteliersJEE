package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domaine.Categorie;

@Stateless (name ="CR")
public class CategorieSession implements CategorieSessionLocal, CategorieSessionRemote{

	@PersistenceContext
	private EntityManager em ;
	
	@Override
	public Categorie addCategorie(Categorie c) {
		em.persist(c);
		return c;
	}

	@Override
	public Categorie getCategorie(Long id) {
		Categorie c =(Categorie)em.find(Categorie.class, id);
		return c;
	}

	@Override
	public List<Categorie> getAllCategories() {
		Query sql = em.createQuery("select c from Categorie c");
		return sql.getResultList();
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		Categorie cu =(Categorie)em.find(Categorie.class, c.getId());
		cu.setLibelle(c.getLibelle());
		cu=em.merge(cu);
		return cu;
	}

	@Override
	public void deleteCategorie(Long id) {
		Categorie cd =(Categorie)em.find(Categorie.class, id);
		em.remove(cd);
	}
}
