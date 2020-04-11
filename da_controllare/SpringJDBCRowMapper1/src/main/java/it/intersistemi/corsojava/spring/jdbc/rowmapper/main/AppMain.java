package it.intersistemi.corsojava.spring.jdbc.rowmapper.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;
import it.intersistemi.corsojava.spring.jdbc.rowmapper.dao.DipendenteDao;
import it.intersistemi.corsojava.spring.jdbc.rowmapper.model.Dipendente;

public class AppMain {
	public static void main(String[] args) throws IOException{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		DipendenteDao dipendentiDao = (DipendenteDao) applicationContext.getBean("employeeDao");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int dipendentiRicercaId = ConsoleInputInteri.leggiIntero(console, "ID da ricercare: ");
		Dipendente dipendenti = dipendentiDao.findById(1);
		System.out.println("Ricerca da ID");
		System.out.println(dipendenti.toString());
		Collection<Dipendente> listaDipendenti = dipendentiDao.findAll();
		System.out.println("Ricerca di tutti i record");
		for (Dipendente dipendente : listaDipendenti) {
			System.out.println(dipendente.toString());
		}
	}
}