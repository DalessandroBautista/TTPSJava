package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.GenericDAO;

import java.util.List;

import javax.persistence.*;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	protected Class<T> clasePersistente;
	//private EntityManager em;
	
	public GenericDAOHibernateJPA(Class<T> clase) {
		clasePersistente = clase;
	}
	
	@Override
	public T recuperar(Long id){
		T entity = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<T> query = em.createQuery("select e from " +  getPersistentClass().getSimpleName() + " where id = ?1", clasePersistente);
			query.setParameter(1, id);
			entity = query.getSingleResult();
		}
		catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		finally {
			em.close();
		}
		return entity;
	}
	
	@Override
	public void guardar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		}
		catch (Exception e){
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		finally {
			em.close();
		}
	}
	
	public Class<T> getPersistentClass(){
		return this.clasePersistente;
	}
	
	public void setPersitentClass(Class<T> clase) {
		this.clasePersistente = clase;
	}
	
	public EntityManager getEntityManager() {
		EntityManager em = EMF.getEMF().createEntityManager();
		return em;
	}
	
	/*public void setEntityManager(EntityManager em){
		EntityManager em = EMF.getEMF().createEntityManager();
		this.em = em;
	}*/
	
	@Override
	public void actualizar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager(); 
		EntityTransaction etx= em.getTransaction();
		 etx.begin();
		 em.merge(entity);
		 etx.commit();
		 em.close();
		 }
	
	@Override
	public void borrar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
	 try {
		 tx = em.getTransaction();
		 tx.begin();
		 em.remove(em.merge(entity));
		 tx.commit();
	 }
	 catch (RuntimeException e) {
		 if ( tx != null && tx.isActive() ) tx.rollback();
		 throw e; // escribir en un log o mostrar un mensaje
	 } finally {
		 em.close();
	 }
	}
	
	public List<T> recuperarTodos(String columnOrder){
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta= em.createQuery("select e from "+ getPersistentClass().getSimpleName()+" e order by e."+columnOrder);
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}
	
}