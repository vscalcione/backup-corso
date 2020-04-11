package it.intersistemi.corsojava.esercitazioni.datamanager;

public enum Giorno {
	LUNEDI(false),
	MARTEDI(false),
	MERCOLEDI(false),
	GIOVEDI(false),
	VENERDI(false),
	SABATO(true),
	DOMENICA(true);
	private boolean festivo;
	
	/*
	 * Giorno(){
	 *this.festivo =false;
		*/
	
	Giorno(boolean festivo) {
		this.festivo=festivo;
	}
	
	public boolean isFestivo() {
    	return festivo;
    }
}
