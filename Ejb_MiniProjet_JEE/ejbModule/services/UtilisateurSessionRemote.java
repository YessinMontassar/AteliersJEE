package services;
import java.util.List;
import javax.ejb.Remote;
import domaine.Utilisateur;

@Remote
public interface UtilisateurSessionRemote {
	public Utilisateur addUtilisateur(Utilisateur p);
	public Utilisateur updateUtilisateur(Utilisateur p);
	public void deleteUtilisateur(Long id);
	public Utilisateur getUtilisateur(Long id);
	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur getUtilisateurByLogin(String login,String pwd);

	

}
