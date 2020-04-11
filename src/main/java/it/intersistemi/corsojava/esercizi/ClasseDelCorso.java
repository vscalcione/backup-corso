package it.intersistemi.corsojava.esercizi;

public class ClasseDelCorso {
	public static void main(String[] args) {
		String[][] classeDelCorso = new String[][] { 
				{ "Riccardo", "Angela", "Arianna", "Domenico", "Vittorio" },
				{ "Valentino", "Marco", "Angela", "Vittorio", "Gianluca" },
				{ "Daniele", "Giacomo", "Cristian", "Francesco", "Cristian" }, 
				};
		for (int i = 0; i < classeDelCorso.length; i++) {
			for (int j = 0; j < classeDelCorso[i].length; j++) {
				System.out.print(classeDelCorso[i][j] + " ");
			}
			System.out.println();
		}

	}

}
