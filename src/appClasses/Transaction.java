package appClasses;

import java.util.Date;

public class Transaction {
	
	private Date transactionDate; // Date on which the transaction took place
	private TransactionType transType; // Refers to an expense (Debit) or to a deposit (Credit)
	private TransactionNature transNature; // Indicates type of expense (bar, supermarket, etc.) or a type of deposit (per diem, fellowship, etc.)
	private String transactionDescription; // Text with more details of the expense or deposit
	private Float transactionValue; // Refers to the value of the transaction
	
	public Transaction ( Date tDate, TransactionType tType, TransactionNature tNature, String tDescription, Float tValue ) {
		this.transactionDate = tDate;
		this.transType = tType;
		this.transNature = tNature;
		this.transactionDescription = tDescription;
		this.transactionValue = tValue;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionType getTransType() {
		return transType;
	}

	public void setTransType(TransactionType transType) {
		this.transType = transType;
	}

	public TransactionNature getTransNature() {
		return transNature;
	}

	public void setTransNature(TransactionNature transNature) {
		this.transNature = transNature;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public Float getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(Float transactionValue) {
		this.transactionValue = transactionValue;
	}
}
