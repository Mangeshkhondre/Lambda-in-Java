package collection_examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainAPICollectionMap {

	public static void main(String[] args) 
	{
		Person p1 = new Person("A",23);
		Person p2 = new Person("B",34);
		Person p3 = new Person("D",30);
		Person p4 = new Person("C",25);
		Person p5 = new Person("M",22);
		Person p6 = new Person("X",40);
		
		City c1 = new City("c1");
		City c2 = new City("c2");
		City c3 = new City("c3");
		
		Map<City,List<Person>> map = new HashMap<>();
		
		
		// getOrDefault() example
		System.out.println("People from c1 = "+map.get(c1));
		System.out.println("People from c1 = "+map.getOrDefault(c1, Collections.EMPTY_LIST));
		

		// Adding data to map = putIfAbsent(), computeIfAbsent()
		map.putIfAbsent(c1, new ArrayList<>());
		map.get(c1).add(p1);
		map.get(c1).add(p2);
		
		map.computeIfAbsent(c2,city-> new ArrayList<>()).add(p3);
		map.computeIfAbsent(c2,city-> new ArrayList<>()).add(p4);
		
		System.out.println("\npeople from c1 = "+map.get(c1));
		System.out.println("people from c2 = "+map.get(c2));
		
		// merge maps
		
		Map<City,List<Person>> map1 = new HashMap<>();
		Map<City,List<Person>> map2 = new HashMap<>();
		
		map1.computeIfAbsent(c1,city-> new ArrayList<>()).add(p1);
		map1.computeIfAbsent(c1,city-> new ArrayList<>()).add(p2);
		map1.computeIfAbsent(c2,city-> new ArrayList<>()).add(p3);

		map2.computeIfAbsent(c2,city-> new ArrayList<>()).add(p4);
		map2.computeIfAbsent(c3,city-> new ArrayList<>()).add(p5);
		map2.computeIfAbsent(c3,city-> new ArrayList<>()).add(p6);
		
		System.out.println("\nMap1 = ");
		map1.forEach((city,person)->System.out.println("\t"+city+" : "+person));
		System.out.println("\nMap2 = ");
		map2.forEach((city,person)->System.out.println("\t"+city+" : "+person));
		
		map2.forEach((city,people) -> {
										map1.merge(city	,people , (peopleFromMap1,peopleFromMap2)->{
																									peopleFromMap1.addAll(peopleFromMap2);
																									return peopleFromMap1;
																									}								
													);
									  }
					);
		System.out.println("\n Merged Map1 = ");
		map1.forEach((city,person)->System.out.println("\t"+city+" : "+person));

		
		
	}

}
