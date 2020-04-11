package it.intersistemi.corsojava.multithreading.esercizi.magazzinosincronizzato;

public class MagazzinoMain {

	
	
	public static void main(String[] args) {
		
		Magazzino magazzino = new Magazzino();
	Consumatore consumatore = new Consumatore(magazzino);
		Produttore produttore = new Produttore(magazzino);
		
		Thread cons = new Thread(consumatore);
		
		Thread prod = new Thread(produttore);
	
        
        cons.start();
        
        prod.start();
        
        System.out.println("Produttore: "+cons);
        System.out.println("Consumatore: "+prod);
        
//        System.out.println(cons);
//        System.out.println(prod);
        
	}

}
