package eu.fr.esic.formation.jpa.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.fr.esic.formation.jpa.dao.IUtilisateurDAO;
import eu.fr.esic.formation.jpa.entity.Utilisateur;
//@Repository("UserDAO")
//@Transactional
@Stateless(name="userDAOBean",mappedName="mappedUserDAOBean")
public class UtilisateurDAOImpl extends AbstractEntityImpl<Utilisateur> implements IUtilisateurDAO{

	@PersistenceContext(unitName="tacheUnitDS")
	private EntityManager em;
	public UtilisateurDAOImpl() {
		super(Utilisateur.class);
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> findUtiliateurParSexe(int sexe) {
		String namedQuery = "Utilisateur.findUtilisateurParSexe";
		Query query = this.getEntityManager().createNamedQuery(namedQuery);
		query.setParameter("paramSexe", sexe);
		List<Utilisateur> listeUserParGenre = query.getResultList();
		return listeUserParGenre;
	}


	public Boolean verifSiEmailExiste(Integer idUser, String email) {
		String namedQuery = idUser != null ? "Utilisateur.findEmailEnDoublon":"Utilisateur.findEmailSiExiste" ;
		Query query = this.getEntityManager().createNamedQuery(namedQuery);
		if (idUser != null)
		query.setParameter("paramIdUtilisateur", idUser);
		query.setParameter("paramEmail", email);
		return  query.getResultList().size() > 0;
	}

	@Override
	public EntityManager getEntityManager() {
		return this.em;
	}

}
