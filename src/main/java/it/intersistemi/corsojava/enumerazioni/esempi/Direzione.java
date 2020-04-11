package it.intersistemi.corsojava.enumerazioni.esempi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public enum Direzione {
	NORD(0, 2 * Math.PI, 'N'), SUD (180, Math.PI, 'S'), OVEST (90, (Math.PI/2), 'O'), 
	EST (270, ((Math.PI *3)/2), 'E');
	private int gradi;
	private char direction;
	private double r;
	
	Direzione(int gradi){
		this.gradi = gradi;
	}
	
	Direzione (int gradi, char direction){
		this(gradi);
		this.direction = direction;
	}
	
	Direzione(int gradi, double r, char direction){
		this(gradi, direction);
		this.r = r;
	}
	
	public int getGradi() {
		return gradi;
	}

	public void setGradi(int gradi) {
		this.gradi = gradi;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public static void main(String[] args) throws IOException{
		Direzione direction = Direzione.OVEST;
		System.out.println("*******************************");
		System.out.println(direction+" --> "+direction.getDirection());
		System.out.println("*******************************");
	}
}