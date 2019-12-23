package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entites.Ingredient;
import entites.Marque;

public class IngredientDaoJpa implements IngredientDao{

	@Override
	public Ingredient exist(String libelle) {
		
		Ingredient ing = null;
		
		List<Ingredient> listeI = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT i FROM Ingredient i where i.libelle = ?1" );
		
		query.setParameter(1,libelle);
		
		listeI = query.getResultList();
		
		if(listeI.size()>0){
			
			ing=listeI.get(0);
			
		}
			
		
		em.close();
		emf.close();
				
		
		
		return ing;
		
	}

	@Override
	public void insert(Ingredient ingredient) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();	
		
		em.persist(ingredient);
		
		et.commit();

		em.close();
		emf.close();
		
	}

}
