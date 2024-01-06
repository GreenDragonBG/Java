package library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	static final String BOOK_TITLE = "Book1";
	static final int BOOK_ID = 1;
	static final boolean BOOK_ISCHECKEDOUT = true;
	static final String BOOK_AOUGHTOR = "Aoughtor1";
	static final int BOOK_NUMPAGES = 100;
	Book book;
	@Test
	void BookCration_success() {
		book = new Book(BOOK_TITLE, BOOK_ID, BOOK_ISCHECKEDOUT, BOOK_AOUGHTOR, BOOK_NUMPAGES);
		assertEquals(book.displayInfo(), "The book " + BOOK_ID + " whith title " + BOOK_TITLE + ", with author " + BOOK_AOUGHTOR + " and number of pages: "
				+  BOOK_NUMPAGES  + ", has a status of been cheaked out: " +BOOK_ISCHECKEDOUT + ".");
	}

}
