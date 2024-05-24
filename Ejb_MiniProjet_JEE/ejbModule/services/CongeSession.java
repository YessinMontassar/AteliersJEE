package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import domaine.Conge;

@Stateless(name = "CR")
public class CongeSession implements CongeSessionLocal, CongeSessionRemote {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Conge addConge(Conge conge) {
        em.persist(conge);
        return conge;
    }

    @Override
    public Conge getConge(Long id) {
        Conge conge = em.find(Conge.class, id);
        return conge;
    }

    @Override
    public List<Conge> getAllConges() {
        Query query = em.createQuery("SELECT c FROM Conge c");
        return query.getResultList();
    }

    @Override
    public List<Conge> getCongesByUtilisateur(Long id) {
        Query query = em.createQuery("SELECT c FROM Conge c WHERE c.utilisateur.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
    @Override
    public List<Conge> getCongesByEtatorYear(String etat,String year ) {
    	 StringBuilder jpql = new StringBuilder("SELECT c FROM Conge c WHERE 1=1");

        if (etat != null && !etat.isEmpty()) {
            jpql.append(" AND c.etat = :etat");
        }

        if (year != null && !year.isEmpty()) {
            jpql.append(" AND FUNCTION('YEAR', c.dateDebut) = :year");
        }
        TypedQuery<Conge> query = em.createQuery(jpql.toString(), Conge.class);


        if (etat != null && !etat.isEmpty()) {
            query.setParameter("etat", etat);
        }

        if (year != null && !year.isEmpty()) {
            query.setParameter("year", Integer.parseInt(year));
        }

        return query.getResultList();

    }

    @Override
    public Conge updateConge(Conge conge) {
        Conge existingConge = em.find(Conge.class, conge.getId());
        if (existingConge != null) {
            existingConge.setDescription(conge.getDescription());
            existingConge.setDateDebut(conge.getDateDebut());
            existingConge.setDateFin(conge.getDateFin());
            existingConge.setDateRepture(conge.getDateRepture());
            existingConge.setEtat(conge.getEtat());
            em.merge(existingConge);
            return existingConge;
        }
        return null;
    }

    @Override
    public void deleteConge(Long id) {
        Conge conge = em.find(Conge.class, id);
        if (conge != null) {
            em.remove(conge);
        }
    }

	@Override
	public int getNombreJourRest(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
