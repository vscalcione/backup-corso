package esercitazioneSegreteriaUniversitaria;

public class Studente extends Persona {

	private String matricola;

	// String facolta;

	public Studente(String nome, String cognome, String matricola) {
		super(nome, cognome);
		this.matricola = matricola;

		// this.facolta = facolta;

	}

	// public String getFacolta() {
	// return facolta;
	// }
	//
	// public void setFacolta(String facolta) {
	// this.facolta = facolta;
	// }

	public Studente() {
		// TODO Auto-generated constructor stub
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public String toString() {
		return "Studente:  " + "  " + "Nome: " + this.getNome() + "   Cognome: " + this.getCognome() + "   Matricola: "
				+ this.matricola; // + " Data di iscrizione: "+
									// this.dataDiIscrizione;//+ this.facolta ;
	}

}
