package it.intersistemi.corsojava.user.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.intersistemi.corsojava.users.dao.AuthorityRepository;
import it.intersistemi.corsojava.users.model.Authority;

public class AuthorityRepositoryTestSpring {

	public static void main(String[] args) throws IOException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("users-dao-context.xml");
		
//		BufferedReader leggi = new BufferedReader(new InputStreamReader(System.in));
		AuthorityRepository authorityRepository = ctx.getBean(AuthorityRepository.class);
		Authority entity = new Authority();
//		System.out.print("Inserisci stringa: ");
//		String value1 = String.valueOf(leggi.readLine());
//		System.out.print("Inserisci stringa: ");		
//		String value2 = String.valueOf(leggi.readLine());
		entity.setAuthority("VIEW_QUALCOSA");
		entity.setDescription("view_qualcosa");
		authorityRepository.insert(entity);
		Iterable<Authority> it = authorityRepository.findAll();
		it.forEach(a -> System.out.println(
				a.getAuthority()
				+ " - "
				+ a.getDescription()));
	}
}
