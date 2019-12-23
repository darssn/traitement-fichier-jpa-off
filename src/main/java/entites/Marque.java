package entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**Represente une marque
 * */

@Entity
@Table(name="Marque")
public class Marque {
	
	/**id de la marque sur la bdd
	 * */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;

	/**libelle de la marque
	 * */
	@Column(name="libelle")
	private String libelle;
	
	/**liste de produit dont la marque correspond
	 * */
	@OneToMany(mappedBy="marque")
	private List<Produit> listeP = new ArrayList<>();
	
	/**Constructeur
	 * */
	public Marque(){
		
	}
	
	
	public Marque(String libelle){
		
		this.libelle =libelle;
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
