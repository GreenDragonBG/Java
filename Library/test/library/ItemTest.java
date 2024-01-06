package library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {
	static final String ITEM_TITLE ="Item1";
	static final int ITEM_ID = 34;
	static final boolean ITEM_ISCHECKEDOUT = true;
	static final boolean ITEM_NOT_CHECKEDOUT = false;
	Item item;
	
	@Test
	void checkOut() {
		item = new Item(ITEM_TITLE,ITEM_ID,ITEM_NOT_CHECKEDOUT) {};
		assertFalse(item.getIsCheckedOut());
		item.checkOut();
		assertTrue(item.isCheckedOut);
	}
	
	@Test
	void returnItem() {
		item = new Item(ITEM_TITLE,ITEM_ID,ITEM_ISCHECKEDOUT) {};
		assertTrue(item.getIsCheckedOut());
		item.returnItem();
		assertFalse(item.isCheckedOut);
	}

}
