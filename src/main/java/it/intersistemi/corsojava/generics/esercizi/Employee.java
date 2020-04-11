package it.intersistemi.corsojava.generics.esercizi;

public class Employee extends Person {

	private String idFiliale;
	private String idUfficio;
// costruttore che accetta in i
	public Employee(String nome, String cognome, String idFiliale, String idUfficio, Sex sesso) {
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



