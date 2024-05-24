package services;

import java.util.List;
import javax.ejb.Remote;
import domaine.Categorie;

@Remote
public interface CategorieSessionRemote 
{
	public Categorie addCategorie(Categorie c);
	public Categorie updateCategorie(Categorie c);
	public void deleteCategorie(Long id);
	public Categorie getCategorie(Long id);
	public List<Categorie> getAllCategories();
}
