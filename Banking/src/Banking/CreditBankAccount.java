package Banking;

public class CreditBankAccount extends BankAccount {
	private double creditLimit;

	public CreditBankAccount(String IBAN, double amount, int userId, double creditLimit) {
		super(IBAN, amount, userId);
		this.creditLimit = creditLimit;
	}

	public double withdraw(double amount) throws AmountOutOfBouds {
		if (amount < 0) {
			throw new AmountOutOfBouds("Can't take a negative amount");
		} else if (amount == 0) {
			throw new AmountOutOfBouds("Can't take an amount of zero");
		} else if ((this.amount + this.creditLimit) < amount) {
			throw new AmountOutOfBouds("Can't take more than the credit limit allows in the Bank Account");
		} else {
			amount *= 1.05;
			this.amount -= amount;
			return this.amount;
		}
	}

	@Override
	public double takeAmount(double amount) throws AmountOutOfBouds {
		amount *= 0.98;
		if (amount < 0) {
			throw new AmountOutOfBouds("Can't take a negative amount");
		} else if (amount == 0) {
			throw new AmountOutOfBouds("Can't take an amount of zero");
		} else if ((this.amount + this.creditLimit) < amount) {
			throw new AmountOutOfBouds("Can't take more than the credit limit allows in the Bank Account");
		} else if (this.amount < amount) {
			double temp1 = amount - this.amount;
			double temp2 = amount - temp1;
			temp2 *= 1.02;
			temp1 *= 1.05;
			this.amount -= (temp2 + temp1);
			return this.amount;
		} else {
			this.amount -= amount;
			return this.amount;
		}
	}

	@Override
	public void load(double amount) throws AmountOutOfBouds {
		if (amount < 0) {
			throw new AmountOutOfBouds("Can't add a negative amount");
		} else if (amount == 0) {
			throw new AmountOutOfBouds("Can't add an amount of zero");
		} else if (this.amount < 0) {
			amount *= 0.97;
			this.amount += amount;
		} else {
			this.amount += amount;
		}
	}
	
	public double getCreditLimit() {
		return creditLimit;
	}

}
