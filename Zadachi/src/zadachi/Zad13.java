package zadachi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import zadachi.Zad7.Person;

public class Zad13 {
	public static class Person{
		int age;
		String name;	
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(16, "Ivan"));
		list.add(new Person(16, "Petur"));
		list.add(new Person(16, "Gosho"));
		list.add(new Person(25, "Mitko"));
		list.add(new Person(25, "Pavel"));
		list.add(new Person(30, "Mitko"));
		list.add(new Person(46, "Ivan"));
		list.add(new Person(46, "Pavel"));
		
		for(int key : filterYoungAdults(list).keySet()) {
			for(Person p : filterYoungAdults(list).get(key)) {
				System.out.println(p.age +" :: " + p.name);
			}
		}
	}
	public static Map<Integer, List<Person>> filterYoungAdults(List<Person> list) {
		return list.stream().filter(p -> p.age>=18).filter(p-> p.age<=40).collect(Collectors.groupingBy(p->p.age));
	}
}
