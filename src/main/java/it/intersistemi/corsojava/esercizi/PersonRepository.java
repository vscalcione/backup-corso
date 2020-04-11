package it.intersistemi.corsojava.esercizi;
import java.time.LocalDate;
import java.util.*;//utilit�(list arraylist)
import java.util.stream.*;//stream vari
import java.util.function.*;//interfacce funzionali

public class PersonRepository {

	private List<Person> people=new ArrayList<>();
	
	//codice chiamato alla creazione dell'istanza
	{
		for(int i=0;i<1000;i++){
			people.add(new Person("name"+i,
								i%2==0?Person.Sex.MALE:Person.Sex.FEMALE,
								LocalDate.of(1916+(i%100), (i%12)+1, (i%28)+1),
								"email"+i+"@address.com")
						);
		}
	}
	
	public List<Person> getPeople(){
		return people;
	}
	
	public Stream<Person> getPersonByPredicate(Predicate<Person> predicate){
		return people.stream().filter(predicate);
	}
	
}
