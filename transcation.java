


import java.util.*;

public class transcation {
	
	private double amount;
	

	private Date timeslot;

	private String memo;
	

	private user_account inAccount;
	
	
	public transcation(double amount, user_account inAccount) {
		
		this.amount = amount;
		this.inAccount = inAccount;
		this.timeslot = new Date();
		this.memo = "";
		
	}
	
	
	// Create a new transaction with a memo.

	public transcation(double amount, String memo, user_account inAccount) {
		
		this(amount, inAccount);
		
		this.memo = memo;
		
	}
	
	public double getAmount() {
		return this.amount;
	}
	

	public String getSummaryLine() {
		
		if (this.amount >= 0) {
			return String.format("%s, $%.02f : %s", 
					this.timeslot.toString(), this.amount, this.memo);
		} else {
			return String.format("%s, $(%.02f) : %s", 
					this.timeslot.toString(), -this.amount, this.memo);
		}
	}

}