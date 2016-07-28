package appClasses;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main ( String [] args ) throws FileNotFoundException {
		String idAcc; // This Id identifies which account is being referred to, i.e. there may be more than 1 account of a certain type
					  // For example, there may more than 1 Current Account. Similarly more than 1 Credit Card Account
		String currOrCredit; // int to hold if the Account is Current (0) or Credit (1)
		String dateOfTransaction;
		String natureOfTransaction;
		Float presentBalance = (float) 0.0;
		
		ManageAccount manageAcc = null;
		
		File directory = new File ( "/Users/vijay/OneDrive/Vijay/Eclipse_Projects/OrganizeCurrentAndCreditCardAccounts/datum" );
		
		if ( directory.isDirectory ( ) ) {
			int numberOfFiles = directory.list ( ).length;
			if ( numberOfFiles > 0 ) { // Some Accounts already Created
				System.out.println ( "Directory is not Empty" );
				String [ ] accountOptions = new String [ numberOfFiles + 1 ];
				int i = 0;
				for ( String s:directory.list ( ) ) {
					if ( !s.startsWith(".") ) {
						accountOptions [ i ] = s;
						i++;						
					}
				}
				accountOptions [ i ] = "Create New Account";
				
				// Selecting Account or Opt for Creating a New Account
				AccountSelectionInterface accInterface = new AccountSelectionInterface ( );
				idAcc = accInterface.getAccount( accountOptions );
				
// ***************************** - Must check if Existing Account is selected or to Create a New Account - ***
				
				System.out.println ( "Account Selected: " + idAcc );
		
				// Input the Date of Transaction
				dateOfTransaction = accInterface.getDateOfTransaction ( );
				System.out.println ( "Date of Transsaction: " + dateOfTransaction );
				
				// Input whether the Transaction is of Credit (Deposit) or Debit
				String creditOrDebit = accInterface.isTransactionCreditOrDebit ( );
				System.out.println ( "Transaction is: " + creditOrDebit );
				
				// Input the Nature of Transaction
				natureOfTransaction = accInterface.getNatureOfTransaction ( );
				System.out.println ( "Nature of Transaction is: " + natureOfTransaction );
				System.exit(0);
/**				
				String creditOrDebit = JOptionPane.showInputDialog (null, "Is the Transaction Credit or Debit: " );
				String natureOfTransaction = JOptionPane.showInputDialog (null, "Nature of Transaction: " );
				String describeTransaction = JOptionPane.showInputDialog (null, "Describe Transaction: " );
				Float valueOfTransaction = Float.valueOf ( JOptionPane.showInputDialog (null, "Value of the Transaction: " ) );
					
				Transaction trans = new Transaction ( tDate, TransactionType.valueOf(creditOrDebit), TransactionNature.valueOf(natureOfTransaction),
							describeTransaction, valueOfTransaction );
				CurrentAccount currentAcc = new CurrentAccount ( idAcc, trans );
				manageAcc.addNewTransaction ( currentAcc );
				manageAcc.printOn ( );
**/
			}
			else { // No Accounts Created
				System.out.println ( "Directory is Empty" );
				// Get whether the Account is Current or Credit
				AccountSelectionInterface accInterface = new AccountSelectionInterface ( );
				currOrCredit = accInterface.getCurrentAccOrCreditAcc ( );
				System.out.println ( "Selected Type of Account is: " + currOrCredit );
				
				// So, this is in fact First Transaction
				// Get the Account Id in order to create a file with corresponding Account
				idAcc = JOptionPane.showInputDialog ( null, "Enter the Account Id: " );
				InfoAccounts account;
				if ( currOrCredit.equals("Current Account") ) { // This is Current Account					
					// Get the Initial Balance, if the Account is a Current Account
					presentBalance = Float.valueOf ( JOptionPane.showInputDialog (null, "Input the Initial Balance: " ) );
					account = new CurrentAccount ( idAcc, presentBalance );
				}
				else { // This is Credit Account
					account = new CreditAccount ( idAcc );
				}				
				manageAcc = new ManageAccount ( account );
				manageAcc.printOn ( );													
			}			
		}
	}
}

