package library;

public class Main {
	public static void main(String[] args) {
		Book b1 = new Book("Book1", 0, false, "Petur", 110);
		Book b2 = new Book("Book2", 1, false, "Georgi", 220);
		
		DVD d1 = new DVD("DVD1", 0, false, "Ivan", 110);
		DVD d2 = new DVD("DVD2", 0, false, "Dimitur", 110);
		
		Library library = new Library();
		library.addItem(b1);
		library.addItem(b2);
		library.addItem(d1);
		library.addItem(d2);
		
		System.out.println(b1.displayInfo());
		System.out.println(b2.displayInfo());
		
		System.out.println(d1.displayInfo());
		System.out.println(d2.displayInfo());
		
		System.out.println();
		System.out.println(library.displayItems());
	}
}
