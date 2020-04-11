package it.intersistemi.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the email database table.
 * 
 */
@Entity
@Table(name="email")
@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmailPK id;

	@Column(nullable=false, length=250)
	private String email;

	@Column(nullable=false, length=45)
	private String type;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contacts_id", nullable=false, insertable=false, updatable=false)
	private Contact contact;

	public Email() {
	}

	public EmailPK getId() {
		return this.id;
	}

	public void setId(EmailPK id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}