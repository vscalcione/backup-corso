package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

import java.util.Random;

import it.intersistemi.corsojava.poligoni.Poligono;

public class FabbricaDiPoligoni {
	private GeneratorePoligoni[] generatoriPoligoni = {new GeneratoreCerchi(), new GeneratorePentagoni(),
			new GeneratoreRettangoli(), new GeneratoreQuadrati(), new GeneratoreRettangoli(),
			new GeneratoreTriangoliEquilatero()
	};
	
	public Poligono[] fabbricaPoligono(int quanti){
		Poligono[] poligoni = new Poligono[quanti];
		Random rndValue = new Random();
		for (int i = 0; i < poligoni.length; i++) {
			poligoni[i] = generatoriPoligoni[rndValue.nextInt(generatoriPoligoni.length)].generaPoligono();
		}
		return poligoni;
	}
}
