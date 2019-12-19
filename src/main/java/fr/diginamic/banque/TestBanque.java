package fr.diginamic.banque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.close();

	}

}
