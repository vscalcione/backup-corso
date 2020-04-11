package it.intersistemi.corsojava.streams.esercizi;

public class Employee extends Persona{
	private String idFiliale, idUfficio;
	
	public Employee(String nome, String cognome, Sesso sesso) {
		super(nome, cognome, sesso);
	}
	
	public Employee(String nome, String cognome, Sesso sesso, String idFiliale, String idUfficio) {
		super(nome, cognome, sesso);
		this.trasferisci(idFiliale, idUfficio);
	}	
	
	public void trasferisci (String idFiliale, String idUfficio) {
		this.idFiliale = idFiliale;
		this.idUfficio = idUfficio;
	}
	
	public String getIdFiliale() {
		return idFiliale;
	}
	
	public String getIdUfficio() {
		return idUfficio;
	}
}
