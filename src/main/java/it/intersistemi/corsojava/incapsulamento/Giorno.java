package it.intersistemi.corsojava.incapsulamento;

public enum Giorno { 
	LUNEDI(false),	MARTEDI (false), ERCOLEDI (false), GIOVEDI (false), VENERDI (false), SABATO (true) ,
	DOMENICA (true);
	
	private boolean festivo=false;
	Giorno(){
		this.festivo=false;
	}
	
	Giorno(boolean festivo) {
		this.festivo=festivo;
	}
	
	public boolean isFestivo() {
		return festivo;
	}
}
