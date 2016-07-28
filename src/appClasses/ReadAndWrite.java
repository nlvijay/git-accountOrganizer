package appClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReadAndWrite {
	
	private
		String dirPath = null;
	
	public ReadAndWrite ( ) {
		dirPath = "/Users/vijay/OneDrive/Vijay/Eclipse_Projects/OrganizeCurrentAndCreditCardAccounts/auxdata";
	}
	public void writeHeaderAndBalance ( InfoAccounts acc ) {
		// String dirPath = "/Users/vijay/OneDrive/Vijay/Eclipse_Projects/OrganizeCurrentAndCreditCardAccounts/datum";
		File fw = new File ( dirPath + "/" + acc.getIdAccount ( ) );
		try {
			if ( !fw.exists ( ) ) {
				fw.createNewFile ( );
				BufferedWriter bw = new BufferedWriter ( new FileWriter ( fw ) );
				bw.newLine ( );
				bw.write ( "--- Current Account: " + acc.getIdAccount ( ) );
				bw.newLine ( );
				bw.write ( 
						"***Date*** |:|" + // Date
						"**Cr/Db**  |:|" + // Credit or Debit
						"******Nature****** |:|" + // Transaction Nature - Bar, Restaurant, Other
						"******Description****** |:|" + // Description
						"***Value*** |:|" + // Transaction Value
						acc.getPresentBalance().toString ( )
						);
				bw.close ( );
			}
			else {
				BufferedWriter bw = new BufferedWriter ( new FileWriter ( fw, true ) );
				bw.newLine ( );
				bw.write (
							"   " + acc.getTrans().getTransactionDate() +
							"|:|" + acc.getTrans ( ).getTransType() +
					 		"|:|" + acc.getTrans ( ).getTransNature ( ) +
					 		"|:|" + acc.getTrans ( ).getTransactionDescription() +
					 		"|:|" + acc.getTrans ( ).getTransactionValue ( ) +
					 		"|:|" + acc.getPresentBalance ( )
					           );
				bw.close ( );
			}
		}
		catch ( IOException ioe ) {
			ioe.printStackTrace ( );
		}
		
	}
	
	public void readNatureOfTransactions ( List s ) throws FileNotFoundException {
		File fr = new File ( dirPath + "/" + "NatureOfTransactions" );

		try {
			BufferedReader br = new BufferedReader ( new FileReader ( fr ) );
			String line = null;
			while (  ( line = br.readLine ( ) ) != null ) {
				System.out.println ( line );
				//s [ i ] = line;
				s.add ( line );
				//System.out.println ( s [ i ] );
				//System.out.println ( s.length );
			}
		}
		catch ( Exception e ) {
			System.out.println ( "*** File NatureOfTransactions Not Found *** "+  e );
			e.printStackTrace ( );
		}
	}

}
