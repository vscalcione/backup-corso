package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RECENSIONE_VENDITORE database table.
 * 
 */
@Embeddable
public class SellerReviewPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=20)
	private String username;

	@Column(name="P_IVA", insertable=false, updatable=false, unique=true, nullable=false, length=20)
	private String pIva;

	public SellerReviewPK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPIva() {
		return this.pIva;
	}
	public void setPIva(String pIva) {
		this.pIva = pIva;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SellerReviewPK)) {
			return false;
		}
		SellerReviewPK castOther = (SellerReviewPK)other;
		return 
			this.username.equals(castOther.username)
			&& this.pIva.equals(castOther.pIva);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.pIva.hashCode();
		
		return hash;
	}

}