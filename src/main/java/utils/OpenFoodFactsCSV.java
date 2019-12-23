package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.CategorieDaoJpa;
import dao.IngredientDaoJpa;
import dao.MarqueDaoJpa;
import dao.ProduitDaoJpa;
import entites.Categorie;
import entites.Ingredient;
import entites.Marque;
import entites.Produit;

public class OpenFoodFactsCSV {

	private static final Logger LOG = LoggerFactory.getLogger(OpenFoodFactsCSV.class);

	/**
	 * Convertit les donnees du .csv dans une BDD
	 * 
	 * @param path
	 * @return
	 */
	public boolean Convert() {

		String path = ClassLoader.getSystemClassLoader().getResource("open-food-facts.csv").getFile();

		List<String> liste = new ArrayList<>();

		try {
			File file = new File(path);
			liste = FileUtils.readLines(file, "UTF-8");

			// On supprime la ligne d'entéte avec les noms des colonnes
			liste.remove(0);

			for (String ligne : liste) {

				ajoutLigneBDD(ligne);
			}

		} catch (IOException e) {

			LOG.error(e.getMessage());

			return false;
		}

		return true;

	}

	/**
	 * Ajout d'une ligne du .csv dans la BDD
	 * 
	 * @param ligne
	 */
	public static void ajoutLigneBDD(String ligne) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OFF");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		CategorieDaoJpa catDao = new CategorieDaoJpa();
		MarqueDaoJpa marqueDao = new MarqueDaoJpa();
		ProduitDaoJpa prodDao = new ProduitDaoJpa();
		IngredientDaoJpa ingDao = new IngredientDaoJpa();

		et.begin();

		String m1 = ligne.replace('|', '@');

		m1 = m1.replace('[', ' ');
		m1 = m1.replace(']', ' ');

		String[] m = m1.split("@");

		String nom = m[2];
		String scoreN = m[3];

		Produit prod = new Produit(nom, scoreN);

		Categorie cat = new Categorie(m[0]);

		Marque marque = new Marque(m[1]);
		
		List<Ingredient> listIng = Ingredient.listeProduit(m[4]);
		
		
		
		

		if (prodDao.exist(nom) == null) {

			if (catDao.exist(cat.getLibelle()) == null) {

				catDao.insert(cat);
				
				cat = catDao.exist(cat.getLibelle());

			} else {

				cat = catDao.exist(cat.getLibelle());

			}

			if (marqueDao.exist(marque.getLibelle()) == null) {

				marqueDao.insert(marque);
				
				marque = marqueDao.exist(marque.getLibelle());

			} else {

				marque = marqueDao.exist(marque.getLibelle());

			}
			
			int count = 0 ;
			for(Ingredient ing : listIng){
				
				if(ingDao.exist(ing.getLibelle()) == null){
					
					ingDao.insert(ing);
					
					listIng.get(count).setId(ingDao.exist(ing.getLibelle()).getId());
					
				}else{
					
					listIng.get(count).setId(ingDao.exist(ing.getLibelle()).getId());
					
				}
				
				count++;
			}
			
			
			prod.setCategorie(cat);
			prod.setListeI(listIng);
			prod.setMarque(marque);

			em.persist(prod);

			et.commit();
			
			
		}

		

		em.close();
		emf.close();

	}

}
