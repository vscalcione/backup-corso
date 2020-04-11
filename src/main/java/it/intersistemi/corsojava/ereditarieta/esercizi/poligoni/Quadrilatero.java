package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public abstract class Quadrilatero extends Poligono {
	public Quadrilatero(double lato1, double lato2, double lato3, double lato4) {
		super(new double[] { lato1, lato2, lato3, lato4 });
	}

	public double getLato1() {
		return super.latiPoligono[0];
	}

	public double getLato2() {
		return super.latiPoligono[1];
	}

	public double getLato3() {
		return super.latiPoligono[2];
	}

	public double getLato4() {
		return super.latiPoligono[3];
	}
}
