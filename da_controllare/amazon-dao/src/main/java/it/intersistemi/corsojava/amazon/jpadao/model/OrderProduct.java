package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ORDINE_PRODOTTO database table.
 * 
 */
@Entity
@Table(name="ORDER_PRODUCT")
@NamedQuery(name="OrderProduct.findAll", query="SELECT o FROM OrderProduct o")
public class OrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderProductPK id;

	@Column(name="PREZZO_ACQUISTO")
	private double prezzoAcquisto;

	@Column(nullable=false)
	private int quantita;

	private int sconto;

	//bi-directional many-to-one association to Ordine
	@ManyToOne
	@JoinColumn(name="NUMERO_ORDINE", nullable=false, insertable=false, updatable=false)
	private Order ordine;

	//uni-directional many-to-one association to Prodotto
	@ManyToOne
	@JoinColumn(name="ASIN", nullable=false, insertable=false, updatable=false)
	private Product prodotto;

	//uni-directional many-to-one association to ProdottoVenditore
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ASIN", referencedColumnName="P_IVA", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="P_IVA", referencedColumnName="ASIN", nullable=false, insertable=false, updatable=false)
		})
	private ProductSeller prodottoVenditore;

	//uni-directional many-to-one association to ProfiloSpedizione
	@ManyToOne
	@JoinColumn(name="NOME_PROFILO_SPEDIZIONE", nullable=false)
	private ShipmentProfile profiloSpedizione;

	public OrderProduct() {
	}

	public OrderProductPK getId() {
		return this.id;
	}

	public void setId(OrderProductPK id) {
		this.id = id;
	}

	public double getPrezzoAcquisto() {
		return this.prezzoAcquisto;
	}

	public void setPrezzoAcquisto(double prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getSconto() {
		return this.sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public Order getOrdine() {
		return this.ordine;
	}

	public void setOrdine(Order ordine) {
		this.ordine = ordine;
	}

	public Product getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(Product prodotto) {
		this.prodotto = prodotto;
	}

	public ProductSeller getProdottoVenditore() {
		return this.prodottoVenditore;
	}

	public void setProdottoVenditore(ProductSeller prodottoVenditore) {
		this.prodottoVenditore = prodottoVenditore;
	}

	public ShipmentProfile getProfiloSpedizione() {
		return this.profiloSpedizione;
	}

	public void setProfiloSpedizione(ShipmentProfile profiloSpedizione) {
		this.profiloSpedizione = profiloSpedizione;
	}

	@Override
	public String toString() {
		return "OrdineProdotto [id=" + id + ", prezzoAcquisto=" + prezzoAcquisto + ", quantita=" + quantita
				+ ", sconto=" + sconto + ", ordine=" + ordine + ", prodotto=" + prodotto + ", prodottoVenditore="
				+ prodottoVenditore + "]";
	}

}