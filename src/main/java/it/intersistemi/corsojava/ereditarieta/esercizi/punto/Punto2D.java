package it.intersistemi.corsojava.ereditarieta.esercizi.punto;

public class Punto2D extends PuntoLineare{
	private int coordinateY;
	
	public Punto2D(int coordinateX, int coordinateY) {
		super(coordinateX);
		System.out.println("Punto2D: "+coordinateX+", "+coordinateY);
		this.coordinateY = coordinateY;
	}

	public int getCoordinateY() {
		return coordinateY;
	}
}
