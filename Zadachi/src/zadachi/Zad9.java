package zadachi;

import java.util.ArrayList;
import java.util.List;

public class Zad9 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("Sports");
		list.add("midnight");
		list.add("computer");
		list.add("Mouse");
		list.add("Keyboard");
	
		for(String s : upperCased(list)) {
			System.out.println(s);
		}
	}

	public static List<String> upperCased(List<String> list) {
		return list.stream().filter(s -> Character.isUpperCase(s.toCharArray()[0])).toList();
	}
}

