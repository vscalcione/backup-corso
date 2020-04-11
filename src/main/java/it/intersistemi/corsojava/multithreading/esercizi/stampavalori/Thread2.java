package it.intersistemi.corsojava.multithreading.esercizi.stampavalori;

public class Thread2 extends Thread{
	public void run(){
		while(PrintValues0to9And9to0.flag==false);
		for(int i=8;i>=0;i=i-1){
			PrintValues0to9And9to0.stampante.stampa(i);
		}
		PrintValues0to9And9to0.flag=false;
	}
}
