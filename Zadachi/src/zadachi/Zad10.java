package zadachi;

import java.util.ArrayList;
import java.util.List;

public class Zad10 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {} ;
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(8);
		list.add(1);
		list.add(5);
		list.add(10);
		list.add(6);
		list.add(9);
		list.add(7);
		
		System.out.println(largestNum(list));
		
	}
	
	public static int largestNum(List<Integer> list) {
		 return list.stream().sorted((o1,o2) -> o2.intValue() - o1.intValue()).findFirst().get();
	}
}
