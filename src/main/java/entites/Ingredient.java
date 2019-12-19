package entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Ingredient")
public class Ingredient {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;

	@Column(name="libelle")
	private String libelle;
	
	@ManyToMany
	@JoinTable(name="Ingredient_Produit",
		joinColumns = @JoinColumn(name="id_ingredient",referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="id_produit",referencedColumnName ="id")
					
			)	
	private List<Produit> listeP = new ArrayList<>();
	
	
	
	public Ingredient(){
		
		
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
