package it.intersistemi.corsojava.esercizi;

public class Automobile {
	
	private final String marca;
	private final String modello;
	public final int nPorte;
	private Colore colore;
	
	private Immatricolazione immatricolazione;
	
	private Motore motore;
	
	public Automobile(String marca, String modello, int nPorte){
		this.marca=marca;
		this.modello=modello;
		this.nPorte=nPorte;
	}
	public Automobile(String marca, String modello, int nPorte, Colore colore){
		this.marca=marca;
		this.modello=modello;
		this.nPorte=nPorte;
		this.colore=colore;
	}
	
	public void accendi(){
		motore.setAcceso(true);
	}
	
	public void spegni(){
		motore.setAcceso(true);
	}
	
	
	
	
	public int getnPorte() {
		return nPorte;
	}
	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore colore) {
		this.colore = colore;
	}
	public String getMarca() {
		return marca;
	}
	public String getModello() {
		return modello;
	}
	public Motore getMotore() {
		return motore;
	}
	public void setImmatricolazione(Immatricolazione immatricolazione) {
		this.immatricolazione = immatricolazione;
	}
	public Immatricolazione getImmatricolazione(){
		return immatricolazione;
	}
	public void setMotore(Motore motore){
		this.motore=motore;
	}
}
