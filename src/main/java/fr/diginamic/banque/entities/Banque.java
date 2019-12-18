package fr.diginamic.banque.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="banque")
public class Banque {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="banque")
	private List<Client> clients;
	
	public Banque(){}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/** Setter
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


}
