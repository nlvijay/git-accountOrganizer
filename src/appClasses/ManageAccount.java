package appClasses;

import java.util.LinkedList;
import java.util.List;

public class ManageAccount {

	private List <InfoAccounts> listOfAccountTransactions = new LinkedList <InfoAccounts> ( ); 
	private ReadAndWrite rw = new ReadAndWrite ( );
	
	public ManageAccount ( InfoAccounts acc  ) {
		this.listOfAccountTransactions.add ( acc );
		rw.writeHeaderAndBalance ( acc );
		
	}
	
	public List<InfoAccounts> getListOfAccountTransactions() {
		return listOfAccountTransactions;
	}

	public void setListOfAccountTransactions(
			List<InfoAccounts> listOfAccountTransactions) {
		this.listOfAccountTransactions = listOfAccountTransactions;
	}
	
	public void addNewTransaction ( InfoAccounts acct ) {
		Float previousBalance = this.listOfAccountTransactions.get ( this.listOfAccountTransactions.size ( ) - 1 ).getPresentBalance();
		Float balance;
		if ( acct.getTrans ( ).getTransType ( ).equals(TransactionType.Credit)) {
			balance = previousBalance + acct.getTrans ( ).getTransactionValue ( );
		}
		else {
			balance = previousBalance - acct.getTrans ( ).getTransactionValue ( );			
		}
		acct.setPresentBalance ( balance );
		this.listOfAccountTransactions.add ( acct );
		// ReadAndWrite rw = new ReadAndWrite ( );
		// rw.writeHeaderAndBalance ( manageAcc, idAcc, presentBalance );
		
	}

	public void printOn ( ) {
		System.out.println ( "Start Printing...");		
		System.out.println ( listOfAccountTransactions.get(0).getPresentBalance ( ) );
		for ( int i = 0; i < listOfAccountTransactions.size ( ); i++ ) {
			if ( i > 0 ) {
				 System.out.println ( listOfAccountTransactions.get(i).getTrans().getTransactionDate() +
			 			 "--" + listOfAccountTransactions.get(i).getTrans ( ).getTransType() +
			 			 "--" + listOfAccountTransactions.get(i).getTrans ( ).getTransNature ( ) +
			 			 "--" + listOfAccountTransactions.get(i).getTrans ( ).getTransactionDescription() +
			 			 "--" + listOfAccountTransactions.get(i).getTrans ( ).getTransactionValue ( ) +
			 			 "--" + listOfAccountTransactions.get(i).getPresentBalance ( )
			           );
				 System.out.println ( "+++++++++++++++++++++++++" );

			}
		}
	}

}
