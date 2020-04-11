package it.intersistemi.corsojava.esercizi;

public class Fabbrica {
	
	public static void main(String[] args){
		
		Automobile ferrariMaranello=new Automobile("Ferrari", "maranello", 2, Colore.GIALLO);
		Motore motore=new Motore(1.5f, 15, Carburante.METANO);
		ferrariMaranello.setMotore(motore);
		
		Immatricolazione immatricolazione=new Immatricolazione();
		Persona proprietario=new Persona();
		proprietario.setNome("gianmauro");
		proprietario.setCognome("louga");
		immatricolazione.annoImmatricolazione=2016;
		immatricolazione.proprietario=proprietario;
		immatricolazione.targa="AR5483DA5";
		
	}
}
