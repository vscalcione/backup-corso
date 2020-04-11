package it.intersistemi.corsojava.incapsulamento;

public class Punto {
	private int x,y;
	public Punto() {}
	
	public Punto(int x, int y){
		if(x >= 0 || y >= 0) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int getX() {
		return x;
	}	
	
	public int getY() {
		return y;
	}
	
	public static void main(String[] args) {
		Punto punto1=new Punto(-16,23);
		System.out.println("Le coordinate sono: "+punto1.getX()+", "+punto1.getY());
		Punto[] arrayPunti=new Punto[] {new Punto(2,10), new Punto(7,28), new Punto(25,2)};
		for(Punto punto: arrayPunti) {
			System.out.println("Le coordinate sono: "+punto.getX()+", "+punto.getY());
		}
	}
}
