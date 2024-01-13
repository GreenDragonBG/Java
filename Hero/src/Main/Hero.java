package Main;

public class Hero {
	private String name;
	private Classes type;
	private Weapon[] weapons;
	private Armour[] armour;
	private Potion[] potions;
	private Bag bag;
	static final int WeponSlots = 2;
	static final int ArmourSlots = 4;
	static final int PotionSlots = 6;

	public Hero(String name, Classes type) {
		this.name = name;
		this.type = type;
		this.weapons = new Weapon[WeponSlots];
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
	
	public Bag getBag() {
		return bag;
	}
	public Weapon[] getWeapons() {
		return weapons;
	}
	public Armour[] getArmour() {
		return armour;
	}
	public Potion[] getPotions() {
		return potions;
	}
}
