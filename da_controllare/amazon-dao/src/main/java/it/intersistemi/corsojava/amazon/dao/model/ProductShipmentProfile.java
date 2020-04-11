package it.intersistemi.corsojava.amazon.dao.model;

public class ProductShipmentProfile {
	private String asin;
	private String p_iva;
	private String nomeSpedizione;

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getP_iva() {
		return p_iva;
	}

	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}

	public String getNomeSpedizione() {
		return nomeSpedizione;
	}

	public void setNomeSpedizione(String nomeSpedizione) {
		this.nomeSpedizione = nomeSpedizione;
	}

	@Override
	public String toString() {
		return "ProfiloSpedizioneProdotto [asin=" + asin + ", p_iva=" + p_iva + ", nomeSpedizione=" + nomeSpedizione
				+ "]";
	}

}
