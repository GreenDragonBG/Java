package zadachi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import zadachi.Zad13.Person;

public class Zad14 {
	public static class Items{
		int item1;
		int item2;
		int item3;
		public Items(int item1, int item2 , int item3) {
			
			this.item1 = item1;
			this.item2 = item2;
			this.item3 = item3;
		}
	}
	public static void main(String[] args) {
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(16, 7, 8));
		list.add(new Items(14, 6, 20));
		list.add(new Items(16, 9, 7));
		list.add(new Items(10, 4, 5));
		list.add(new Items(1, 9, 8));
		list.add(new Items(12, 5, 9));
		list.add(new Items(18, 10, 8));
		list.add(new Items(4, 1, 2));
		
		for(Items i : filterSum(list)) {
			System.out.println(i.item1+ ", " + i.item2 + ", " + i.item3);
		}
		
	}
	public static List<Items> filterSum(List<Items> list) {
		return list.stream().filter(i -> i.item1 == i.item2+i.item3 || i.item2 == i.item1+i.item3 || i.item3 == i.item1+i.item2).toList();
	}
}
