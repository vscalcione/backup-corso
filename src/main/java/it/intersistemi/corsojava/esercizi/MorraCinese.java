package it.intersistemi.corsojava.esercizi;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MorraCinese {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); provare a casa
		
		String continua; // gestita con enum � pi� modificabile
		int giocatore1;
		int giocatore2;

		
		do {

			try {

				System.out.println("Giocatore 1 :Scegli 1 per Carta, 2 per Forbici e 3 per Sasso");

				giocatore1 = reader.nextInt();

				System.out.println("Giocatore 2 :Scegli 1 per Carta, 2 per Forbici e 3 per Sasso");

				giocatore2 = reader.nextInt();

				// reader.close();

				if ((giocatore1 != 1 && giocatore1 != 2 && giocatore1 != 3) // gestire ciclo per scelta giocata singola
																			// con do while
						|| (giocatore2 != 1 && giocatore2 != 2 && giocatore2 != 3)) {
					System.out.println("giocata non valida");

				}

				else {

					if (giocatore1 == giocatore2) {

						System.out.println("pareggio");
					}

					else {

						if (giocatore1 == 1 && giocatore2 == 2)

						{
							System.out.println("vince giocatore 2");
						}

						else if (giocatore1 == 2 && giocatore2 == 1)

						{
							System.out.println("vince giocatore 1");
						}

						else if (giocatore1 == 3 && giocatore2 == 2)

						{
							System.out.println("vince giocatore 1");
						}

						else if (giocatore1 == 2 && giocatore2 == 3)

						{
							System.out.println("vince giocatore 2");
						}

						else if (giocatore1 == 3 && giocatore2 == 1)

						{
							System.out.println("vince giocatore 1");
						}

						else // (giocatore1==1 && giocatore2 == 3);

						{
							System.out.println("vince giocatore 1");
						}

					}
				}

			} catch (InputMismatchException e) {
				System.out.println("Hai inserito un valore errato");
				
			} finally {
			}

			System.out.println("--------------------------------------");
			System.out.println("");

			System.out.println("Digitare continua per ripetere giocata");

			continua = reader.nextLine();
			continua = reader.next();

			if (continua != null && !continua.equalsIgnoreCase("continua")) {

				System.out.println("partita finita");
			}

		} while (continua.equalsIgnoreCase("continua"));
		reader.close();
	} 
}
