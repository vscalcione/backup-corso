package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODOTTO database table.
 * 
 */
@Entity
@Table(name="PRODUCT")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=50)
	private String asin;

	@Column(nullable=false, length=2000)
	private String descrizione;

	@Column(nullable=false, length=45)
	private String marca;

	@Column(nullable=false, length=45)
	private String modello;

	@Column(nullable=false, length=100)
	private String nome;

	//uni-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="CATEGORIA_ID", nullable=false)
	private Category categoria;

	//bi-directional many-to-one association to ProdottoVenditore
	@OneToMany(mappedBy="prodotto")
	private List<ProductSeller> venditoriProdotto;

	//bi-directional many-to-one association to RecensioneProdotto
	@OneToMany(mappedBy="prodotto")
	private List<ProductReview> recensioni;

	public Product() {
	}

	public String getAsin() {
		return this.asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return this.modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Category getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}

	public List<ProductSeller> getVenditoriProdotto() {
		return this.venditoriProdotto;
	}

	public void setVenditoriProdotto(List<ProductSeller> venditoriProdotto) {
		this.venditoriProdotto = venditoriProdotto;
	}

	public ProductSeller addVenditoriProdotto(ProductSeller venditoriProdotto) {
		getVenditoriProdotto().add(venditoriProdotto);
		venditoriProdotto.setProdotto(this);

		return venditoriProdotto;
	}

	public ProductSeller removeVenditoriProdotto(ProductSeller venditoriProdotto) {
		getVenditoriProdotto().remove(venditoriProdotto);
		venditoriProdotto.setProdotto(null);

		return venditoriProdotto;
	}

	public List<ProductReview> getRecensioni() {
		return this.recensioni;
	}

	public void setRecensioni(List<ProductReview> recensioni) {
		this.recensioni = recensioni;
	}

	public ProductReview addRecensioni(ProductReview recensioni) {
		getRecensioni().add(recensioni);
		recensioni.setProdotto(this);

		return recensioni;
	}

	public ProductReview removeRecensioni(ProductReview recensioni) {
		getRecensioni().remove(recensioni);
		recensioni.setProdotto(null);

		return recensioni;
	}

	@Override
	public String toString() {
		return "Prodotto [asin=" + asin + ", descrizione=" + descrizione + ", marca=" + marca + ", modello=" + modello
				+ ", nome=" + nome + ", categoria=" + categoria + "]";
	}


}