package it.intersistemi.corsojava.esercizi;
import java.util.*;

public class ProvaPerson {

	public static void main(String[] args) {
		PersonRepository persone=new PersonRepository();
		List<Person> listaPersone=persone.getPeople();
		listaPersone.stream()
					.filter(p->p.getGender() == Person.Sex.MALE)
					.map(p->p.getName())
					.forEach(nome -> System.out.println(nome));
	}

}
