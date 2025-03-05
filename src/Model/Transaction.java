package Model;

import java.sql.Date;

public class Transaction {
	
	private String transactionType;
	private Double amount;
	private Date date;
	private int accountId;
	
	
	public Transaction(){
		date = new Date(new java.util.Date().getTime());
	    
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	

}
