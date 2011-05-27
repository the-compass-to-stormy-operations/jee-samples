package br.gov.serpro.persistence.context;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAContext {
	
	private static Map<String, EntityManagerFactory> emf = new HashMap<String, EntityManagerFactory>();
	private static ThreadLocal<Map<String, EntityManager>> em = new ThreadLocal<Map<String,EntityManager>>();
	
	public static void createEntityManagerFactory(String persistenceUnitName) {
		if (!emf.containsKey(persistenceUnitName)) {
			emf.put(persistenceUnitName, Persistence.createEntityManagerFactory(persistenceUnitName));
		}
	}
	
	public static void closeEntityManagerFactory(String persistenceUnitName) {
		if (emf.containsKey(persistenceUnitName)) {
			emf.get(persistenceUnitName).close();
			emf.remove(persistenceUnitName);
		}
	}
	
	public static EntityManager getEntityManager(String persistenceUnitName) {
		if (em.get() == null) {
			em.set(new HashMap<String, EntityManager>());
		}
		
		if (em.get().containsKey(persistenceUnitName)) {
			return em.get().get(persistenceUnitName);
		} else {
			if (emf.containsKey(persistenceUnitName)) {
				EntityManager newEm = emf.get(persistenceUnitName).createEntityManager();
				em.get().put(persistenceUnitName, newEm);
				return newEm;
			} else {
				throw new RuntimeException("Entity Manager Factory to "+persistenceUnitName+" not found");
			}
		} 
	}

}
