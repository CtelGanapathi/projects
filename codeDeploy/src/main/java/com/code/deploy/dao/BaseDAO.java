package com.code.deploy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author <font color="#006400"><b>siva kumar</b></font>
 * 
 */
@Repository
public class BaseDAO<E> {
	
private static final Log log = LogFactory.getLog(BaseDAO.class);
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	/**
	 * 
	 * @param e
	 * @throws RuntimeException
	 */
	public void persist(E e)throws RuntimeException {
		log.info("Persisting Entity Instance");
		/**
		 * Persisting Entity Instance
		 */
		try 
		{
			entityManager.persist(e);
			/**
			 * persist successful
			 */
			log.info("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			/**
			 * persist failed
			 */
			throw re;
		} 
	}
	
	public void remove(E e)throws RuntimeException {
		log.info("Removing Entity Instance");
		/**
		 * Removing Entity Instance
		 */
		try {
			entityManager.remove(e);
			log.info("remove successful");
			/**
			 *remove successful
			 */
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			/**
			 * remove failed
			 */
			throw re;
		}
	}
	
	public E merge(E e)throws RuntimeException 
	{
		log.info("Merging Entity Instance");
		/**
		 * Merging Entity Instance
		 */
		try {
			E result = entityManager.merge(e);
			log.info("merge successful");
			/**
			 * merge successful
			 */
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			/**
			 * merge failed
			 */
			throw re;
		}
	}
	
	public E findById(Class<E> type,Integer id)
	{
		/**
		 * Getting Entity Instance with ID
		 */
		log.info("Getting Entity Instance with ID: " + id);
		E instance = null;
		try {
			instance = entityManager.find(type, id);	
			log.info("get successful");
			/**
			 * get successful
			 */
			return instance;
		} catch (RuntimeException re) {
			/**
			 * get failed
			 */
			log.error("get failed", re);			
		}
		return instance;
	}	
	

}
