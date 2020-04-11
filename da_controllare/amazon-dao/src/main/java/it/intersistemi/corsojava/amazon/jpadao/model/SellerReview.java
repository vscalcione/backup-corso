package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RECENSIONE_VENDITORE database table.
 * 
 */
@Entity
@Table(name="SELLER_REVIEW")
@NamedQuery(name="SellerReview.findAll", query="SELECT s FROM SellerReview s")
public class SellerReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SellerReviewPK id;

	@Column(nullable=false)
	private int punteggio;

	@Column(length=2000)
	private String testo;

	@Column(length=100)
	private String titolo;

	//uni-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="USERNAME", nullable=false, insertable=false, updatable=false)
	private User utente;

	//bi-directional many-to-one association to Venditore
	@ManyToOne
	@JoinColumn(name="P_IVA", nullable=false, insertable=false, updatable=false)
	private Seller venditore;

	public SellerReview() {
	}

	public SellerReviewPK getId() {
		return this.id;
	}

	public void setId(SellerReviewPK id) {
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

	public User getUtente() {
		return this.utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public Seller getVenditore() {
		return this.venditore;
	}

	public void setVenditore(Seller venditore) {
		this.venditore = venditore;
	}

	@Override
	public String toString() {
		return "RecensioneVenditore [id=" + id + ", punteggio=" + punteggio + ", testo=" + testo + ", titolo=" + titolo
				+ ", utente=" + utente + ", venditore=" + venditore + "]";
	}

}