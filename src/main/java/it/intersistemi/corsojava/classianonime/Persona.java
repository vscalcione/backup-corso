package it.intersistemi.corsojava.classianonime;

public class Persona {
	private String nome;
	private String cognome;
	private Sesso sesso;
	
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public Persona(String nome, String cognome, Sesso sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso= sesso;
	}

}
