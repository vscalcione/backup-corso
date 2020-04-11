package it.intersistemi.corsojava.multithreading.esercizi.stampa0a9;

public class Thread1 extends Thread{
	public void run() {
		while(Print0to9Values.numero != 10){
			while(Print0to9Values.flag != 1);
			Print0to9Values.numero += 1;
			Print0to9Values.flag = 2;
		}		
	}
}
