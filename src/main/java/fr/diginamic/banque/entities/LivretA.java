package fr.diginamic.banque.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("livret_a")
public class LivretA extends Compte {
	
	@Column(name = "taux")
	private double taux;


	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

}
