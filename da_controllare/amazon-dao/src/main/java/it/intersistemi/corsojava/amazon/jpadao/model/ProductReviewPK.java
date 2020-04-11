package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RECENSIONE_PRODOTTO database table.
 * 
 */
@Embeddable
public class ProductReviewPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=20)
	private String username;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=50)
	private String asin;

	public ProductReviewPK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAsin() {
		return this.asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductReviewPK)) {
			return false;
		}
		ProductReviewPK castOther = (ProductReviewPK)other;
		return 
			this.username.equals(castOther.username)
			&& this.asin.equals(castOther.asin);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.asin.hashCode();
		
		return hash;
	}

}