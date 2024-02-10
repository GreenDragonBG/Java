package zadachi;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Да се изведат всички уникални думи от текстов файл.
public class Zad3 {
	public static void main(String[] args) {
		String string = "midnight, apple, tennis, midnight, tennis, midnight";
		for(String s : uniqueWords(string)) {
			System.out.println(s);
		}
	}
	
	public static List<String> uniqueWords(String words) {
		words = words.replace(" ", "");
		return  Arrays.stream(words.split(",")).distinct().collect(Collectors.toList());
	} 
}
