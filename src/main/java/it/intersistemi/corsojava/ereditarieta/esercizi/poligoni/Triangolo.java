package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public abstract class Triangolo extends Poligono {
	protected double lato1, lato2, lato3;
	public Triangolo(double lato1, double lato2, double lato3) {
		super(new double[] { lato1, lato2, lato3 });
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

}
