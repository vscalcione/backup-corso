package it.intersistemi.corsojava.amazon.jpadao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("amazon-dao-jpa.xml");
		ProductRepository pr = ctx.getBean(ProductRepository.class);
		pr.findAll().forEach(System.out::println);		
//		System.out.println(pr.findById("A12345AAC"));	
	}
}
