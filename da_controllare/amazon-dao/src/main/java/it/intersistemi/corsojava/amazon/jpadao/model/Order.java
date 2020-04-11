package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ORDINE database table.
 * 
 */
@Entity
@Table(name="ORDER")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUMERO_ORDINE", unique=true, nullable=false)
	private Integer numeroOrdine;

	@Column(name="MODALITA_PAGAMENTO", length=20)
	private String modalitaPagamento;

	private int sconto;

	@Column(name="STATO_PAGAMENTO", length=20)
	private String statoPagamento;

	//uni-directional many-to-one association to Indirizzo
	@ManyToOne
	@JoinColumn(name="INDIRIZZO_ID", nullable=false)
	private Address indirizzo;

	//uni-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="USERNAME", nullable=false)
	private User utente;

	//bi-directional many-to-one association to OrdineProdotto
	@OneToMany(mappedBy="ordine")
	private List<OrderProduct> prodottiOrdinati;

	public Order() {
	}

	public Integer getNumeroOrdine() {
		return this.numeroOrdine;
	}

	public void setNumeroOrdine(Integer numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public String getModalitaPagamento() {
		return this.modalitaPagamento;
	}

	public void setModalitaPagamento(String modalitaPagamento) {
		this.modalitaPagamento = modalitaPagamento;
	}

	public int getSconto() {
		return this.sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public String getStatoPagamento() {
		return this.statoPagamento;
	}

	public void setStatoPagamento(String statoPagamento) {
		this.statoPagamento = statoPagamento;
	}

	public Address getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(Address indirizzo) {
		this.indirizzo = indirizzo;
	}

	public User getUtente() {
		return this.utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public List<OrderProduct> getProdottiOrdinati() {
		return this.prodottiOrdinati;
	}

	public void setProdottiOrdinati(List<OrderProduct> prodottiOrdinati) {
		this.prodottiOrdinati = prodottiOrdinati;
	}

	public OrderProduct addProdottiOrdinati(OrderProduct prodottiOrdinati) {
		getProdottiOrdinati().add(prodottiOrdinati);
		prodottiOrdinati.setOrdine(this);

		return prodottiOrdinati;
	}

	public OrderProduct removeProdottiOrdinati(OrderProduct prodottiOrdinati) {
		getProdottiOrdinati().remove(prodottiOrdinati);
		prodottiOrdinati.setOrdine(null);

		return prodottiOrdinati;
	}

	@Override
	public String toString() {
		return "Ordine [numeroOrdine=" + numeroOrdine + ", modalitaPagamento=" + modalitaPagamento + ", sconto="
				+ sconto + ", statoPagamento=" + statoPagamento + ", indirizzo=" + indirizzo + ", utente=" + utente
				+ ", prodottiOrdinati=" + prodottiOrdinati + "]";
	}

}