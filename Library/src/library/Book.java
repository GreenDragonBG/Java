package library;

public class Book extends Item {

	private String author;
	private int numPages;

	public Book(String title, int itemID, boolean isCheckedOut, String aughtor, int numPages) {
		super(title, itemID, isCheckedOut);
		this.author = aughtor;
		this.numPages = numPages;
	}

	@Override
	public String displayInfo() {
		return "The book " + itemID + " whith title " + title + ", with author " + author + " and number of pages: "
				+ numPages + ", has a status of been cheaked out: " + isCheckedOut + ".";

	}

}
