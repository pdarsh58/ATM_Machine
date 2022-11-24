import java.util.*;

public class ATM {
	

	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		

		Bank theBank = new Bank("Bank of United States");
		
	
		User aUser = theBank.addUser("BOB", "", "1111");
		
	
		Account new_account = new Account("Checking", aUser, theBank);
		aUser.addAccount(new_account);
		theBank.addAccount(new_account);
		
		User curUser;
		
		
		while (true) {
	
			curUser = ATM.mainMenu(theBank, sc);
			
			ATM.userOptions(curUser, sc);
			
		}

	}
	

	
	// Print the ATM's login menu.
	
	public static User mainMenu(Bank theBank, Scanner sc) {
		
		String userID;
		String pin;
		User authUser;
		
		do {
			
			System.out.printf("\n\n****** Welcome to %s ******\n\n", theBank.getName());		
			System.out.print("Enter User ID: ");
			userID = sc.nextLine();
			System.out.print("Enter PIN: ");
			pin = sc.nextLine();
			
			
			authUser = theBank.userLogin(userID, pin);
			if (authUser == null) {
				System.out.println("Incorrect user ID/pin combination. " + 
						"Please try again");
			}
			
		} while(authUser == null); 	
		
		return authUser;
		
	}
	
	
	// Print the ATM's menu for user actions.
	
	public static void userOptions(User your_user, Scanner sc) {
		

		your_user.printAccountsSummary();

		int choice;		

		do {
			
			System.out.println("Your Options are:");
			System.out.println("    1) Deposit Money");
			System.out.println("    2) Withdraw Money");
			System.out.println("    3) Transfer money");
			System.out.println("    4) Show Transcation history");
			System.out.println("    5) Quit");
			System.out.println();
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			
			if (choice < 1 || choice > 5) {
				System.out.println("Invalid choice. Please choose 1-5.");
			}
			
		} while (choice < 1 || choice > 5);
		

		switch (choice) {
		
		case 1:
			ATM.depositFunds(your_user, sc);
			break;
		case 2:
			ATM.withdrawFunds(your_user, sc);
			break;
		case 3:
			ATM.transferFunds(your_user, sc);
			break;
		case 4:
			ATM.showTransHistory(your_user, sc);
			break;
		case 5:
			sc.nextLine();
			break;
		}
		
		if (choice != 5) {
			ATM.userOptions(your_user, sc);
		}
		
	}
	
	
	// Process transferring funds from one account to another.
	
	public static void transferFunds(User your_user, Scanner sc) {
		
		int fromAcct;
		int toAcct;
		double amount;
		double acctBal;
		

		do {
			System.out.printf("Enter type of Account(Savings or Checking)(1-%d) to " + 
					"transfer from: ", your_user.numAccounts());
			fromAcct = sc.nextInt()-1;
			if (fromAcct < 0 || fromAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (fromAcct < 0 || fromAcct >= your_user.numAccounts());
		acctBal = your_user.getAcctBalance(fromAcct);
		

		do {
			System.out.printf("Enter type of Account(Savings or Checking)(1-%d) to " + 
					"transfer to: ", your_user.numAccounts());
			toAcct = sc.nextInt()-1;
			if (toAcct < 0 || toAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (toAcct < 0 || toAcct >= your_user.numAccounts());
		

		do {
			System.out.printf("Enter the amount to transfer (max $%.02f): $", 
					acctBal);
			amount = sc.nextDouble();
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

	public static void withdrawFunds(User your_user, Scanner sc) {
		
		int fromAcct;
		double amount;
		double acctBal;
		String memo;
		

		do {
			System.out.printf("Enter type of Account(Savings or Checking)(1-%d) to " + 
					"withdraw from: ", your_user.numAccounts());
			fromAcct = sc.nextInt()-1;
			if (fromAcct < 0 || fromAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (fromAcct < 0 || fromAcct >= your_user.numAccounts());
		acctBal = your_user.getAcctBalance(fromAcct);
		

		do {
			System.out.printf("Enter the amount to withdraw (max $%.02f): $", 
					acctBal);
			amount = sc.nextDouble();
			if (amount < 0) {
				System.out.println("Amount must be greater than zero.");
			} else if (amount > acctBal) {
				System.out.printf("Amount must not be greater than balance " +
						"of $%.02f.\n", acctBal);
			}
		} while (amount < 0 || amount > acctBal);
		

		sc.nextLine();
		

		System.out.print("Enter a memo: ");
		memo = sc.nextLine();
		
		your_user.addAcctTransaction(fromAcct, -1*amount, memo);
		
	}
	

	// Process a fund deposit to an account.

	public static void depositFunds(User your_user, Scanner sc) {
		
		int toAcct;
		double amount;
		String memo;
		
		do {
			System.out.printf("Enter type of Account(Savings or Checking)(1-%d) to " + 
					"deposit to: ", your_user.numAccounts());
			toAcct = sc.nextInt()-1;
			if (toAcct < 0 || toAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (toAcct < 0 || toAcct >= your_user.numAccounts());
		

		do {
			System.out.printf("Enter the amount to deposit: $ ");
			amount = sc.nextDouble();
			if (amount < 0) {
				System.out.println("Amount must be greater than zero.");
			} 
		} while (amount < 0);
		

		sc.nextLine();

		System.out.print("Enter a memo: ");
		memo = sc.nextLine();
		

		your_user.addAcctTransaction(toAcct, amount, memo);
		
	}
	

	// Show the transaction history for an account.

	public static void showTransHistory(User your_user, Scanner sc) {
		
		int theAcct;
		

		do {
			System.out.printf("Enter type of Account(Savings or Checking)(1-%d) \nwhose " + 
					"transactions you want to see: ", your_user.numAccounts());
			theAcct = sc.nextInt()-1;
			if (theAcct < 0 || theAcct >= your_user.numAccounts()) {
				System.out.println("Invalid account. Please try again.");
			}
		} while (theAcct < 0 || theAcct >= your_user.numAccounts());
		

		your_user.printAcctTransHistory(theAcct);
		
	}

}