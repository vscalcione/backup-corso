package it.intersistemi.corsojava.amazon.dao.model;

public class ProductReview {
	private ProductReviewPK id;
	private Integer punteggio;
	private String titolo;
	private String recensione;

	public ProductReviewPK getId() {
		return id;
	}

	public void setId(ProductReviewPK id) {
		this.id = id;
	}

	public Integer getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getRecensione() {
		return recensione;
	}

	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}

	@Override
	public String toString() {
		return "RecensioneProdotto [id=" + id + ", punteggio=" + punteggio + ", titolo=" + titolo + ", recensione="
				+ recensione + "]";
	}

}
