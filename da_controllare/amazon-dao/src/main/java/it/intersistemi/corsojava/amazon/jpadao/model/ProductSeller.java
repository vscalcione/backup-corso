package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODOTTO_VENDITORE database table.
 * 
 */
@Entity
@Table(name="PRODUCT_SELLER")
@NamedQuery(name="ProductSeller.findAll", query="SELECT p FROM ProductSeller p")
public class ProductSeller implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductSellerPK id;

	@Column(name="PEZZI_DISPONIBILI")
	private int pezziDisponibili;

	private double prezzo;

	//bi-directional many-to-one association to Prodotto
	@ManyToOne
	@JoinColumn(name="ASIN", nullable=false, insertable=false, updatable=false)
	private Product prodotto;

	//bi-directional many-to-one association to Venditore
	@ManyToOne
	@JoinColumn(name="P_IVA", nullable=false, insertable=false, updatable=false)
	private Seller venditore;

	//uni-directional many-to-many association to ProfiloSpedizione
	@ManyToMany
	@JoinTable(
		name="PROFILO_SPEDIZIONE_PRODOTTO"
		, joinColumns={
			@JoinColumn(name="ASIN", referencedColumnName="ASIN", nullable=false),
			@JoinColumn(name="P_IVA", referencedColumnName="P_IVA", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="NOME_SPEDIZIONE", nullable=false)
			}
		)
	private List<ShipmentProfile> profiliSpedizioneDisponibili;

	public ProductSeller() {
	}

	public ProductSellerPK getId() {
		return this.id;
	}

	public void setId(ProductSellerPK id) {
		this.id = id;
	}

	public int getPezziDisponibili() {
		return this.pezziDisponibili;
	}

	public void setPezziDisponibili(int pezziDisponibili) {
		this.pezziDisponibili = pezziDisponibili;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Product getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(Product prodotto) {
		this.prodotto = prodotto;
	}

	public Seller getVenditore() {
		return this.venditore;
	}

	public void setVenditore(Seller venditore) {
		this.venditore = venditore;
	}

	public List<ShipmentProfile> getProfiliSpedizioneDisponibili() {
		return this.profiliSpedizioneDisponibili;
	}

	public void setProfiliSpedizioneDisponibili(List<ShipmentProfile> profiliSpedizioneDisponibili) {
		this.profiliSpedizioneDisponibili = profiliSpedizioneDisponibili;
	}

	@Override
	public String toString() {
		return "ProdottoVenditore [id=" + id + ", pezziDisponibili=" + pezziDisponibili + ", prezzo=" + prezzo
				+ ", prodotto=" + prodotto + ", venditore=" + venditore + ", profiliSpedizioneDisponibili="
				+ profiliSpedizioneDisponibili + "]";
	}

}