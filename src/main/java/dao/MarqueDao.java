package dao;

import entites.Marque;

public interface MarqueDao {

	
	/** Verifie si une marque existe dans la bdd
	 * @param libelle
	 * @return une Marque sinon null
	 */
	Marque exist(String libelle); 
	
	/** Ajoute une marque dans la bdd
	 * @param marque
	 */
	void insert(Marque marque);
}
