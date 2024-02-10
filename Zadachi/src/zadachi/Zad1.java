package zadachi;
//Да се намерят всички четни числа в списък от цели числа.

import java.io.Console;
import java.util.Arrays;

public class Zad1 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		arr = evenNums(arr);
		for(int i : arr) {
			System.out.print (i+", ");
		}
		
	}
	
	public static int[] evenNums(int[] arr) {
		return Arrays.stream(arr).filter(n -> n%2==0).toArray();
	}
}
