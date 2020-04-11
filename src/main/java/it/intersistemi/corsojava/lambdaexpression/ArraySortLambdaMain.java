package it.intersistemi.corsojava.lambdaexpression;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import it.intersistemi.esercitazionelambdaexpression.Person.Sex;

public class ArraySortLambdaMain {
	
	

	public static void main(String[] args) {
		List<Person> roster = generatePeople();
		
		System.out.println("======= printPeopleOlderThan ============");
		printPeopleOlderThan(roster, 10);
		System.out.println("======= printPeopleAgeBetween ===========");
		printPeopleAgeBetween(roster, 18, 40);
		System.out.println("====== printPeopleNameStartsWith =========");
		printPeopleNameStartsWith(roster, "A"); 
		
		System.out.println( "====== printPeople ==========");
		printPeople(roster, new CheckPerson() {
			
			public boolean test (Person person) {
				return person.getGender() == Sex.MALE &&
						person.getAge1() >=15 &&
						person.getAge1() <= 40;
			}
		});
		
		System.out.println(" ====== processPeopleWithFunction (Lambda ========");
		processPeopleWithFunction(roster,
				p -> p.getGender() == Sex.FEMALE && p.getAge1() > 20,
				p -> p.getName(),
				s -> System.out.println(s)
				
				
				
				);
		System.out.println("/n"+"======== processElements2 (con uso dei Generics ===");
		List<String> listaDiStringhe = Arrays.asList(new String [] ("1", "2", "3"));
		processElements(listaDiStringhe, s -> s.equals("2")),
		
		
		
		
	
	
	}
	
	private static void printPeopleOlderThan(List<Person> roster, int age) {
		for (Person person : roster) {
			if(person.getAge1() >= age) {
				person.printPerson();
			}
		}
	}
	
	private static void printPeopleNameStartsWith(List<Person> roster, String namePrefix) {
		for (Person person : roster) {
			if(person.getName().startsWith(namePrefix)) {
				person.printPerson();
			}
		}
	}
	
	
	
	private static void printPeopleAgeBetween(List<Person> roster, int ageMin, int ageMax) {
		for (Person person : roster) {
			if(person.getAge1() >= ageMin && person.getAge1() <= ageMax) {
			person.printPerson();
			}
		}
	}
	
	private static void printPeople(List<Person> roster, CheckPerson tester) {
		for (Person person : roster) {
			if(tester.test(person)) {
				person.printPerson();
			}
		}
	}
	
	private static void processPeopleWithFunction(List<Person> roster,
			Predicate<Person> tester,
			Function<Person, String> mapper,
			Consumer<String> block
			
			) {
		for (Person person : roster) {
			if(tester.test(person)) {
				String data = mapper.apply(person);
				block.accept(data);
			}
		}
	}
	
	private static <X, Y> void processElements(Iterable<X> source,
			Predicate<X> tester,
			Function<X, Y> mapper,
			Consumer<Y> block) { 
		for (X person : source) {
			if (tester.test(person)) {
				Y data = mapper.apply(person);
				block.accept(data);
				
				processElements(Arrays.asList(new String[]))
			}
		}
		
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


