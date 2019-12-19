package entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**Reprensente un produit
 * */
@Entity
@Table(name="Produit")
public class Produit {
	
	/**id d'un produit sur la bdd
	 * */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	
	/**nom d'un produit
	 * */
	@Column(name="nom")
	private String nom;
	
	/**score nutritionnel d'un produit
	 * */
	@Column(name="score_nutri")
	private String scoreN;
	
	/**Categorie d'un produit represente par l'id de la categorie 
	 * */
	@ManyToOne()
	@JoinColumn(name="id_cat")
	private Categorie categorie;
	
	/**marque d'un produit represente par l'id de la marque
	 * */
	@ManyToOne()
	@JoinColumn(name="id_marque")
	private Marque marque;	
	
	/**Table de jointure avec Ingredient ou les ingredients sont associes a des produits
	 * */
	@ManyToMany
	@JoinTable(name="Ingredient_Produit",
		joinColumns = @JoinColumn(name="id_produit",referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="id_ingredient",referencedColumnName ="id")
					
			)	
	private List<Ingredient> listeI = new ArrayList<>();
	
	
	
	/**Constructeur
	 * */
	
	public Produit(){
		
	}





	/**Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}





	/**Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}





	/**Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}





	/**Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}





	/**Getter
	 * @return the scoreN
	 */
	public String getScoreN() {
		return scoreN;
	}





	/**Setter
	 * @param scoreN the scoreN to set
	 */
	public void setScoreN(String scoreN) {
		this.scoreN = scoreN;
	}





	/**Getter
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}





	/**Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}





	/**Getter
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}





	/**Setter
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}





	/**Getter
	 * @return the listeI
	 */
	public List<Ingredient> getListeI() {
		return listeI;
	}





	/**Setter
	 * @param listeI the listeI to set
	 */
	public void setListeI(List<Ingredient> listeI) {
		this.listeI = listeI;
	}

}
