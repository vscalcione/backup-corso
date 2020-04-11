package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RECENSIONE_PRODOTTO database table.
 * 
 */
@Entity
@Table(name="PRODUCT_REVIEW")
@NamedQuery(name="ProductReview.findAll", query="SELECT p FROM ProductReview p")
public class ProductReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductReviewPK id;

	@Column(nullable=false)
	private int punteggio;

	@Column(length=2000)
	private String testo;

	@Column(length=100)
	private String titolo;

	//bi-directional many-to-one association to Prodotto
	@ManyToOne
	@JoinColumn(name="ASIN", nullable=false, insertable=false, updatable=false)
	private Product prodotto;

	//uni-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="USERNAME", nullable=false, insertable=false, updatable=false)
	private User utente;

	public ProductReview() {
	}

	public ProductReviewPK getId() {
		return this.id;
	}

	public void setId(ProductReviewPK id) {
		this.id = id;
	}

	public int getPunteggio() {
		return this.punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public String getTesto() {
		return this.testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Product getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(Product prodotto) {
		this.prodotto = prodotto;
	}

	public User getUtente() {
		return this.utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "RecensioneProdotto [id=" + id + ", punteggio=" + punteggio + ", testo=" + testo + ", titolo=" + titolo
				+ ", prodotto=" + prodotto + ", utente=" + utente + "]";
	}

}