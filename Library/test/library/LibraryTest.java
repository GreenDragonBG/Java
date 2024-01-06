package library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.extensions.TestSetup;

class LibraryTest {
	Item item_NotCheckedOut = new Item("Item1", 0, false) {	};
	Item item_CheckedOut = new Item("Item2", 1, true) {	};
	Library library;
	
	@BeforeEach
	private void Setup() {
		library = new Library();
	}
	@Test
	void addItem() {
		library.addItem(item_NotCheckedOut);
		assertFalse(library.displayItems().equals(""));
	}
	@Test
	void displayItems_empty() {
		assertEquals(library.displayItems(),"");
	}
	@Test
	void checkoutItem() {
		library.addItem(item_NotCheckedOut);
		library.checkoutItem(item_NotCheckedOut.getItemID());
		assertTrue(item_NotCheckedOut.getIsCheckedOut());
	}
	@Test
	void returnItem() {
		library.addItem(item_CheckedOut);
		library.returnItem(item_CheckedOut.getItemID());
		assertFalse(item_CheckedOut.getIsCheckedOut());
		
	}

}
