
import java.util.*;

public class Atm_machine {
	

	public static void main(String[] args) {
		
	
		Scanner scans = new Scanner(System.in);
		

		mybank theBank = new mybank("Bank of United States");
		
	
		User aUser = theBank.addUser("BOB", "", "1111");
		
	
		user_account new_account = new user_account("Checking", aUser, theBank);
		aUser.addAccount(new_account);
		theBank.addAccount(new_account);
		
		User curUser;
		
		
		while (true) {
	
			curUser = Atm_machine.mainMenu(theBank, scans);
			
			Atm_machine.userOptions(curUser, scans);
			
		}

	}
	

	
	// Print the ATM's login menu.
	
	public static User mainMenu(mybank theBank, Scanner scans) {
		
		String userID;
		String pin;
		User authUser;
		
		do {
			
			System.out.printf("\n\n****** Welcome to %s ******\n\n", theBank.getName());		
			System.out.print("Enter User ID: ");
			userID = scans.nextLine();
			System.out.print("Enter PIN: ");
			pin = scans.nextLine();
			
			
			authUser = theBank.userLogin(userID, pin);
			if (authUser == null) {
				System.out.println("Incorrect user ID/pin combination. " + 
						"Please try again");
			}
			
		} while(authUser == null); 	
		
		return authUser;
		
	}
	
	
	// Print the ATM's menu for user actions.
	
	public static void userOptions(User your_user, Scanner scans) {
		

		your_user.printAccountsSummary();

		int choice;		

		do {
			
			System.out.println("Your Options are:");
			System.out.println("\t1) Deposit Money");
			System.out.println("\t2) Withdraw Money");
			System.out.println("\t3) Transfer money");
			System.out.println("\t4) Show Transcation history");
			System.out.println("\t5) Quit");
			System.out.println();
			System.out.print("Enter choice: ");
			choice = scans.nextInt();
			
			if (choice < 1 || choice > 5) {
				System.out.println("Invalid choice. Please choose 1-5.");
			}
			
		} while (choice < 1 || choice > 5);
		

		switch (choice) {
		
		case 1:
			Atm_machine.depositFunds(your_user, scans);
			break;
		case 2:
			Atm_machine.withdrawFunds(your_user, scans);
			break;
		case 3:
			Atm_machine.transferFunds(your_user, scans);
			break;
		case 4:
			Atm_machine.showTransHistory(your_user, scans);
			break;
		case 5:
			scans.nextLine();
			break;
		}
		
		if (choice != 5) {
			Atm_machine.userOptions(your_user, scans);
		}
		
	}
	
	
	// Process transferring funds from one account to another.
	
	public static void transferFunds(User your_user, Scanner scans) {
		
		int fromAcct;
		int toAcct;
		double amount;
		double acctBal;
		

		do {
			System.out.printf("\nEnter type of Account(Savings or Checking)(1-%d) to " + 
					"transfer from: ", your_user.numAccounts());
			fromAcct = scans.nextInt()-1;
			if (fromAcct < 0 || fromAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (fromAcct < 0 || fromAcct >= your_user.numAccounts());
		acctBal = your_user.getAcctBalance(fromAcct);
		

		do {
			System.out.printf("\nEnter type of Account(Savings or Checking)(1-%d) to " + 
					"transfer to: ", your_user.numAccounts());
			toAcct = scans.nextInt()-1;
			if (toAcct < 0 || toAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (toAcct < 0 || toAcct >= your_user.numAccounts());
		

		do {
			System.out.printf("\nEnter the amount to transfer (max $%.02f): $", 
					acctBal);
			amount = scans.nextDouble();
			if (amount < 0) {
				System.out.println("Amount must be greater than zero.");
			} else if (amount > acctBal) {
				System.out.printf("Amount must not be greater than balance " +
						"of $.02f.\n", acctBal);
			}
		} while (amount < 0 || amount > acctBal);
		

		your_user.addAcctTransaction(fromAcct, -1*amount, String.format(
				"Transfer to account %s", your_user.getAcctUUID(toAcct)));
		your_user.addAcctTransaction(toAcct, amount, String.format(
				"Transfer from account %s", your_user.getAcctUUID(fromAcct)));
		
	}
	
	
	// Process a fund withdraw from an account.

	public static void withdrawFunds(User your_user, Scanner scans) {
		
		int fromAcct;
		double amount;
		double acctBal;
		String memo;
		

		do {
			System.out.printf("\nEnter type of Account(Savings or Checking)(1-%d) to " + 
					"withdraw from: ", your_user.numAccounts());
			fromAcct = scans.nextInt()-1;
			if (fromAcct < 0 || fromAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (fromAcct < 0 || fromAcct >= your_user.numAccounts());
		acctBal = your_user.getAcctBalance(fromAcct);
		

		do {
			System.out.printf("\nEnter the amount to withdraw (max $%.02f): $", 
					acctBal);
			amount = scans.nextDouble();
			if (amount < 0) {
				System.out.println("Amount must be greater than zero.");
			} else if (amount > acctBal) {
				System.out.printf("Amount must not be greater than balance " +
						"of $%.02f.\n", acctBal);
			}
		} while (amount < 0 || amount > acctBal);
		

		scans.nextLine();
		

		System.out.print("Enter a memo: ");
		memo = scans.nextLine();
		
		your_user.addAcctTransaction(fromAcct, -1*amount, memo);
		
	}
	

	// Process a fund deposit to an account.

	public static void depositFunds(User your_user, Scanner scans) {
		
		int toAcct;
		double amount;
		String memo;
		
		do {
			System.out.printf("\nEnter type of Account(Savings or Checking)(1-%d) to " + 
					"deposit to: ", your_user.numAccounts());
			toAcct = scans.nextInt()-1;
			if (toAcct < 0 || toAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (toAcct < 0 || toAcct >= your_user.numAccounts());
		

		do {
			System.out.printf("\nEnter the amount to deposit: $ ");
			amount = scans.nextDouble();
			if (amount < 0) {
				System.out.println("Amount must be greater than zero.");
			} 
		} while (amount < 0);
		

		scans.nextLine();

		System.out.print("Enter a memo: ");
		memo = scans.nextLine();
		

		your_user.addAcctTransaction(toAcct, amount, memo);
		
	}
	

	// Show the transaction history for an account.

	public static void showTransHistory(User your_user, Scanner scans) {
		
		int theAcct;
		

		do {
			System.out.printf("\nEnter type of Account(Savings or Checking)(1-%d) \nwhose " + 
					"transactions you want to see: ", your_user.numAccounts());
			theAcct = scans.nextInt()-1;
			if (theAcct < 0 || theAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (theAcct < 0 || theAcct >= your_user.numAccounts());
		

		your_user.printAcctTransHistory(theAcct);
		
	}

}
