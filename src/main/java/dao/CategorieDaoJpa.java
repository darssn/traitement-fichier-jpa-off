package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import entites.Categorie;

public class CategorieDaoJpa implements CategorieDao {
	

	@Override
	public Categorie exist(String libelle) {
		
		Categorie cat = null;
		
		List<Categorie> listeC = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT c FROM Categorie c where c.libelle = ?1" );
		
		query.setParameter(1,libelle);
		
		listeC = query.getResultList();
		

		
		if(listeC.size()>0){
			
		
			cat=listeC.get(0);
			
		}
			
		
		em.close();
		emf.close();
				
		
		
		return cat;
	}

	@Override
	public void insert(Categorie cat) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();	
		
		em.persist(cat);
		
		et.commit();

		em.close();
		emf.close();
		
		
		
	}
	
	
	

}
