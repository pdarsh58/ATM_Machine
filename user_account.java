

import java.util.*;

public class user_account {
	
	private String bank_name;
	
	private String user_id;
	
	private User acc_holder;
	

	private ArrayList<transcation> transcations;
	
	
	// Create new Account instance
	public user_account(String bank_name, User acc_holder, mybank theBank) {
		
		this.bank_name = bank_name;
		this.acc_holder = acc_holder;
		
		this.user_id = theBank.getNewAccountUUID();
		
		this.transcations = new ArrayList<transcation>();
		
	}

	public String getUUID() {
		return this.user_id;
	}
	

	public void addTransaction(double amount) {
		
		// create new transaction and add it to our list
		transcation newTrans = new transcation(amount, this);
		this.transcations.add(newTrans);
		
	}
	
	public void addTransaction(double amount, String memo) {
		
		// create new transaction and add it to our list
		transcation newTrans = new transcation(amount, memo, this);
		this.transcations.add(newTrans);
		
	}
	
	public double getBalance() {
		
		double balance = 0;
		for (transcation t : this.transcations) {
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
		for (int t = this.transcations.size()-1; t >= 0; t--) {
			System.out.println(this.transcations.get(t).getSummaryLine());
		}
		System.out.println();
		
	}

}
