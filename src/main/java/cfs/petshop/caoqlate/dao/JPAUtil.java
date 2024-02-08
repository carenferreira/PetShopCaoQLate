package cfs.petshop.caoqlate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
