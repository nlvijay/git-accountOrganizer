package appClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AccountSelectionInterface {
	
	public AccountSelectionInterface ( ) {
		
	}
	
	public String getCurrentAccOrCreditAcc ( ) {
		String currOrCred = null;
		String [ ] accountOptions = { "Current Account", "Credit Account" };
		currOrCred = (String) JOptionPane.showInputDialog ( null,
				 											"Select Current or Credit",
				 											"Option for Current or Credit",
				 											JOptionPane.QUESTION_MESSAGE,
				 											null,
				 											accountOptions,
				 											accountOptions [ 0 ]
														  );
		return currOrCred;
	}
	
	public String getAccount ( String [ ] sAccts ) {
		String accId = null;
		accId = ( String ) JOptionPane.showInputDialog ( null,
														 "Select an Account",
														 "List of Available Accounts",
														 JOptionPane.QUESTION_MESSAGE,
														 null,
														 sAccts,
														 sAccts [ 0 ]
													   );
		return accId;		
	}
	
	public String getDateOfTransaction ( ) {
		Calendar cal = Calendar.getInstance ( );
		
		int year = cal.get ( Calendar.YEAR );
		int month = cal.get ( Calendar.MONTH) + 1;
		//
		String dateOfTransaction = JOptionPane.showInputDialog ( null, "Date (dd) of Transaction: " );
		String mm = null;
		if ( month < 10 ) {
			mm = "0" + month;
		}
		dateOfTransaction = year + "-" + mm + "-" + dateOfTransaction;
		return dateOfTransaction;
	}
	
	public String isTransactionCreditOrDebit ( ) {
		String [ ] optionCreditOrDebit = { "Credit", "Debit" };
		String crOrDb = null;
		// String creditOrDebit = JOptionPane.showInputDialog (null, "Is the Transaction Credit or Debit: " );
		crOrDb = ( String ) JOptionPane.showInputDialog ( null,
														  "Select an Option",
														  "Credit Transaction or Debit Transaction",
														  JOptionPane.QUESTION_MESSAGE,
														  null,
														  optionCreditOrDebit,
														  optionCreditOrDebit [ 1 ]
														);
		return crOrDb;
	}
	
	public String getNatureOfTransaction ( ) throws FileNotFoundException {
		List <String> optionsForNatureOfTransaction = new ArrayList <String> ( );
		String natureOfTransaction = null;
		
		// Get the Initial List of Nature of Transactions from a File
		ReadAndWrite readNature = new ReadAndWrite ( );
		readNature.readNatureOfTransactions ( optionsForNatureOfTransaction );
		
		JComboBox jcb = new JComboBox ( optionsForNatureOfTransaction.toArray ( ) );
		jcb.setEditable ( true );
		JOptionPane.showMessageDialog ( null, jcb, "Select Nature of Transaction or Edit", JOptionPane.QUESTION_MESSAGE );
		natureOfTransaction = ( String ) jcb.getSelectedItem ( );
		// Check whether the selected option is in the ArrayList
		// readNature.verifyAndIncludeNewNature ( natureOfTransactions, optionsForNatureOfTransaction );
		
		return natureOfTransaction;
	}

}
