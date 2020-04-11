package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public class Pentagono extends Poligono implements PoligonoRegolare {
	public Pentagono(double lato) {
		super(new double[] { lato, lato, lato, lato, lato });
	}

	@Override
	public double getLato() {
		return super.latiPoligono[0];
	}

	@Override
	public double calcolaArea() {
		return 0;
	}
}
