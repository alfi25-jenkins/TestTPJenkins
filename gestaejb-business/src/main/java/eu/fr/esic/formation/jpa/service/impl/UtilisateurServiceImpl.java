package eu.fr.esic.formation.jpa.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import eu.fr.esic.formation.jpa.dao.IUtilisateurDAO;
import eu.fr.esic.formation.jpa.entity.Utilisateur;
import eu.fr.esic.formation.jpa.service.IUtilisateurService;

/**
 * 
 * @author CHZOME
 *
 */
//@Service("UserService") 
//@Transactional
@Stateless(name="userServiceBean",mappedName="mappedUserServiceBean")
public class UtilisateurServiceImpl implements IUtilisateurService{

	@EJB(lookup="java:module/userDAOBean")
	private IUtilisateurDAO userDAO = null;
	
	
	public void save(Utilisateur u) {
		this.userDAO.createUpdateEntity(u);
	}

	public Utilisateur getEntityById(Integer id) {
		// TODO Auto-generated method stub
		return this.userDAO.getEnityById(id);
	}

	public List<Utilisateur> findAll() {
		return this.userDAO.findAll();
	}

	public void update(Utilisateur u) {
		Utilisateur userToSave = this.userDAO.getEnityById(u.getIdUtilisateur());
		userToSave.setCodeDepartement(u.getCodeDepartement());
		userToSave.setCodePostal(u.getCodePostal());
		userToSave.setEmail(u.getEmail());
		userToSave.setNom(u.getNom());
		userToSave.setPassword(u.getPassword());
		userToSave.setPrenom(u.getPrenom());
		userToSave.setSexe(u.getSexe());
		this.userDAO.createUpdateEntity(userToSave);
	}

	public void deleteUserById(Integer id) {
		this.userDAO.deleteById(id);
	}

}
