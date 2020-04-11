package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

import java.util.Random;

import it.intersistemi.corsojava.poligoni.Poligono;

public abstract class GeneratorePoligoni {
	{
	Random rnd=new Random();
	rnd.nextDouble();
	}
	
	public Poligono[] generaPoligono(int quanti) {
		Poligono[] poligoni = new Poligono[quanti];
		for (int i = 0; i < poligoni.length; i++) {
			poligoni[i] = this.generaPoligono();
		}
		return poligoni;
	}
	public abstract Poligono generaPoligono();
}
