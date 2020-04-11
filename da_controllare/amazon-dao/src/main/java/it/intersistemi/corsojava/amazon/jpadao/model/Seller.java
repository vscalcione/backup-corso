package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VENDITORE database table.
 * 
 */
@Entity
@Table(name="SELLER")
@NamedQuery(name="Seller.findAll", query="SELECT s FROM Seller s")
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="P_IVA", unique=true, nullable=false, length=20)
	private String pIva;

	@Column(nullable=false, length=45)
	private String nazione;

	@Column(nullable=false, length=45)
	private String nome;

	//bi-directional many-to-one association to ProdottoVenditore
	@OneToMany(mappedBy="venditore")
	private List<ProductSeller> venditori;

	//bi-directional many-to-one association to RecensioneVenditore
	@OneToMany(mappedBy="venditore")
	private List<SellerReview> recensioni;

	public Seller() {
	}

	public String getPIva() {
		return this.pIva;
	}

	public void setPIva(String pIva) {
		this.pIva = pIva;
	}

	public String getNazione() {
		return this.nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProductSeller> getVenditori() {
		return this.venditori;
	}

	public void setVenditori(List<ProductSeller> venditori) {
		this.venditori = venditori;
	}

	public ProductSeller addVenditori(ProductSeller venditori) {
		getVenditori().add(venditori);
		venditori.setVenditore(this);

		return venditori;
	}

	public ProductSeller removeVenditori(ProductSeller venditori) {
		getVenditori().remove(venditori);
		venditori.setVenditore(null);

		return venditori;
	}

	public List<SellerReview> getRecensioni() {
		return this.recensioni;
	}

	public void setRecensioni(List<SellerReview> recensioni) {
		this.recensioni = recensioni;
	}

	public SellerReview addRecensioni(SellerReview recensioni) {
		getRecensioni().add(recensioni);
		recensioni.setVenditore(this);

		return recensioni;
	}

	public SellerReview removeRecensioni(SellerReview recensioni) {
		getRecensioni().remove(recensioni);
		recensioni.setVenditore(null);

		return recensioni;
	}

	@Override
	public String toString() {
		return "Venditore [pIva=" + pIva + ", nazione=" + nazione + ", nome=" + nome + ", venditori=" + venditori + "]";
	}

}