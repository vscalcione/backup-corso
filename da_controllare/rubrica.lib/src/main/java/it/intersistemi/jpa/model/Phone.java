package it.intersistemi.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phone database table.
 * 
 */
@Entity
@Table(name="phone")
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PhonePK id;

	@Column(nullable=false, length=45)
	private String phone;

	@Column(nullable=false, length=45)
	private String type;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contacts_id", nullable=false, insertable=false, updatable=false)
	private Contact contact;

	public Phone() {
	}

	public PhonePK getId() {
		return this.id;
	}

	public void setId(PhonePK id) {
		this.id = id;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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