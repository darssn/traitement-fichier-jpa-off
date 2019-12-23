package dao;

import entites.Produit;

public interface ProduitDao {
	
	
	/** Verifie si un produit existe dans la bdd
	 * @param libelle
	 * @return un Produit sinon null
	 */
	Produit exist(String libelle); 
	
	/**Ajoute un produit dans la bdd
	 * @param prod
	 */
	void insert(Produit prod);

}
