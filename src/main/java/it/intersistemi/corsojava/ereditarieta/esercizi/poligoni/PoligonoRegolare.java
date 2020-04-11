package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public interface PoligonoRegolare {
	public default double calcolaApotema() {
		double variable = getLato() / (2 * Math.tan(Math.PI / getNumeroLati()));
		variable = Math.round(variable);
		return variable;
	}

	public default double calcolaArea() {
		return calcolaPerimetro() * calcolaApotema() / 2;
	}
	
	public double calcolaPerimetro();
	public double getLato();
	public int getNumeroLati();
}
