package it.intersistemi.corsojava.multithreading.esercizi.stampa20valori;

public class Thread2 implements Runnable{
	@Override
	public void run() {
		while(Print20Pari_DispariValues.flag==false);
		Print20Pari_DispariValues.flag = false;
		for (int i = 0; i < 20; i++) {
			if(i%2 != 0) {
				System.out.print(i+" - ");
			}
		}
		Print20Pari_DispariValues.flag = true;
	}
}
