# ATM_Machine

Program works at a small scale by creating a Account Holder with name Bob and its login information. Program will give you User ID and PIN. Then, you can use that and choose from this menu options:

1) Deposit
2) Withdraw
3) Transfer
4) Transcation history
5) Exit

Here is sample run of the Program

*******************************************************************************

BOB is Account Holder

Login Information:

	User ID: 52561
  
        PIN: 1111
	

******************** Welcome to Bank of United States ********************




Enter User ID: 52561

    Enter PIN: 1111



BOB's accounts summary

1) Savings =>          #5605045 =>          $0.00 

2) Checking  =>       #3335042 =>         $0.00 

Your Options are:

	1) Deposit Money
	
	2) Withdraw Money
	
	3) Transfer money
	
	4) Show Transcation history
	
	5) Quit

		Enter choice: 1

		Enter type of Account(Savings or Checking)(1-2) to deposit to: 1

		Enter the amount to deposit: $ 1000

		Enter a memo: Bonus


BOB's accounts summary

	1) Savings  =>    5605045 =>    $1000.00 
	2) Checking  =>   3335042 =>    $0.00 
	

Your Options are:

	1) Deposit Money
	
	2) Withdraw Money
	
	3) Transfer money
	
	4) Show Transcation history
	
	5) Quit

		Enter choice: 1

		Enter type of Account(Savings or Checking)(1-2) to deposit to: 2

		Enter the amount to deposit: $ 100

		Enter a memo: Gift


BOB's accounts summary

	1) Savings =>	#5605045 =>	$1000.00 

	2) Checking =>	#3335042 =>	$100.00 

Your Options are:

	1) Deposit Money
	
	2) Withdraw Money
	
	3) Transfer money
	
	4) Show Transcation history
	
	5) Quit
	

		Enter choice: 2

		Enter type of Account(Savings or Checking)(1-2) to withdraw from: 1

		Enter the amount to withdraw (max $1000.00): $200

		Enter a memo: Grocery



BOB's accounts summary

	1) Savings =>   #5605045 =>  $800.00 
 
	2) Checking =>  #3335042 =>  $100.00 


Your Options are:

	1) Deposit Money
	
	2) Withdraw Money
	
	3) Transfer money
	
	4) Show Transcation history
	
	5) Quit




		Enter choice: 3

		Enter type of Account(Savings or Checking)(1-2) to transfer from: 1

		Enter type of Account(Savings or Checking)(1-2) to transfer to: 2

		Enter the amount to transfer (max $800.00): $500


BOB's accounts summary

	1) Savings =>  5605045 =>   $300.00 

	2) Checking =>  3335042 =>  $600.00 

Your Options are:

	1) Deposit Money
	
	2) Withdraw Money
	
	3) Transfer money
	
	4) Show Transcation history
	
	5) Quit
	
	
	

		Enter choice: 4

		Enter type of Account(Savings or Checking)(1-2) whose transactions you want to see: 1
	

Transaction history for account 5605045

	Wed Nov 23 21:30:36 EST 2022, $(500.00) : Transfer to account 3335042

	Wed Nov 23 21:30:26 EST 2022, $(200.00) : Grocery

	Wed Nov 23 21:29:39 EST 2022, $1000.00 : Bonus




BOB's accounts summary

	1) Savings =>  5605045 =>   $300.00 

	2) Checking =>  3335042 =>  $600.00 

Your Options are:


	1) Deposit Money

	2) Withdraw Money
	
	3) Transfer money
	
	4) Show Transcation history
	
	5) Quit



		Enter choice: 4

		Enter type of Account(Savings or Checking)(1-2)whose transactions you want to see: 2


Transaction history for account 3335042

	Wed Nov 23 21:30:36 EST 2022, $500.00 : Transfer from account 5605045

	Wed Nov 23 21:30:05 EST 2022, $100.00 : Gift





BOB's accounts summary

	1) Savings =>  5605045 =>   $300.00 

	2) Checking =>  3335042 =>   $600.00 


Your Options are:

	1) Deposit Money
	
	2) Withdraw Money
	
	3) Transfer money
	
	4) Show Transcation history
	
	5) Quit

Enter choice: 5


****************  Thank You for choosing Bank of America!! ****************
Program exit
