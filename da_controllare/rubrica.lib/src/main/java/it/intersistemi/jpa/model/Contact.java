package it.intersistemi.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contacts database table.
 * 
 */
@Entity
@Table(name="contacts")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=45)
	private String name;

	@Column(nullable=false, length=45)
	private String surname;

	//bi-directional many-to-one association to Email
	@OneToMany(mappedBy="contact")
	private List<Email> emails;

	//bi-directional many-to-one association to Phone
	@OneToMany(mappedBy="contact")
	private List<Phone> phones;

	public Contact() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Email> getEmails() {
		return this.emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Email addEmail(Email email) {
		getEmails().add(email);
		email.setContact(this);

		return email;
	}

	public Email removeEmail(Email email) {
		getEmails().remove(email);
		email.setContact(null);

		return email;
	}

	public List<Phone> getPhones() {
		return this.phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setContact(this);

		return phone;
	}

	public Phone removePhone(Phone phone) {
		getPhones().remove(phone);
		phone.setContact(null);

		return phone;
	}

}