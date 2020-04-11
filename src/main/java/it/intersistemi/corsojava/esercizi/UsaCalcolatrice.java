package it.intersistemi.corsojava.esercizi;
import progetto2.Calcolatrice;

public class UsaCalcolatrice {

	public static void main(String[] args) {
		Calcolatrice calcolatrice=new Calcolatrice();
//		calcolatrice.somma(10);
//		calcolatrice.somma(23);
//		calcolatrice.somma(15);
//		System.out.println("totale:"+calcolatrice.getValoreCorrente());
		calcolatrice.somma(10);
//		calcolatrice.moltiplica(2);
		calcolatrice.potenza(3);
		System.out.println("totale:"+calcolatrice.getValoreCorrente());
		
	}

}
