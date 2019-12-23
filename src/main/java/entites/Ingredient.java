package entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**Represente un ingredient
 * */
@Entity
@Table(name="Ingredient")
public class Ingredient {
	
	/**id d'un ingredient sur la bdd
	 * */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;

	/**libelle d'un ingredient
	 * */
	@Column(name="libelle")
	private String libelle;
	
	/**Table de jointure avec Produit ou les ingredients sont associes a des produits
	 * */
	@ManyToMany
	@JoinTable(name="Ingredient_Produit",
		joinColumns = @JoinColumn(name="id_ingredient",referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="id_produit",referencedColumnName ="id")
					
			)	
	private List<Produit> listeP = new ArrayList<>();
	
	/**Constructeur
	 * */
	
	public Ingredient(){
		
		
	}
	
	public Ingredient(String libelle){
		this.libelle = libelle;
	}

	
	/** Extrait une liste de produit a partir d'une chaine de caractere
	 * @param ligne
	 * @return
	 */
	public static List<Ingredient> listeProduit(String ligne){
	
			
		
		List<Ingredient> liste = new ArrayList<>();
		
		String[]m = ligne.split(",");
		
		for(int i = 0 ; i <m.length;i++){
			
			liste.add(new Ingredient(m[i].trim()));
					
		}
	
		return liste;
						
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}



	/**Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	/**Getter
	 * @return the listeP
	 */
	public List<Produit> getListeP() {
		return listeP;
	}



	/**Setter
	 * @param listeP the listeP to set
	 */
	public void setListeP(List<Produit> listeP) {
		this.listeP = listeP;
	}
	

}
