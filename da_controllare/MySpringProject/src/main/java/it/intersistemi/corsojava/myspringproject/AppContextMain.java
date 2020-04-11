package it.intersistemi.corsojava.myspringproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import it.intersistemi.corsojava.myspringproject.component_scan.UserContainer;

public class AppContextMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");	
		User user = context.getBean(User.class);
		System.out.println(user.getName() + "\n" + user.getSurname() + "\n" + user.getEmail());
		UserContainer containerUser = context.getBean("userContainer", UserContainer.class);
		System.out.println(containerUser);
	}
}
