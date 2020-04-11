package it.intersistemi.corsojava.lambdaexpression.esempi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import it.intersistemi.corsojava.stream_java8.esercizi.Person;
import it.intersistemi.corsojava.stream_java8.esercizi.Person.Sex;

public class StreamExampleMain {
	public static void main(String[] args) {
		List<Person> roster = generatePeople();
		List<String> femaleNameList = roster.stream()
				.filter(p ->p.getGender() ==  Sex.FEMALE)
				.map(Person::getName)
				.collect(Collectors.toList());
		femaleNameList.forEach(s ->System.out.println(s));
		for (String s : femaleNameList) {
			System.out.println(s);
		}
		if(!roster.isEmpty()) {
			double media = roster.stream()
					.filter(p ->p.getGender() ==  Sex.MALE)
					.filter(p -> p.getAge() != null)
					.mapToInt(p -> p.getAge())
					.average()
					.getAsDouble();
			System.out.println("Media et� elementi maschili: "+media);
		}
	}

	private static List<Person> generatePeople(){
		List<Person> people = new ArrayList<>();
 		people.add(new Person("Alessio", LocalDate.of(2000, 1, 2), Sex.MALE, "alessio.suoCognome@gmail.com"));
		people.add(new Person("Francesca", LocalDate.of(1979, 5, 23), Sex.FEMALE, "francesca.suoCognome@gmail.com"));
		people.add(new Person("Adolfo", LocalDate.of(1970, 1, 12), Sex.MALE, "adolfo.suoCognome@gmail.com"));
		people.add(new Person("Corben", LocalDate.of(1967, 8, 20), Sex.FEMALE, "corben.suoCognome@gmail.com"));
		people.add(new Person("Dallas", LocalDate.of(1998, 2, 14), Sex.MALE, "dallas.suoCognome@gmail.com"));
		people.add(new Person("Anna", LocalDate.of(1986, 11, 3), Sex.FEMALE, "anna.suoCognome@gmail.com"));
		people.add(new Person("DiClasse", LocalDate.of(1995, 7, 9), Sex.MALE, "diclasse.suoCognome@gmail.com"));
		people.add(new Person("Franca", LocalDate.of(1974, 3, 10), Sex.FEMALE, "franca.suoCognome@gmail.com"));
		people.add(new Person("Piero", LocalDate.of(1996, 4, 15), Sex.MALE, "piero.suoCognome@gmail.com"));
		return people;
	}
}
