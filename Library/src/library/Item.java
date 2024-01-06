package library;

public abstract class Item {
	protected String title;
	protected int itemID;
	protected boolean isCheckedOut;

	public Item(String title, int itemID, boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
		this.itemID = itemID;
		this.title = title;
	}

	public void checkOut() {
		isCheckedOut = true;
	}

	public void returnItem() {
		isCheckedOut = false;
	}

	public String displayInfo() {
		return "The item " + itemID + " whith title " + title + "has a status of been cheaked out: " + isCheckedOut
				+ " .";
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public boolean getIsCheckedOut() {
		return isCheckedOut;
	}

}
