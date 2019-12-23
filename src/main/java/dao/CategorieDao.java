package dao;

import entites.Categorie;

public interface CategorieDao {

	/** Verifie si un libelle existe dans la bdd
	 * @param libelle 
	 * @return une Categorie sinon null
	 */
	
	Categorie exist(String libelle);
	
	/** Ajoute une Categorie en bdd
	 * @param cat
	 */
	void insert(Categorie cat);
	
}
