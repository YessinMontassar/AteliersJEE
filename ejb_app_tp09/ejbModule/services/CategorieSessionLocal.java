package services;

import java.util.List;
import javax.ejb.Local;
import domaine.Categorie;

@Local
public interface CategorieSessionLocal {
	public Categorie addCategorie(Categorie c);
	public Categorie updateCategorie(Categorie c);
	public void deleteCategorie(Long id);
	public Categorie getCategorie(Long id);
	public List<Categorie> getAllCategories();
}
