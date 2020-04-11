package it.intersistemi.corsojava.esercizi;

public class Motore {
	private float cilindrata;
	private int cavalli;
	private Carburante carburantePrimario;
	private Carburante carburanteSecondario;
	private boolean acceso=false;
	
	public Motore(float cilindrata, int cavalli, Carburante carburantePrimario){
		this.carburantePrimario=carburantePrimario;
		this.cilindrata=cilindrata;
		this.cavalli=cavalli;
	}
	public Motore(float cilindrata, int cavalli, Carburante carburantePrimario, Carburante carburanteSecondario){
		this(cilindrata, cavalli, carburantePrimario);
		this.carburanteSecondario=carburanteSecondario;
	}
	public void setAcceso(boolean acceso){
		this.acceso=acceso;
	}
	
	public float getCilindrata() {
		return cilindrata;
	}
	public int getCavalli() {
		return cavalli;
	}
	public Carburante getCarburantePrimario() {
		return carburantePrimario;
	}
	public Carburante getCarburanteSecondario() {
		return carburanteSecondario;
	}
	public boolean isAcceso(){
		return acceso;
	}
}
