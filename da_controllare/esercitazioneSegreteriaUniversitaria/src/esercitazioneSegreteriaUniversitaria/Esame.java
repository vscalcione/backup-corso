package esercitazioneSegreteriaUniversitaria;

public class Esame {

	private String codiceEsame;
	private String nomeEsame;

	public Esame() {
		
	}

	public String getCodiceEsame() {
		return codiceEsame;
	}

	public void setCodiceEsame(String codiceEsame) {
		this.codiceEsame = codiceEsame;
	}

	public String getNomeEsame() {
		return nomeEsame;
	}

	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}

	@Override
	public String toString() {
		return "Esame [codiceEsame=" + codiceEsame + ", nomeEsame=" + nomeEsame + "]";
	}

	
}
