package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

import java.util.Arrays;
import java.util.Random;

import it.intersistemi.corsojava.poligoni.Cerchio;
import it.intersistemi.corsojava.poligoni.Poligono;

public class GeneratoreCerchi extends GeneratorePoligoni{
	@Override
	public Cerchio[] generaPoligono(int quanti) {
		Poligono[] generaPoligono = super.generaPoligono(quanti);
		return Arrays.copyOf(generaPoligono, generaPoligono.length, Cerchio[].class);
	}
	
	@Override
	public Cerchio generaPoligono(){
		Random rndValue = new Random();
		return new Cerchio(rndValue.nextInt(50));
	}
}
