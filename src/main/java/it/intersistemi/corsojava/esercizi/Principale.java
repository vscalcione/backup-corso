package it.intersistemi.corsojava.esercizi;

public class Principale {
	private int b=2;
	public void a(){
		System.out.println("ciao");
	}
	public static void b(){
		System.out.println("principale");
	}
	public void c(Principale d){
		int dsde=d.b;
	}
}
