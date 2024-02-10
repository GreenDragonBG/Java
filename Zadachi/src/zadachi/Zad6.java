package zadachi;

import java.util.ArrayList;
import java.util.List;

public class Zad6 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("sports");
		list.add("midnight");
		list.add("computer");
		list.add("mouse");
		list.add("keyboard");
		
		System.out.println(avrageLeght(list));
	}
	
	public static double avrageLeght(List<String> list) {
		int count =list.size();
		int sum =list.stream().map(s -> s.toCharArray().length).reduce(0, (a,b) -> a+b);
		return ((double)sum)/count;
	}
}
