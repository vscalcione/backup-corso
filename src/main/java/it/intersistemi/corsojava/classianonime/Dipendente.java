package it.intersistemi.corsojava.classianonime;

public class Dipendente extends Persona  {
    private String idFiliale;
    private String idUfficio;
    
    
	public Dipendente(String nome, String cognome, Sesso sesso) {
		super(nome, cognome, sesso);
		
	}
	
	public Dipendente(String nome, String cognome, Sesso sesso, String idFiliale, String idUfficio) {
		super(nome, cognome, sesso);
		this.traferisci(idFiliale, idUfficio);
	}
     public void  traferisci(String idFiliale, String idUfficio) {
    	 this.idFiliale= idFiliale;
    	 this.idUfficio= idUfficio;
     }
	public String getIdFiliale() {
		return idFiliale;
	}
	public String getIdUfficio() {
		return idUfficio;
	}
}
