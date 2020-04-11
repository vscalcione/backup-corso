package it.intersistemi.corsojava.esercizi;

public class Point {

	int x = 10 ;
	int y = 20 ;

	public Point(int dx, int dy) { 
		x = dx ;
		y = dy ;
	}
	
	public Point() {}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}	
	
}
