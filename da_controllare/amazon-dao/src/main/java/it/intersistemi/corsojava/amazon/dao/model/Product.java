package it.intersistemi.corsojava.amazon.dao.model;

public class Product {
	
	private String asin;
	private String nome;
	private String descrizione;
	private String marca;
	private String modello;		
	private Integer categoriaId;		
	
	
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public Integer getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	@Override
	public String toString() {
		return "Prodotto [asin=" + asin + ", nome=" + nome + ", descrizione=" + descrizione + ", marca=" + marca
				+ ", modello=" + modello + ", categoriaId=" + getCategoriaId() + "]";
	}
	
	
}
