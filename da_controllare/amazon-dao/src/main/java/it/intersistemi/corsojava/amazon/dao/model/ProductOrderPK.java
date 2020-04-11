package it.intersistemi.corsojava.amazon.dao.model;

public class ProductOrderPK {
	private Integer numeroOrdine;
	private String asin;
	private String pIva;

	public Integer getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(Integer numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asin == null) ? 0 : asin.hashCode());
		result = prime * result + ((numeroOrdine == null) ? 0 : numeroOrdine.hashCode());
		result = prime * result + ((pIva == null) ? 0 : pIva.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductOrderPK other = (ProductOrderPK) obj;
		if (asin == null) {
			if (other.asin != null)
				return false;
		} else if (!asin.equals(other.asin))
			return false;
		if (numeroOrdine == null) {
			if (other.numeroOrdine != null)
				return false;
		} else if (!numeroOrdine.equals(other.numeroOrdine))
			return false;
		if (pIva == null) {
			if (other.pIva != null)
				return false;
		} else if (!pIva.equals(other.pIva))
			return false;
		return true;
	}

	public ProductOrderPK(Integer numeroOrdine, String asin, String pIva) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.asin = asin;
		this.pIva = pIva;
	}

	public ProductOrderPK() {

	}

	@Override
	public String toString() {
		return "OrdineProdottoPK [numeroOrdine=" + numeroOrdine + ", asin=" + asin + ", pIva=" + pIva + "]";
	}

}
