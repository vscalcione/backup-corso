package it.intersistemi.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the phone database table.
 * 
 */
@Embeddable
public class PhonePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="contacts_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer contactsId;

	public PhonePK() {
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getContactsId() {
		return this.contactsId;
	}
	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PhonePK)) {
			return false;
		}
		PhonePK castOther = (PhonePK)other;
		return 
			(this.id == castOther.id)
			&& (this.contactsId == castOther.contactsId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.contactsId;
		
		return hash;
	}
}