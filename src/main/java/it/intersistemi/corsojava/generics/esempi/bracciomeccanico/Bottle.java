package it.intersistemi.corsojava.generics.esempi.bracciomeccanico;

public class Bottle<T> {
	private T content;
	
	public Bottle(T content) {
		this.content = content;
	}
	
	public T getContenuto() {
		return content;
	}
	
	public void setContenuto(T content) {
		this.content = content;
	}
}
