package zadachi;

import java.io.File;
import java.util.Arrays;
import java.util.List;

//Да се изведат всички файлове в дадена директория, които имат разширение ".txt".
public class Zad4 {
	public static void main(String[] args) {
		String directory = "C:\\Users\\PC\\OneDrive\\Работен плот\\Recepie";
		for(String s : txtFiles(directory)) {
			System.out.println(s);
		}
	}
	
	public static List<String> txtFiles(String directory){
		File file = new File(directory);
		return Arrays.stream(file.listFiles()).filter(f -> f.getName().contains(".txt")).map(f -> f.getName()).toList();
	}
}
