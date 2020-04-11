package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORDINE_PRODOTTO database table.
 * 
 */
@Embeddable
public class OrderProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUMERO_ORDINE", insertable=false, updatable=false, unique=true, nullable=false)
	private int numeroOrdine;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, length=20)
	private String asin;

	@Column(name="P_IVA", insertable=false, updatable=false, unique=true, nullable=false, length=20)
	private String pIva;

	public OrderProductPK() {
	}
	public int getNumeroOrdine() {
		return this.numeroOrdine;
	}
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
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
		if (!(other instanceof OrderProductPK)) {
			return false;
		}
		OrderProductPK castOther = (OrderProductPK)other;
		return 
			(this.numeroOrdine == castOther.numeroOrdine)
			&& this.asin.equals(castOther.asin)
			&& this.pIva.equals(castOther.pIva);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroOrdine;
		hash = hash * prime + this.asin.hashCode();
		hash = hash * prime + this.pIva.hashCode();
		
		return hash;
	}
}