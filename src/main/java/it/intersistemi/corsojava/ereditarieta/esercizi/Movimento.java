package it.intersistemi.corsojava.ereditarieta.esercizi;

public class Movimento {
	int numeroCarta, segno;
	double contante;
	
	public int getNumeroCarta() {
		return numeroCarta;
	}
	
	public void setNumeroCarta(int numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	
	public double getContante() {
		return contante;
	}
	
	public void setContante(double contante) {
		this.contante = contante;
	}
	
	public int getSegno() {
		return segno;
	}
	
	public void setSegno(int segno) {
		this.segno = segno;
	}
	
	public Movimento(int numeroCarta, double contante, int segno) {
		this.numeroCarta = numeroCarta;
		this.contante = contante;
		this.segno = segno;
	}	
}