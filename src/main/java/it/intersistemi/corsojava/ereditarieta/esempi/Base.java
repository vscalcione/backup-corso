package it.intersistemi.corsojava.ereditarieta.esempi;

public class Base {
	public boolean confrontaTipo(Base other) {
		return this.getClass().equals(other.getClass());
	}
}
