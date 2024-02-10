package zadachi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import zadachi.Zad7.Person;

public class Zad8 {
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
		list.add(new Person(25, "Mitko"));
		list.add(new Person(16, "Gosho"));
		list.add(new Person(46, "Pavel"));
		list.add(new Person(25, "Pavel"));
		list.add(new Person(16, "Petur"));
		list.add(new Person(30, "Mitko"));
		list.add(new Person(46, "Ivan"));
		list.add(new Person(16, "Ivan"));
		
		for(Person p : sortByAge(list)) {
			System.out.println(p.age+" :: "+ p.name);
		}
	}
	public static List<Person> sortByAge(List<Person> list) {
		return list.stream().sorted((p1,p2) -> p1.age - p2.age).toList();
	}
}
