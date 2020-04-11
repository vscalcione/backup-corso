package it.intersistemi.corsojava.ereditarieta.esempi;

public interface B1 extends A {
	@Override
	default String a() {
		return "Sono B1";
	}
}
