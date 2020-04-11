package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public class Rettangolo extends Quadrilatero {
	public Rettangolo(double base, double altezza) {
		super(base, altezza, base, altezza);
	}

	@Override
	public double calcolaArea() {
		return super.latiPoligono[0] * super.latiPoligono[1];
	}
}
