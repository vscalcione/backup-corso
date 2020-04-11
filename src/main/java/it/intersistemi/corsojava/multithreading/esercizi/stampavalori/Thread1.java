package it.intersistemi.corsojava.multithreading.esercizi.stampavalori;

public class Thread1 extends Thread{
	public void run(){
		while(PrintValues0to9And9to0.flag==true);
		for(int i=0;i<=9;i++){
			PrintValues0to9And9to0.stampante.stampa(i);
		}
		PrintValues0to9And9to0.flag=true;
	}
}
