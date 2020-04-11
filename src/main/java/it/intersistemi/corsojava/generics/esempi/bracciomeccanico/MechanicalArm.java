package it.intersistemi.corsojava.generics.esempi.bracciomeccanico;

public class MechanicalArm {
	public void takeBottle(Bottle<?> bottiglia) {
		try {
			System.out.println("BraccioMeccanico: Ho preso"+bottiglia.getContenuto());
			Thread.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
