package Banking;

public class DebitBankAccount extends BankAccount {

	public DebitBankAccount(String IBAN, double amount, int userId) {
		super(IBAN, amount, userId);
	}

	public double withdraw(double amount) throws AmountOutOfBouds {
		if (amount < 0) {
			throw new AmountOutOfBouds("Can't take a negative amount");
		} else if (amount == 0) {
			throw new AmountOutOfBouds("Can't take an amount of zero");
		} else if (this.amount < amount) {
			throw new AmountOutOfBouds("Can't take more than the amount in the Bank Account");
		} else {
			amount *= 1.01;
			this.amount -= amount;
			return this.amount;
		}
	}
	
	@Override
	public void addAmount(double amount) throws AmountOutOfBouds {
		amount*=0.98;
		super.addAmount(amount);
	}

}
