package Main;

public class Bag extends Item {
	private Item[] slots;

	public Bag(String name) {
		super(name);
		slots = new Item[6];
	}

	public void add(Item item) throws Exception {
		for (int i = 0; i < slots.length; i++) {
			if (slots[i] == null) {
				slots[i] = item;
				break;
			}else if (i == slots.length - 1) {
				for(int j = 0; j < slots.length; j++) {
					if (slots[j] instanceof Bag) {
						Bag temp = (Bag) slots[j];
						temp.add(item);
						slots[j] = temp;
						break;
					}else if(j == slots.length - 1) {
						throw new Exception("Bag out of space");
					}
				}
				
			}
		}
	}
	
	public Item[] getSlots() {
		return slots;
	}
}
