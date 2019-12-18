package fr.diginamic.banque.entities;

import javax.persistence.*;

@Embeddable
public class Adresse {
	
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "rue", length = 50 , nullable = false)
	private String rue;
	
	@Column(name = "code_postal", nullable = false)
	private int codePostal;

	@Column(name = "ville", length = 50 , nullable = false)
	private String Villes;
	
	public Adresse (){}

	/** Getter
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/** Setter
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/** Getter
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/** Setter
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/** Getter
	 * @return the villes
	 */
	public String getVilles() {
		return Villes;
	}

	/** Setter
	 * @param villes the villes to set
	 */
	public void setVilles(String villes) {
		Villes = villes;
	}
	
}
