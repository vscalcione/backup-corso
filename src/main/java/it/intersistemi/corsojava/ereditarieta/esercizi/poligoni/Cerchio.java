package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public class Cerchio extends Poligono {
	private double raggio;
	public Cerchio(double raggio) {
		super(new double[] {});
		this.raggio = raggio;
	}

	public double getRaggio() {
		return raggio;
	}

	@Override
	public double calcolaPerimetro() {
		return 2 * Math.PI * this.raggio;
	}

	@Override
	public double calcolaArea() {
		return Math.PI * this.raggio * this.raggio;
	}
}
