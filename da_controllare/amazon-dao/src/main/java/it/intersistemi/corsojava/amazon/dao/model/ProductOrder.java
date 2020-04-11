package it.intersistemi.corsojava.amazon.dao.model;

public class ProductOrder {
	private int quantita;
	private double prezzoAcquisto;
	private Integer sconto;
	private String nomeProfiloSpedizione;
	private ProductOrderPK id;

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzoAcquisto() {
		return prezzoAcquisto;
	}

	public void setPrezzoAcquisto(double prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}

	public Integer getSconto() {
		return sconto;
	}

	public void setSconto(Integer sconto) {
		this.sconto = sconto;
	}

	public String getNomeProfiloSpedizione() {
		return nomeProfiloSpedizione;
	}

	public void setNomeProfiloSpedizione(String nomeProfiloSpedizione) {
		this.nomeProfiloSpedizione = nomeProfiloSpedizione;
	}

	public ProductOrderPK getId() {
		return id;
	}

	public void setId(ProductOrderPK id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrdineProdotto [quantita=" + quantita + ", prezzoAcquisto=" + prezzoAcquisto + ", sconto=" + sconto
				+ ", nomeProfiloSpedizione=" + nomeProfiloSpedizione + ", id=" + id + "]";
	}

	

}
