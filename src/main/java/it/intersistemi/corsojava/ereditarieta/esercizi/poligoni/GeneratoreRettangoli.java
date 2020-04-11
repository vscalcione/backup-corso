package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

import java.util.Arrays;
import java.util.Random;

import it.intersistemi.corsojava.poligoni.Poligono;
import it.intersistemi.corsojava.poligoni.Rettangolo;
public class GeneratoreRettangoli extends GeneratorePoligoni{
	
	@Override
	public Rettangolo[] generaPoligono(int quanti) {
		Poligono[] generaPoligono=super.generaPoligono(quanti);
		return Arrays.copyOf(generaPoligono, generaPoligono.length, Rettangolo[].class);
	}
	
	@Override
	public Rettangolo generaPoligono(){
		Random rndValue = new Random();
		return new Rettangolo(rndValue.nextInt(50), rndValue.nextInt(50));
	}
}
