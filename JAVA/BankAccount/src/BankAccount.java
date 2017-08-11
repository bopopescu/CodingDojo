import java.util.Random;

public class BankAccount {
	public String AccountNumber;
	public long CheckingBalance;
	public long SavingsBalance;
	
	private static int numberOfAccount = 0;
	private static long totalAmountOfMoney = 0;
	public BankAccount() {
		AccountNumber = RandomizeAccountNumber();
		numberOfAccount++;
	}
	
	public static int GetNumberofAccounts() {
		return numberOfAccount;
		
	}
	
	public static long getTotalAmountofMoney() {
		return totalAmountOfMoney;
	}
	
	private static String RandomizeAccountNumber() {
		String newstr = "";
		for(int i = 0; i < 10; i++) {
			int random = (int)(Math.random()*9+0);
			newstr = newstr.concat(String.valueOf(random));
		}
		return newstr;
		
	}
	
	//getter method for user's checking account balance:
	public long getCheckingBalance() {
		return this.CheckingBalance;
	}
	
	//getter method for user's saving account balance:
	public long getSavingsBalance() {
		return this.SavingsBalance;
	}
	
	//method that allows user to deposit money into either the checking or savings
	//add to total amount stored
	public void depositMoney(String accounttype, long money) {
		accounttype = accounttype.toLowerCase();
		if(accounttype.equals("checking")) {
			this.CheckingBalance += money;
			totalAmountOfMoney += money;
		}
		else if(accounttype.equals("saving")){
			this.SavingsBalance += money;
			totalAmountOfMoney += money;
		}
		else {
			System.out.println("Cannot identify the type");
		}
	}
	
	public double accountBalance() {
		double total = this.CheckingBalance + this.SavingsBalance;
		return total;
	}
	
	//method to withdraw money from one balance.
	//Do not allow them to withdraw money if there are insufficient fund
	public void withdrawMoney(String accounttype, long money) {
		accounttype = accounttype.toLowerCase();
		if(accounttype == "checking") {
			if(this.CheckingBalance > 0) {
				this.CheckingBalance -= money;
				totalAmountOfMoney -= money;
			}
		}
		else if(accounttype == "saving"){
			if(this.CheckingBalance > 0) {
				this.SavingsBalance -= money;
				totalAmountOfMoney -= money;
			}
		}
		else {
			System.out.println("Cannot identify the type");
		}		
	}
	
	
}
