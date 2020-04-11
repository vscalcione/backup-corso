package it.intersistemi.corsojava.amazon.dao.model;

public class Seller {
	private String pIva;
	private String nome;
	private String nazione;

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	@Override
	public String toString() {
		return "Venditore [pIva=" + pIva + ", nome=" + nome + ", nazione=" + nazione + "]";
	}

}
