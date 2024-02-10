package zadachi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Zad15 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("ads");
		list.add("tgb");
		list.add("dsa");
		list.add("trq");
		list.add("bgt");
		list.add("lko");
		list.add("oiu");
	
		for(String s : findWords(list)) {
			System.out.println(s);
		}
	}

	public static List<String> findWords(List<String> list) {
		return list;
		
	}
}
