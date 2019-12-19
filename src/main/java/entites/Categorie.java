package entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Categorie")

public class Categorie {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;

	@Column(name="libelle")
	private String libelle;
	
	@OneToMany(mappedBy="categorie")
	private List<Produit> listeP = new ArrayList<>();
	

	public Categorie() {

	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
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
