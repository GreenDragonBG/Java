package zadachi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//Да се групират обекти от списък по даден атрибут и да се изведат всички групи.

public class Zad5 {
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
		
		for(int key :groupObjects(list).keySet()) {
			System.out.print(key+":  ");
			for(Person p : groupObjects(list).get(key)) {
				System.out.print(p.name+", ");
			}
			System.out.println();
		}
	}
	public static Map<Integer, List<Person>> groupObjects(List<Person> list) {
		return list.stream().collect(Collectors.groupingBy(p -> p.age));
	}
	
}
