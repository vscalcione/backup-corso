package it.intersistemi.corsojava.ereditarieta.esercizi.punto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class Punto {
	protected int coordinateX, coordinateY;
	public Punto() {
	}
	
	public Punto(int coordinateX, int coordinateY) {
		this.setXY(coordinateX, coordinateY);
	}
	
	public void setXY(int coordinateX, int coordinateY) {
		this.setCoordinateX(coordinateX);
		this.setCoordinateY(coordinateY);
	}
	
	public int getCoordinateX() {
		return coordinateX;
	}
	
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	
	public int getCoordinateY() {
		return coordinateY;
	}
	
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
	
	public double getDistance(Punto p) {
		int value1 = (coordinateX - p.coordinateX) * (coordinateX - p.coordinateX);
		int value2 = (coordinateY - p.coordinateY) * (coordinateY - p.coordinateY);
		return Math.sqrt(value1 + value2);
	}
	
	public static void getCoordinatesXY(Punto p) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int coordinateX = ConsoleInputInteri.leggiIntero(console, "Coordinata X: ");
		int coordinateY = ConsoleInputInteri.leggiIntero(console, "Coordinata Y: ");
		p.setXY(coordinateX, coordinateY);
		System.out.println(" ");
	}
	
	public static void main(String[] args) throws IOException{
		Punto p1 = new Punto();
		getCoordinatesXY(p1);
		Punto p2 = new Punto();
		getCoordinatesXY(p2);
		double distance = p1.getDistance(p2);
		System.out.println("La distanza fra il punto p1 e p2 � di: "+Math.round(distance)+" centrimetri ");
	}
}
