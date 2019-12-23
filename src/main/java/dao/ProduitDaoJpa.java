package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entites.Marque;
import entites.Produit;

public class ProduitDaoJpa implements ProduitDao{

	@Override
	public Produit exist(String libelle) {
		Produit prod = null;
		
		List<Produit> listeP = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT p FROM Produit p where p.nom = ?1" );
		
		query.setParameter(1,libelle);
		
		listeP = query.getResultList();
		
		if(listeP.size()>0){
			
			prod=listeP.get(0);
			
		}
			
		
		em.close();
		emf.close();
				
		
		
		return prod;
	}

	@Override
	public void insert(Produit prod) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();	
		
		em.persist(prod);
		
		et.commit();

		em.close();
		emf.close();
		
	}

}
