package Main;

public class Hero {
	private String name;
	private Classes type;
	private Weapon[] weapons;
	private Armour[] armour;
	private Potion[] potions;
	private Bag bag;

	public Hero(String name, Classes type) {
		this.name = name;
		this.type = type;
		this.weapons = new Weapon[2];
		this.armour = new Armour[4];
		this.potions = new Potion[6];
		this.bag = new Bag("Main");
	}

	public void equipItem(Item item) throws Exception {
		if (item instanceof Weapon) {
			for (int i = 0; i < weapons.length; i++) {
				if (weapons[i] == null) {
					weapons[i] = (Weapon) item;
					break;
				} else if (i == weapons.length - 1) {
					throw new Exception("Weapon stash is out of space");
				}
			}
		} else if(item instanceof Armour) {
			for (int i = 0; i < armour.length; i++) {
				if (armour[i] == null) {
					armour[i] = (Armour) item;
					break;
				} else if (i == armour.length - 1) {
					throw new Exception("Armour slots are out of space");
				}
			}
		}else if(item instanceof Potion) {
			for (int i = 0; i < potions.length; i++) {
				if (potions[i] == null) {
					potions[i] = (Potion) item;
					break;
				} else if (i == potions.length - 1) {
					throw new Exception("Potion stash is out of space");
				}
			}
		}
	}
	
	public void pickUpItem(Item item) throws Exception {
		bag.add(item);
	}
}
