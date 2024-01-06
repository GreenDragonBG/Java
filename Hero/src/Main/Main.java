package Main;

public class Main {
	public static void main(String[] args) throws Exception {
		Hero h  = new Hero("Hero", Classes.ROGUE);
		Armour w1 = new Armour("Knife", 20);
		Bag bag = new Bag("Second");
		h.pickUpItem(bag);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);
		h.pickUpItem(w1);

	}
}
