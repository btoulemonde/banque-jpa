package fr.diginamic.banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import fr.diginamic.banque.entities.Adresse;
import fr.diginamic.banque.entities.AssuranceVie;
import fr.diginamic.banque.entities.Banque;
import fr.diginamic.banque.entities.Client;
import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.LivretA;
import fr.diginamic.banque.entities.Operation;
import fr.diginamic.banque.entities.Virement;

public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		//insertion d'un compte associé à 2 clients
		Banque b1 = new Banque();//creation banque
		b1.setNom("CM");
		em.persist(b1);
		
		Client client1 = new Client();//creation client 1
		client1.setAdresse(new Adresse(12, "rue du chèvrefeuille", 34000, "Montpellier"));
		client1.setDateNaissance(LocalDate.of(1987,4,7));
		client1.setNom("Martin");
		client1.setPrenom("Paul");
		em.persist(client1);
		client1.setBanque(b1);
		
		
		Client client2 = new Client();//creation client 2
		client2.setAdresse(client1.getAdresse());
		client2.setDateNaissance(LocalDate.of(1989,8,10));
		client2.setNom("Martin");
		client2.setPrenom("Martine");
		em.persist(client2);
		client2.setBanque(b1);
		
		
		Compte c1 = new Compte();//creation compte
		c1.setNumero("acd1234");
		c1.setSolde(1548.25);
		c1.getClients().add(client1);
		c1.getClients().add(client2);
		em.persist(c1);
		
		//insertion client avec livret a + assurance vie
		
		Banque b2 = new Banque();
		b1.setNom("BP");
		em.persist(b2);
		
		Client client3 = new Client();
		client3.setAdresse(new Adresse(3, "rue de la paix", 75000, "Paris"));
		client3.setNom("Durand");
		client3.setPrenom("Jean");
		client3.setBanque(b2);
		client3.setDateNaissance(LocalDate.of(1980, 11, 30));
		em.persist(client3);
		
		
		LivretA c2 = new LivretA();
		c2.setNumero("abc45784a");
		c2.setTaux(1.02);
		c2.setSolde(10000);
		c2.getClients().add(client3);
		em.persist(c2);
		
		AssuranceVie c3 = new AssuranceVie();
		c3.setNumero("abc4525552784a");
		c3.setTaux(1.2);
		c3.setSolde(5000);
		c3.getClients().add(client3);
		em.persist(c3);
		
		
		Operation vir = new Virement();
		vir.setCompte(c3);
		vir.setDate(LocalDate.of(2019, 12, 05));
		vir.setMontant(2000);
		vir.setMotif("virement mensuel");
		em.persist(vir);
		
		Operation op = new Operation();
		op.setCompte(c2);
		op.setDate(LocalDate.of(2019, 12, 10));
		op.setMontant(1000);
		op.setMotif("blabla");
		em.persist(op);
		
		transaction.commit();
		
		em.close();

	}

}
