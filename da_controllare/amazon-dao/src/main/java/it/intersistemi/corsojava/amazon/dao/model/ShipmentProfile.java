package it.intersistemi.corsojava.amazon.dao.model;

public class ShipmentProfile {
	private String nome;
	private Double costo;
	private Integer tempoSpedizione;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Integer getTempoSpedizione() {
		return tempoSpedizione;
	}

	public void setTempoSpedizione(Integer tempoSpedizione) {
		this.tempoSpedizione = tempoSpedizione;
	}

	@Override
	public String toString() {
		return "ProfiloSpedizione [nome=" + nome + ", costo=" + costo + ", tempoSpedizione=" + tempoSpedizione + "]";
	}

}
