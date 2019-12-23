package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import entites.Marque;

public class MarqueDaoJpa implements MarqueDao {


	@Override
	public Marque exist(String libelle) {
		
		Marque marque = null;
		
		List<Marque> listeM = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT m FROM Marque m where m.libelle = ?1" );
		
		query.setParameter(1,libelle);
		
		listeM = query.getResultList();
		
		if(listeM.size()>0){
			
			marque=listeM.get(0);
			
		}
			
		
		em.close();
		emf.close();
				
		
		
		return marque;
	}

	@Override
	public void insert(Marque marque) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
				
		em.persist(marque);
		
		et.commit();

		em.close();
		emf.close();
		
	}

}
