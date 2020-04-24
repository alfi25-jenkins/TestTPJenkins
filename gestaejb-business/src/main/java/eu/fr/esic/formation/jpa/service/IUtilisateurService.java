package eu.fr.esic.formation.jpa.service;

import java.util.List;

import eu.fr.esic.formation.jpa.entity.Utilisateur;

/**
 * 
 * @author CHZOME
 *
 */
//@Remote
public interface IUtilisateurService {
	public void save(Utilisateur u);
	public void update(Utilisateur u);
	public Utilisateur getEntityById( Integer id);
	public List<Utilisateur> findAll();
	public void deleteUserById(Integer id);
}
