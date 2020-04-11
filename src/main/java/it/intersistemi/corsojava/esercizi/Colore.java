package it.intersistemi.corsojava.esercizi;

public enum Colore {
	ROSSO(2),
	GIALLO(1),
	VERDE(3);
	private int cod;
	
	
	private Colore(int a){
		cod=a;
	}
	
	public int getCode(){
		return cod;
	}
}
