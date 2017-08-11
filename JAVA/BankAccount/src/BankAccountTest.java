
public class BankAccountTest {
	public static void main(String[] args){
		BankAccount b = new BankAccount();
		System.out.println(b.AccountNumber);
		b.depositMoney("Checking", 100);
		b.depositMoney("checking", 10);
		System.out.println(b.getCheckingBalance());
		System.out.println(b.getTotalAmountofMoney());
		b.depositMoney("Saving", 100);
		b.depositMoney("saving", 10);
		System.out.println(b.getSavingsBalance());
		System.out.println(b.accountBalance());
		System.out.println(b.getTotalAmountofMoney());
		
	}
}
