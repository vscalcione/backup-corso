package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PRODOTTO_VENDITORE database table.
 * 
 */
@Embeddable
public class ProductSellerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=50)
	private String asin;

	@Column(name="P_IVA", insertable=false, updatable=false, unique=true, nullable=false, length=20)
	private String pIva;

	public ProductSellerPK() {
	}
	public String getAsin() {
		return this.asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
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
		if (!(other instanceof ProductSellerPK)) {
			return false;
		}
		ProductSellerPK castOther = (ProductSellerPK)other;
		return 
			this.asin.equals(castOther.asin)
			&& this.pIva.equals(castOther.pIva);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.asin.hashCode();
		hash = hash * prime + this.pIva.hashCode();
		
		return hash;
	}

}