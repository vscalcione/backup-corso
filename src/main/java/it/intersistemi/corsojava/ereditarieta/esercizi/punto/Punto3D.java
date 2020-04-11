package it.intersistemi.corsojava.ereditarieta.esercizi.punto;

public class Punto3D extends Punto2D{
	private int coordinateZ;
	
	
	public Punto3D(int coordinateX, int coordinateY, int coordinateZ) {
		super(coordinateX, coordinateY);
		this.coordinateZ = coordinateZ;
		System.out.println("Punto3D: " + coordinateX + ", " + coordinateY + ", " + coordinateZ);
	}

	public int getCoordinateZ() {
		return coordinateZ;
	}
}
