package it.intersistemi.corsojava.generics.esempi.bracciomeccanico;

public class MechanicalArmMain {
	public static void main(String[] args){
		Bottle<Water> waterBottle = new Bottle<Water>(new Water());
		Bottle<Wine> wineBottle = new Bottle<Wine>(new Wine());
		MechanicalArm mechanicalArm = new MechanicalArm();
		mechanicalArm.takeBottle(waterBottle);
		mechanicalArm.takeBottle(wineBottle);
	}
}
