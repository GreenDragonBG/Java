package Main;

public class Armour extends Item {
	private int defense;
	
	public Armour(String name,int defense) {
		super(name);
		this.setDefense(defense);
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

}
