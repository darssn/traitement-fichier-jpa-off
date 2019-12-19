package entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * Represente une Categorie
 */
@Entity
@Table(name = "Categorie")
public class Categorie {

	
	/**
	 * id de la categorie sur la bdd
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	/**
	 * libelle de la categorie
	 */
	@Column(name = "libelle")
	private String libelle;

	/**liste de produits dont la categorie correspond
	 * */
	@OneToMany(mappedBy = "categorie")
	private List<Produit> listeP = new ArrayList<>();

	/**Constructeur
	 * */
	public Categorie() {

	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the listeP
	 */
	public List<Produit> getListeP() {
		return listeP;
	}

	/**
	 * Setter
	 * 
	 * @param listeP
	 *            the listeP to set
	 */
	public void setListeP(List<Produit> listeP) {
		this.listeP = listeP;
	}

}
