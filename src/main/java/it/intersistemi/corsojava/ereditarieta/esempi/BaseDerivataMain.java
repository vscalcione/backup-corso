package it.intersistemi.corsojava.ereditarieta.esempi;

public class BaseDerivataMain {
	public static void main(String[] args) {
		Base b1=new Base();
		Base b2=new Derivata();
		Derivata d=new Derivata();		
		System.out.println("b1.confrontaTipo(b2): "+ b1.confrontaTipo(b2));
		System.out.println("b1.confrontaTipo(d): "+ b1.confrontaTipo(d));
		System.out.println("b2.confrontaTipo(d): "+ b2.confrontaTipo(d));

		/*System.out.println("b1.confrontaTipo(b2): "+ b1.confrontaTipo(b1));		
		System.out.println("b1.confrontaTipo(b1): "+ b1.confrontaTipo(b1));
		System.out.println("b1.confrontaTipo(b2): "+ b1.confrontaTipo(b2));*/
	}
}
