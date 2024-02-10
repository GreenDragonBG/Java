package zadachi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zad12 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("sports");
		list.add("apple");
		list.add("sports");
		list.add("midnight");
		list.add("sports");
		list.add("midnight");
		list.add("computer");
		list.add("mouse");
		list.add("midnight");
		list.add("keyboard");
	
		for(String s : findWords(list)) {
			System.out.println(s);
		}
	}

	public static List<String> findWords(List<String> list) {
		return list.stream().filter(s -> s.toCharArray().length>5).filter(s -> Collections.frequency(list, s) >2).distinct().toList();
	}
}
