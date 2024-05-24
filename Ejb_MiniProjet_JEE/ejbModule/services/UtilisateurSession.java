package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import domaine.Utilisateur;

@Stateless(name = "PR")
public class UtilisateurSession implements UtilisateurSessionLocal, UtilisateurSessionRemote {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Utilisateur addUtilisateur(Utilisateur u) {
		em.persist(u);
		return u;
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		Utilisateur u = (Utilisateur) em.find(Utilisateur.class, id);
		return u;
	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		Query sql = em.createQuery("select u from Utilisateur u");
		return sql.getResultList();
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur u) {
		Utilisateur uu = (Utilisateur) em.find(Utilisateur.class, u.getId());
		uu.setNom(u.getNom());
		uu.setPrenom(u.getPrenom());
		uu.setDateEmbauchement(u.getDateEmbauchement());
		uu.setLogin(u.getLogin());
		uu.setPassword(u.getPassword());
		uu.setType(u.getType());
		
		uu = em.merge(uu);
		return uu;
	}

	@Override
	public void deleteUtilisateur(Long id) {
		Utilisateur ud = (Utilisateur) em.find(Utilisateur.class, id);
		em.remove(ud);
	}

	@Override
	public Utilisateur getUtilisateurByLogin(String login, String pwd) {
		 Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :login AND u.password = :password");
		    query.setParameter("login", login);
		    query.setParameter("password", pwd);

		    List<Utilisateur> resultList = query.getResultList();
		    if (!resultList.isEmpty()) {
		        // Si un utilisateur correspond aux identifiants fournis, retournez le premier élément de la liste
		        return resultList.get(0);
		    } else {
		        // Si aucun utilisateur ne correspond, retournez null
		        return null;
		    }
	}
}