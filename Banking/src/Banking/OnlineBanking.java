package Banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OnlineBanking {
	private List<BankAccount> bankAccounts;
	private List<User> users;

	public OnlineBanking() {
		this.bankAccounts = new ArrayList<BankAccount>();
		this.users = new ArrayList<User>();
	}

	public int registerUser(String name) {
		Random rand = new Random();
		int i = 1;
		int id = 0;
		while (true) {
			if (users.size() / i >= 1) {
				i *= 10;
			} else {
				i *= 10;
				id = rand.nextInt(10000, 100000) * (i * 10) + users.size();
				break;
			}
		}
		User user = new User(id, name);
		users.add(user);
		return id;
	}

	public void registerBankAccount(int userId, AccountType accountType) throws UnknownUser {
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == userId) {
				break;
			} else if (i == users.size() - 1) {
				throw new UnknownUser("The user doesnt exist");
			}
		}

		Random rand = new Random();
		String IBAN = "";
		for (int i = 1; i <= 22; i++) {
			int temp = rand.nextInt(1, 4);
			if (temp == 1) {
				IBAN += (char) rand.nextInt(47, 58);
			} else if (temp == 2) {
				IBAN += (char) rand.nextInt(65, 91);
			} else {
				IBAN += (char) rand.nextInt(97, 123);
			}
		}
		if (accountType == AccountType.CREDITBANKACCOUNT) {
			BankAccount account = new CreditBankAccount(IBAN, 0, userId, 0);
		} else if (accountType == AccountType.DEBITBANKACCOUNT) {
			BankAccount account = new DebitBankAccount(IBAN, 0, userId);
		} else {
			BankAccount account = new SavingsAccount(IBAN, 0, userId);
		}
	}
	public void load(String IBAN, double amount) throws UnknownBankAccount, AmountOutOfBouds {
		for(int i=0; i< bankAccounts.size();i++) {
			if(bankAccounts.get(i).getIBAN() == IBAN) {
					bankAccounts.get(i).load(amount);
				break;
			}else if(i == bankAccounts.size()-1) {
				throw new UnknownBankAccount("There is not such Bank Account");
			}
		}
	}

	public double withdraw(String accountIBAN, double amount) throws UnknownBankAccount, AmountOutOfBouds  {
		for(int i=0; i< bankAccounts.size();i++) {
			if(bankAccounts.get(i).getIBAN() == accountIBAN) {
					if(bankAccounts.get(i) instanceof CreditBankAccount) {
						((CreditBankAccount) bankAccounts.get(i)).withdraw(amount);
						return bankAccounts.get(i).getAmount();
					}else if(bankAccounts.get(i) instanceof DebitBankAccount) {
						((DebitBankAccount) bankAccounts.get(i)).withdraw(amount);
						return bankAccounts.get(i).getAmount();
					}else {
						throw new UnknownBankAccount("Cant withdraw form a Savings Bank Account");
					}
			}else if(i == bankAccounts.size()-1) {
				throw new UnknownBankAccount("There is not such Bank Account");
			}
		}
		return -1;
	}
	 
	public void createTransaction(String senderIBAN, String receiverIBAN, double amount) throws UnknownBankAccount, AmountOutOfBouds {
		for(int i=0; i< bankAccounts.size();i++) {
			if(bankAccounts.get(i).getIBAN() == senderIBAN) {
				for(int j=0; j< bankAccounts.size();j++) {
					if(bankAccounts.get(i).getIBAN() == receiverIBAN) {
							bankAccounts.get(i).takeAmount(amount);
							bankAccounts.get(j).addAmount(amount);
						break;
					}else if(i == bankAccounts.size()-1) {
						throw new UnknownBankAccount("There is not such Bank Account");
					}
				}
				break;
			}else if(i == bankAccounts.size()-1) {
				throw new UnknownBankAccount("There is not such Bank Account");
			}
		}
	}
	
	public ArrayList getBankAccounts(int userId){
		ArrayList<BankAccount> temp = new ArrayList<BankAccount>();
		for(int i=0; i< bankAccounts.size();i++) {
			if(bankAccounts.get(i).getUserId() == userId) {
				temp.add(bankAccounts.get(i));
			}
		}
		return temp;
	} 
	
	public void setCreditLimit(String IBAN, double amount) throws UnknownBankAccount {
		
		for(int i=0; i< bankAccounts.size();i++) {
			if(bankAccounts.get(i).getIBAN() == IBAN) {
				if(bankAccounts.get(i) instanceof CreditBankAccount) {
					bankAccounts.set(i, new CreditBankAccount(IBAN, bankAccounts.get(i).getAmount(), bankAccounts.get(i).getUserId(), amount));
				}else {
					throw new UnknownBankAccount("The Bank Account is not a Credit Bank Account");
				}
				break;
			}else if(i == bankAccounts.size()-1) {
				throw new UnknownBankAccount("There is not such Bank Account");
			}
		}
		
	}
	
}
