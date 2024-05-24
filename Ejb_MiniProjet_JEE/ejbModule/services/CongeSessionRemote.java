package services;

import java.util.List;

import javax.ejb.Remote;
import domaine.Conge;

@Remote
public interface CongeSessionRemote {
    public Conge addConge(Conge conge);
    public Conge updateConge(Conge conge);
    public void deleteConge(Long id);
    public Conge getConge(Long id);
    public List<Conge> getAllConges();
    public List<Conge> getCongesByUtilisateur(Long id);
    public List<Conge> getCongesByEtatorYear(String etat,String year);
    public int getNombreJourRest(Long id);
}
