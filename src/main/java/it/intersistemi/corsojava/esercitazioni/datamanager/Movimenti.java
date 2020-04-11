package it.intersistemi.corsojava.esercitazioni.datamanager;
import java.util.Date;
public class Movimenti {
	private Date time;
	private int segno;
	private double contante;
	private int numeroCarta;
	;
	 
	public Movimenti(int numeroCarta, int contante, double segno) {
		this.numeroCarta = numeroCarta;
		this.segno = (int) segno;
		this.contante = contante;
	}
}

	
	
	
			
		
	
