package it.intersistemi.corsojava.amazon.dao.model;

public class SellerProduct {
	private SellerProductPK id;
	private Double prezzo;
	private Integer pezziDisponibili;

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getPezziDisponibili() {
		return pezziDisponibili;
	}

	public void setPezziDisponibili(Integer pezziDisponibili) {
		this.pezziDisponibili = pezziDisponibili;
	}

	public SellerProductPK getId() {
		return id;
	}

	public void setId(SellerProductPK id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProdottoVenditore [id=" + id + ", prezzo=" + prezzo + ", pezziDisponibili=" + pezziDisponibili + "]";
	}

}
