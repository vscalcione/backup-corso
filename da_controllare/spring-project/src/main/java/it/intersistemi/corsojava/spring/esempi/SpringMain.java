package it.intersistemi.corsojava.spring.esempi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.intersistemi.corsojava.spring.esempi.app.A;
import it.intersistemi.corsojava.spring.esempi.app.B;
import it.intersistemi.corsojava.spring.esempi.app.C;

public class SpringMain {
	public static void main(String[] args) {
//		A a = new A();
//		C c = new C();
//		B b = new B();
//		b.setC(c);
//		a.setB(b);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-ctx.xml");	
		A a = ctx.getBean(A.class);
		System.out.println(a.getB().getC());
	}
}