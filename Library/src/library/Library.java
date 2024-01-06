package library;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Library {
	private ArrayList<Item> items;

	public Library() {
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

	public String displayItems() {
		StringJoiner itemsStr = new StringJoiner("\r\n");
		for (int i = 0; i < items.size(); i++) {
			itemsStr.add(items.get(i).displayInfo());
		}
		String temp = itemsStr.toString(); 
		return itemsStr.toString();
	}

	public void checkoutItem(int itemID) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getItemID() == itemID) {
				items.get(i).checkOut();
				break;
			}
		}
	}

	public void returnItem(int itemID) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getItemID() == itemID) {
				items.get(i).returnItem();
				break;
			}
		}
	}
	
}
