package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

import java.util.Arrays;
import java.util.Random;

import it.intersistemi.corsojava.poligoni.Poligono;
import it.intersistemi.corsojava.poligoni.Quadrato;

public class GeneratoreQuadrati extends GeneratorePoligoni{
	@Override
	public Quadrato[] generaPoligono(int quanti) {
		Poligono[] generaPoligono = super.generaPoligono(quanti);
		return Arrays.copyOf(generaPoligono, generaPoligono.length, Quadrato[].class);
	}
	
	@Override
	public Quadrato generaPoligono(){
		Random rndValue = new Random();
		return new Quadrato(rndValue.nextInt(50));
	}
}
