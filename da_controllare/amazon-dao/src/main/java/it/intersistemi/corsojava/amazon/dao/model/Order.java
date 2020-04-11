package it.intersistemi.corsojava.amazon.dao.model;

public class Order {
	private Integer nOrdine;
	private String statoPagamento;
	private String modalitaPagamento;
	private Integer sconto;
	private String username;
	private String indirizzoSpedizione;
	

	public String getStatoPagamento() {
		return statoPagamento;
	}

	public void setStatoPagamento(String statoPagamento) {
		this.statoPagamento = statoPagamento;
	}

	public String getModalitaPagamento() {
		return modalitaPagamento;
	}

	public void setModalitaPagamento(String modalitaPagamento) {
		this.modalitaPagamento = modalitaPagamento;
	}

	public Integer getSconto() {
		return sconto;
	}

	public void setSconto(Integer sconto) {
		this.sconto = sconto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIndirizzoSpedizione() {
		return indirizzoSpedizione;
	}

	public void setIndirizzoSpedizione(String indirizzoSpedizione) {
		this.indirizzoSpedizione = indirizzoSpedizione;
	}

	public Integer getnOrdine() {
		return nOrdine;
	}

	public void setnOrdine(Integer nOrdine) {
		this.nOrdine = nOrdine;
	}

	@Override
	public String toString() {
		return "Ordine [nOrdine=" + nOrdine + ", statoPagamento=" + statoPagamento + ", modalitaPagamento="
				+ modalitaPagamento + ", sconto=" + sconto + ", username=" + username + ", indirizzoSpedizione="
				+ indirizzoSpedizione + "]";
	}

}
