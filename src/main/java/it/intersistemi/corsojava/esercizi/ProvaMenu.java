package it.intersistemi.corsojava.esercizi;
import java.util.Scanner;

public class ProvaMenu {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int scelta;
		
		do {
			System.out.println("1)Funzione 1");
			System.out.println("2)Funzione 2");
			System.out.println("3)Funzione 3");
			System.out.println("4)Exit");
			
			do {
				System.out.println("Effettua la tua scelta");
				scelta=sc.nextInt();
			}while((scelta<1)||(scelta>4));    //non esco dal ciclo finch� non scelgo un numero tra 1 e 4
			
			switch(scelta) {
				case 1:
					funzione1();
					break;              //con il break, la funzione invece di andare avanti con gli altri
				case 2:                 //casi si stoppa e va fuori lo switch.
					funzione2();
					break;
				case 3:
					funzione3();
					break;	
				case 4:
					break;
			}
		}while(scelta!=4);
	}

	private static void funzione3() {
		System.out.println("Sono nella funzione 3");
	}

	private static void funzione2() {
		System.out.println("Sono nella funzione 2");	
	}

	private static void funzione1() {
		System.out.println("Sono nella funzione 1");
	}
}
