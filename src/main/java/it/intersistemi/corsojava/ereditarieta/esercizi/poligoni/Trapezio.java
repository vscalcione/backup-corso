package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public class Trapezio extends Poligono{
	protected double BaseMaggiore, BaseMinore, lato;
	public Trapezio(double BaseMaggiore, double BaseMinore, double lato) {
		super(new double[] {});
		this.BaseMaggiore=BaseMaggiore;
		this.BaseMinore=BaseMinore;
		this.lato=lato;
	}
	
	@Override
	public double calcolaPerimetro() {
		double result=((this.BaseMaggiore + this.BaseMinore) + (this.lato * 2));
		return result;
	}
}
