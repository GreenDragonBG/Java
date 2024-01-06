package Main;

import javax.management.remote.SubjectDelegationPermission;

public class Armour extends Item {
	private int defence;
	
	public Armour(String name,int defense) {
		super(name);
		this.setDefence(defense);
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defense) {
		this.defence = defense;
	}

}
