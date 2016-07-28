package appClasses;

public class InfoAccounts {
	
	private String idAccount;
	private Transaction trans;
	private Float presentBalance;
		
	public InfoAccounts ( String id ) {
		this.idAccount = id;
		this.trans = null;
		this.presentBalance = 0.0F;
	}
	
	public InfoAccounts ( String id, Float balance ) {
		this.trans = null;
		this.idAccount = id;
		this.presentBalance = balance;
	}
	
	public InfoAccounts ( String id, Transaction t ) {
		this.idAccount = id;
		this.trans = t;
	}
	
	public String getIdAccount ( ) {
		return idAccount;
	}
	
	public String setIdAccount ( String idAcc ) {
		return this.idAccount = idAcc;
	}

	public Transaction getTrans() {
		return trans;
	}

	public void setTrans(Transaction trans) {
		this.trans = trans;
	}

	public Float getPresentBalance() {
		return presentBalance;
	}

	public void setPresentBalance(Float presentBalance) {
		this.presentBalance = presentBalance;
	}
	
}
