package it.intersistemi.corsojava.generics.esercizi;

public class Dipendente extends Persona {
	
	private String idFiliale;
	private String idUfficio;
// costruttore che accetta in i
	public Dipendente(String nome, String cognome, String idFiliale, String idUfficio, Sesso sesso) {
		super(nome, cognome, sesso);
	
	}
	
	public void trasferisci(String idUfficio, String idFiliale) {
		
		this.idFiliale = idFiliale;
		this.idUfficio = idUfficio; 
		
	}

	/**
	 * @return the idFiliale
	 */


	/**
	 * @return the idUfficio
	 */
	public String getIdUfficio() {
		return idUfficio;
	}

	public String getIdFiliale() {
		// TODO Auto-generated method stub
		return idFiliale;
	}


	}
	


