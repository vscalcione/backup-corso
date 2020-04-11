package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

import java.util.Arrays;
import java.util.Random;

import it.intersistemi.corsojava.poligoni.Poligono;
import it.intersistemi.corsojava.poligoni.TriangoloEquilatero;

public class GeneratoreTriangoliEquilatero extends GeneratorePoligoni{
		@Override
		public TriangoloEquilatero[] generaPoligono(int quanti) {
			Poligono[] generaPoligono = super.generaPoligono(quanti);
			return Arrays.copyOf(generaPoligono, generaPoligono.length, TriangoloEquilatero[].class);
		}
		
		@Override
		public TriangoloEquilatero generaPoligono(){
			Random rndValue = new Random();
			return new TriangoloEquilatero(rndValue.nextInt(50));
		}
}
