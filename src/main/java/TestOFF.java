import javax.persistence.*;


import javax.persistence.Persistence;

import entites.Categorie;
import entites.Ingredient;
import entites.Marque;
import entites.Produit;

public class TestOFF {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Marque m = new Marque();
		m.setLibelle("azerty");
		
		em.persist(m);
		
		Ingredient i = new Ingredient();
		i.setLibelle("sucre");
		em.persist(i);
		
		Categorie cat = new Categorie();
		cat.setLibelle("pomme");
		em.persist(cat);
		
		
		Produit p = new Produit();
		p.setMarque(m);
		p.getListeI().add(i);
		p.setCategorie(cat);
		
		em.persist(p);
		
		
		et.commit();
		
		em.close();
		emf.close();
		
	}

}
