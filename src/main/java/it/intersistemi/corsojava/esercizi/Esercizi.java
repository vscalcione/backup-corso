package it.intersistemi.corsojava.esercizi;

public class Esercizi {

	public static void main(String[] args) {
		int[] intArr={32,87,3,589,12,1076,2000,8,662,127};
		int cercafor=12;
		String trovato=null;
		for(int attuale:intArr){
			if(attuale==cercafor){
				trovato="trovato!";
				break;
			}
		}
		if(trovato==null){
			trovato="non trovato";
		}
		System.out.println(trovato);
		
	}
	
}
