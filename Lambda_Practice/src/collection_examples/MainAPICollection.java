package collection_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainAPICollection 
{
	public static void main(String...strings )
	{
		Person p1 = new Person("A",23);
		Person p2 = new Person("B",34);
		Person p3 = new Person("D",30);
		Person p4 = new Person("C",25);
		Person p5 = new Person("M",22);
		Person p6 = new Person("X",40);	
		
		
		List<Person> people = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));
//		people.forEach(person -> System.out.println(person));
		people.forEach(System.out::println);
		
		System.out.println("---------------------------");		
		
		people.removeIf(Person -> Person.getAge()<30);
		
		people.replaceAll(  person -> new Person( person.getName().toLowerCase() , person.getAge() ) );
		
		people.sort(Comparator.comparing(Person::getAge));
		
		people.forEach(System.out::println);
		
		System.out.println("---------------------------");
		
		people.sort(Comparator.comparing(Person::getAge).reversed());
		people.forEach(System.out::println);

	}
	

}
