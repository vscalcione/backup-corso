package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UTENTE database table.
 * 
 */
@Entity
@Table(name="USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=20)
	private String username;

	@Column(nullable=false, length=255)
	private String email;

	@Column(nullable=false, length=45)
	private String password;

	//bi-directional many-to-one association to Indirizzo
	@OneToMany(mappedBy="utente")
	private List<Address> indirizzi;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getIndirizzi() {
		return this.indirizzi;
	}

	public void setIndirizzi(List<Address> indirizzi) {
		this.indirizzi = indirizzi;
	}

	public Address addIndirizzi(Address indirizzi) {
		getIndirizzi().add(indirizzi);
		indirizzi.setUtente(this);

		return indirizzi;
	}

	public Address removeIndirizzi(Address indirizzi) {
		getIndirizzi().remove(indirizzi);
		indirizzi.setUtente(null);

		return indirizzi;
	}

	@Override
	public String toString() {
		return "Utente [username=" + username + ", email=" + email + ", password=" + password  + "]";
	}

}