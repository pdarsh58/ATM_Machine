
import java.util.*;

public class Bank {
	

	private String bank_name;
	

	private ArrayList<User> users;
	

	private ArrayList<Account> accounts;
	

	public Bank(String bank_name) {
		
		this.bank_name = bank_name;
		
		users = new ArrayList<User>();
		accounts = new ArrayList<Account>();
		
	}
	

	public String getNewUserUUID() {
		

		String user_id;
		Random rng = new Random();
		int len = 5;
		boolean nonUnique;
		

		do {
			
	
			user_id = "";
			for (int c = 0; c < len; c++) {
				user_id += ((Integer)rng.nextInt(10)).toString();
			}
			

			nonUnique = false;
			for (User u : this.users) {
				if (user_id.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return user_id;
	}
	

	public String getNewAccountUUID() {
		

		String user_id;
		Random rng = new Random();
		int len = 7;
		boolean nonUnique = false;
		

		do {
			

			user_id = "";
			for (int c = 0; c < len; c++) {
				user_id += ((Integer)rng.nextInt(7)).toString();
			}
			
	
			for (Account a : this.accounts) {
				if (user_id.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return user_id;
				
	}

	
	// Create a new user of the bank.

	public User addUser(String first_name, String last_name, String pin) {
		
		
		User newUser = new User(first_name, last_name, pin, this);
		this.users.add(newUser);
		
	
		Account new_account = new Account("Savings", newUser, this);
		newUser.addAccount(new_account);
		this.accounts.add(new_account);
		
		return newUser;
		
	}
	
	

	public void addAccount(Account new_account) {
		this.accounts.add(new_account);
	}
	


	public User userLogin(String userID, String pin) {
		
	
		for (User u : this.users) {
			
		
			if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
				return u;
			}
		}
		
	
		return null;
		
	}
	


	public String getName() {
		return this.bank_name;
	}

}