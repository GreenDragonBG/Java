package Banking;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(String IBAN, double amount, int userId) {
		super(IBAN, amount, userId);
	}

	@Override
	public double takeAmount(double amount) throws AmountOutOfBouds {
		amount *= 1.03;
		return super.takeAmount(amount);
	}

}
