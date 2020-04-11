package it.intersistemi.corsojava.ereditarieta.esempi;

public class C implements B1,B2{
	@Override
	public String a() {
		return B1.super.a() + " - "+ B2.super.a() + " - In realt� sono C";
	}

	public static void main(String[] args) {
		C c=new C();
		System.out.println(c.a());
	}
}
