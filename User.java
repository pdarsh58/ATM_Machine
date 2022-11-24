
import java.security.MessageDigest;
import java.util.ArrayList;

public class User {


	private String first_name;
	
	private String last_name;

	private String user_id;
	

	private byte pinHash[];

	private ArrayList<Account> accounts;
	
	
	// Create New user

	public User (String first_name, String last_name, String pin, Bank _Bank) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (Exception e) {
			System.err.println("error, caught exeption : " + e.getMessage());
			System.exit(1);
		}

		this.user_id = _Bank.getNewUserUUID();

		this.accounts = new ArrayList<Account>();
		
		System.out.printf("%s%s is Account Holder\n\n  User ID: %s\n      PIN: 1111", 
				first_name, last_name, this.user_id);
		
	}
	

	public String getUUID() {
		return this.user_id;
	}
	

	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	

	public int numAccounts() {
		return this.accounts.size();
	}
	

	public double getAcctBalance(int acctIdx) {
		return this.accounts.get(acctIdx).getBalance();
	}
	

	public String getAcctUUID(int acctIdx) {
		return this.accounts.get(acctIdx).getUUID();
	}
	

	public void printAcctTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();
	}
	

	public void addAcctTransaction(int acctIdx, double amount, String memo) {
		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}

	public boolean validatePin(String aPin) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), 
					this.pinHash);
		} catch (Exception e) {
			System.err.println("error, caught exeption : " + e.getMessage());
			System.exit(1);
		}
		
		return false;
	}

	public void printAccountsSummary() {
		
		System.out.printf("\n\n%s's accounts summary\n\n", this.first_name);
		for (int a = 0; a < this.accounts.size(); a++) {
			System.out.printf("%d) %s\n", a+1, 
					this.accounts.get(a).getSummaryLine());
		}
		System.out.println();
		
	}
}