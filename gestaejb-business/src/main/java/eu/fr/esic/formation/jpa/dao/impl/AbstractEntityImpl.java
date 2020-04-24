package eu.fr.esic.formation.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import eu.fr.esic.formation.jpa.dao.IAbstractEntityDAO;


@Transactional
public abstract class AbstractEntityImpl<E> implements IAbstractEntityDAO<E>{

    final Class<E> typeParameterClass;
    
	public AbstractEntityImpl(Class<E> typeParameterClass){
		this.typeParameterClass = typeParameterClass;
	} 
	
	public E createUpdateEntity(E entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

	public E getEnityById(Integer idEntity) {
		return this.getEntityManager().find(this.typeParameterClass, idEntity);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		//On vide le cache avant tout 
		this.getEntityManager().clear();
		String entityName = this.typeParameterClass.getSimpleName().toString();
		String reqAllEntity =  "select entity from "+entityName + " entity";
		Query query =  this.getEntityManager().createQuery(reqAllEntity);
		return query.getResultList();
	}

	public void deleteById(Integer idToDelete) {
		E entityToDelete = this.getEnityById(idToDelete);
        this.getEntityManager().remove(entityToDelete);
	}

	public boolean isConEMOpen(){
		return this.getEntityManager() != null && this.getEntityManager().isOpen();
	}
	
	public abstract EntityManager getEntityManager();
}
