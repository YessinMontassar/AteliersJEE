package services;

import java.util.List;

import javax.ejb.Local;
import domaine.Conge;

@Local
public interface CongeSessionLocal {
    public Conge addConge(Conge conge);
    public Conge updateConge(Conge conge);
    public void deleteConge(Long id);
    public Conge getConge(Long id);
    public List<Conge> getAllConges();
    public List<Conge> getCongesByUtilisateur(Long id);
    public List<Conge> getCongesByEtatorYear(String etat,String year);
    public int getNombreJourRest(Long id);
}

