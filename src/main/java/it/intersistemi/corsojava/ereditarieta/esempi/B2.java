package it.intersistemi.corsojava.ereditarieta.esempi;

//import main.java.it.intersistemi.corsojava.polimorfismo.esempi.A;

public interface B2 extends A {
	@Override
	default String a() {
		return "Sono B2";
	}

}
