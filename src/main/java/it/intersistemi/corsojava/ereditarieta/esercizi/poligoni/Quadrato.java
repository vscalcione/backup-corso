package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public class Quadrato extends Rettangolo implements PoligonoRegolare {
	public Quadrato(double lato) {
		super(lato, lato);
	}

	@Override
	public double getLato() {
		return super.latiPoligono[0];
	}
}
