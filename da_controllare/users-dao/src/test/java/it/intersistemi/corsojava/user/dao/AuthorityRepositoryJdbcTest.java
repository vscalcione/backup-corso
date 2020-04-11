package it.intersistemi.corsojava.user.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.dbcp2.BasicDataSource;

import it.intersistemi.corsojava.users.dao.AuthorityRepository;
import it.intersistemi.corsojava.users.dao.jdbc.impl.AuthorityRepositoryImpl;
import it.intersistemi.corsojava.users.model.Authority;

public class AuthorityRepositoryJdbcTest {
	private static BasicDataSource ds = new BasicDataSource();
	static {
		ds.setUrl("jdbc:h2:~/database_esercitazione");
		ds.setUsername("sa");
		ds.setPassword("");
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader leggi = new BufferedReader(new InputStreamReader(System.in));
		AuthorityRepository authorityRepository = new AuthorityRepositoryImpl(ds);
		Authority entity = new Authority();
		System.out.print("Inserisci stringa: ");
		String value1 = String.valueOf(leggi.readLine());
		System.out.print("Inserisci stringa: ");		
		String value2 = String.valueOf(leggi.readLine());
		entity.setAuthority(value1);
		entity.setDescription(value2);
		authorityRepository.insert(entity);
		Iterable<Authority> it = authorityRepository.findAll();
		it.forEach(a -> System.out.println(
				a.getAuthority()
				+ " - "
				+ a.getDescription()));
	}
}
