package it.intersistemi.corsojava.streams.esercizi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.intersistemi.esercitazionelambdaexpression.Person;
import it.intersistemi.esercitazionelambdaexpression.Person.Sex;

public class StreamExampleMain {
	
	

	public static void main(String[] args) {
		
		List<Person> roster = generatePeople();
		
		List<String> femaleNameList = roster.stream() 
				.filter(p -> p. getGender () == Sex.FEMALE)
				.map(Person::getName)
				.collect(Collectors.toList());
		
		femaleNameList.forEach( s -> System.out.println(s));
		
		for (String s : femaleNameList) {
			System.out.println(s);
		}
		
	 double media =
				roster.stream() 
		.filter(p -> p.getGender() == Sex.MALE)
		.mapToInt(p ->p.getAge1() )
		.average()
		// .getAsDouble();
		.orElse(0);
				System.out.println(media);
				}
	
	
	private static List<Person> generatePeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Alessio", LocalDate.of(2000, 1, 2), Sex.MALE, ""));
		people.add(new Person("Alessio", LocalDate.of(2004, 4, 4), Sex.MALE, ""));
		people.add(new Person("Alessio", LocalDate.of(2011, 1, 9), Sex.MALE, ""));
		people.add(new Person("Alessio", LocalDate.of(2015, 8, 12), Sex.MALE, ""));
		people.add(new Person("Alessio", LocalDate.of(1600, 1, 7), Sex.MALE, ""));
		people.add(new Person("Alessio", LocalDate.of(2010, 6, 2), Sex.MALE, ""));
		people.add(new Person("Alessio", LocalDate.of(2006, 12, 2), Sex.MALE, ""));
		people.add(new Person("Alessio", LocalDate.of(2012, 1, 2), Sex.MALE, ""));
		people.add(new Person("Alessio", LocalDate.of(2001, 1, 2), Sex.MALE, ""));
		return people;
		
	}
	
	
	
	
	

}
