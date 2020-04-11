package it.intersistemi.corsojava.spring.esempi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.intersistemi.corsojava.spring.esempi.app.A;
import it.intersistemi.corsojava.spring.esempi.app.B;
import it.intersistemi.corsojava.spring.esempi.app.C;

@Configuration
public class SpringJavaConfig {
	@Bean
	public A beanA1(B b) {
		A a = new A();
		a.setB(b);
		return a;
	}
	
	@Bean @Autowired
	public A beanA2(B b) {
		A a = new A();
		a.setB(b);
		return new A();
	}
	
	@Bean @Autowired
	public B beanB(C c) {
		B b = new B();
		b.setC(c);
		return b;
	}
	
	@Bean
	public C beanC() {
		return new C();
	}
}