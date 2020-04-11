package it.intersistemi.corsojava.enumerazioni.esempi;

import java.util.Arrays;
import java.util.Comparator;

public class GiorniDellaSettimanaMain {
	public static void main(String[] args) {
		GiorniDellaSettimana[] daysOfWeek = GiorniDellaSettimana.values();
		for (int i = 0; i < daysOfWeek.length; i++) {
			printDaysOfWeek(daysOfWeek[i]);
		}
		GiorniDellaSettimana[] days = { 
				GiorniDellaSettimana.MARTEDI, 
				GiorniDellaSettimana.MERCOLEDI,
				GiorniDellaSettimana.LUNEDI, 
				GiorniDellaSettimana.DOMENICA, 
				GiorniDellaSettimana.GIOVEDI,
				GiorniDellaSettimana.VENERDI, 
				GiorniDellaSettimana.SABATO, };
		System.out.println("Prima dell'ordinamento");
		for (int i = 0; i < days.length; i++) {
			printDaysOfWeek(days[i]);
		}
		Comparator <GiorniDellaSettimana> comparatorDays = new NumeroGiornoComparator();
		Arrays.sort(days,comparatorDays);
		System.out.println("Dopo l'ordinamento");
		for (int i = 0; i < days.length; i++) {
			printDaysOfWeek(days[i]);
		}
	}
	
	private static void printDaysOfWeek(GiorniDellaSettimana giorno) {
		System.out.println(giorno + " " + giorno.getNumeroGiorno() + " " + (giorno.isFestivo()? " (festivo)" : ""));

	}
	
	public static class NumeroGiornoComparator  implements Comparator<GiorniDellaSettimana> {
		public int compare (GiorniDellaSettimana o1, GiorniDellaSettimana o2) {
			return o2.getNumeroGiorno()-o1.getNumeroGiorno();
		}
	}
}