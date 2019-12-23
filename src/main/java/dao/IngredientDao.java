package dao;

import entites.Ingredient;

public interface IngredientDao {

	
	/**Verifie si un ingredient existe dans la bdd
	 * @param libelle
	 * @return un Ingredient sinon null
	 */
	Ingredient exist(String libelle);
	
	/**Ajoute un ingredient dans la bdd
	 * @param ingredient
	 */
	void insert(Ingredient ingredient);
}
