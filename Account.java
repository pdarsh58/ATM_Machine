
import java.util.*;

public class Account {
	
	private String bank_name;
	
	private String user_id;
	
	private User acc_holder;
	

	private ArrayList<Transaction> transactions;
	
	
	// Create new Account instance
	public Account(String bank_name, User acc_holder, Bank _Bank) {
		
		this.bank_name = bank_name;
		this.acc_holder = acc_holder;
		
		this.user_id = _Bank.getNewAccountUUID();
		
		this.transactions = new ArrayList<Transaction>();
		
	}

	public String getUUID() {
		return this.user_id;
	}
	

	public void addTransaction(double amount) {
		
		// create new transaction and add it to our list
		Transaction newTrans = new Transaction(amount, this);
		this.transactions.add(newTrans);
		
	}
	
	public void addTransaction(double amount, String memo) {
		
		// create new transaction and add it to our list
		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
		
	}
	
	public double getBalance() {
		
		double balance = 0;
		for (Transaction t : this.transactions) {
			balance += t.getAmount();
		}
		return balance;
		
	}

	public String getSummaryLine() {
		
		double balance = this.getBalance();
		
		if (balance >= 0) {
			return String.format("%s   %s   $%.02f ", this.bank_name, this.user_id, balance);
		} else {
			return String.format("%s %s   $(%.02f) ", this.bank_name, this.user_id, balance);
		}
		
	}

	public void printTransHistory() {
		
		System.out.printf("\nTransaction history for account %s\n", this.user_id);
		for (int t = this.transactions.size()-1; t >= 0; t--) {
			System.out.println(this.transactions.get(t).getSummaryLine());
		}
		System.out.println();
		
	}

}