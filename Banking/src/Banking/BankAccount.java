package Banking;

import java.util.Scanner;

public abstract class  BankAccount {
	private String IBAN;
	protected double amount;
	private int userId;

	public BankAccount(String IBAN, double amount, int userId) {
		this.amount = amount;
		this.IBAN = IBAN;
		this.userId = userId;
	}

	public void addAmount(double amount) throws AmountOutOfBouds {
		if (amount < 0) {
			throw new AmountOutOfBouds("Can't add a negative amount");
		} else if (amount == 0) {
			throw new AmountOutOfBouds("Can't add an amount of zero");
		} else {
			this.amount += amount;
		}

	}

	public double takeAmount(double amount) throws AmountOutOfBouds {
		if (amount < 0) {
			throw new AmountOutOfBouds("Can't take a negative amount");
		} else if (amount == 0) {
			throw new AmountOutOfBouds("Can't take an amount of zero");
		} else if (this.amount < amount) {
			throw new AmountOutOfBouds("Can't take more than the amount in the Bank Account");
		} else {
			this.amount -= amount;
			return this.amount;
		}
	}

	public void load(double amount) throws AmountOutOfBouds {
		if (amount < 0) {
			throw new AmountOutOfBouds("Can't add a negative amount");
		} else if (amount == 0) {
			throw new AmountOutOfBouds("Can't add an amount of zero");
		} else {
			this.amount += amount;
		}
	}
	
	public String getIBAN() {
		return IBAN;
	}
	public double getAmount() {
		return amount;
	}
	public int getUserId() {
		return userId;
	}
}
