package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {
	Item item;
	static final String ITEM_NAME= "Item1";
	
	@Test
	void ItemCreation() {
		item = new Item(ITEM_NAME) {};
		assertEquals(item.getName(),ITEM_NAME);
	}

}
