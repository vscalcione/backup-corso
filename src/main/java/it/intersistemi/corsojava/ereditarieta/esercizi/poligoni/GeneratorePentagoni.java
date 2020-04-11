package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

import java.util.Arrays;
import java.util.Random;

import it.intersistemi.corsojava.poligoni.Poligono;
import it.intersistemi.corsojava.poligoni.Pentagono;

public class GeneratorePentagoni extends GeneratorePoligoni{
		@Override
		public Pentagono[] generaPoligono(int quanti) {
			Poligono[] generaPoligono = super.generaPoligono(quanti);
			return Arrays.copyOf(generaPoligono, generaPoligono.length, Pentagono[].class);
		}
		
		@Override
		public Pentagono generaPoligono(){
			Random rndValue = new Random();
			return new Pentagono(rndValue.nextInt(50));
		}
}
