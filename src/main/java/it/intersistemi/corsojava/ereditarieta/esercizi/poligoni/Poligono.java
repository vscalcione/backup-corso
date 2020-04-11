package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public abstract class Poligono implements PoligonoGenerico {
	protected double[] latiPoligono;
	public Poligono(double[] latiPoligono) {
		super(); // chiamata alla superclasse di Poligono, che se non viene definita, � quella riferita ad Object (java.lang.Object) //
		this.latiPoligono = latiPoligono;
	}

	public int getNumeroLati() {
		return this.latiPoligono.length;
	}

	public double calcolaPerimetro() {
		double perimetro = 0.0;
		for (double lato : latiPoligono) {
			perimetro += lato;
		}
		return perimetro;
	}
	// public abstract double calcolaArea();
}
