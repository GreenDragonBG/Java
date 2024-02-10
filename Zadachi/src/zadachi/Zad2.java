package zadachi;

import java.io.Console;
import java.util.Arrays;

public class Zad2 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println(sum(arr));
		
	}
	
	public static int sum(int[] arr) {
		return Arrays.stream(arr).reduce(0, (a,b) ->a+b);
	}
}
