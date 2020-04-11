package it.intersistemi.corsojava.enumerazioni.esempi;

public enum GiorniDellaSettimana {
	LUNEDI(1,false), MARTEDI(2,false),MERCOLEDI(3,false),GIOVEDI(4,false),VENERDI(5,false),
	SABATO(6,false), DOMENICA(7,true); 
	private int numberDay;
	private boolean festivo;
	
	GiorniDellaSettimana(int numberDay){
		this.numberDay=numberDay;
	 }
	
	GiorniDellaSettimana(int numberDay, boolean festivo){
		this(numberDay);
		this.festivo= festivo;
	}
	
	public int getNumeroGiorno() {
		return numberDay;
	}
	
	public boolean isFestivo() {
		return festivo;
	}
}
