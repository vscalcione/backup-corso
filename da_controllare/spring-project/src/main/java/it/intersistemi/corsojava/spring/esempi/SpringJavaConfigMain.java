package it.intersistemi.corsojava.spring.esempi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import it.intersistemi.corsojava.spring.esempi.app.A;

public class SpringJavaConfigMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfig.class);	
		A a = ctx.getBean("beanA1", A.class);
		System.out.println(a.getB().getC());
	}
}