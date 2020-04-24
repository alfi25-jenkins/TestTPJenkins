package eu.fr.esic.formation.jpa.dao;

import java.util.List;

import eu.fr.esic.formation.jpa.entity.Utilisateur;

//@Remote
public interface IUtilisateurDAO extends IAbstractEntityDAO<Utilisateur>{

	/**
	 * Recupère les utilisateurs par sexe
	 * @param sexe : Entier representant le sexe (1 pour Homme et 2 pour femme)
	 * @return
	 */
	public List<Utilisateur> findUtiliateurParSexe(int sexe);
	/**
	 * Verif qu'un email n'existe pas déjà en base
	 * @param idUser : Identifiant fourni dans le cas d'une mise à jour
	 * @param email : Email dont on cherche l'existence en base
	 * @return
	 */
	public Boolean verifSiEmailExiste(Integer idUser,String email);
}
