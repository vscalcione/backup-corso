package it.intersistemi.corsojava.nestedclasses;

public class Esterna {
	private int x;
	public Esterna (int x) {
		this.x =x;
	}
public class Interna {
	private int y;
	public Interna (int y) {
	this.y = y;}
}
	
	
	public void stampaValori () {
		// TODO Auto-generated method stub
System.out.println(x + ", " + y);
	}



public static void main (String[] args) {
	
	Esterna esterna = new Esterna (10);
	Esterna.Interna interna = esterna.new Interna (20);
	interna.stampaValori();
	
}
