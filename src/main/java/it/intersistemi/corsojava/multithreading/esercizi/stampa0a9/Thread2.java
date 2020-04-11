package it.intersistemi.corsojava.multithreading.esercizi.stampa0a9;

public class Thread2  extends Thread{
	public void run() {
		while(Print0to9Values.numero != 10){
			while(Print0to9Values.flag != 2);
			Stampante.stampa(Print0to9Values.numero);
			try{
				Thread.sleep(150);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			Print0to9Values.flag=1;
		}		
	}
}
