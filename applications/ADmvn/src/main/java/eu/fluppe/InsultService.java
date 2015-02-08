package eu.fluppe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsultService {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "ADmvn" );
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction tx = entityManager.getTransaction();

	public Insult createInsult(String anInsultString) {
		Insult anInsult = new Insult();
		anInsult.setInsultString(anInsultString);
		
		tx.begin();
		entityManager.persist(anInsult);
		tx.commit();
		return anInsult;
	}
	
	public Insult findInsult(Long id) {
		return entityManager.find(Insult.class, id);
	}
	
	public void removeInsult(Long id) {
		Insult anInsult = entityManager.find(Insult.class, id);
		if(anInsult != null) {
			tx.begin();
			entityManager.remove(anInsult);
			tx.commit();
		}
	}
}
