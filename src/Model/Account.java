package Model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String accountType;
	private long cardNumber;
	private int pinNumber;
	private double balance;
	private SecureRandom random;
	private int customerId;
	private int accountId;
	private List<Transaction> transactions;
	
	
	
	public Account() {

		random = new SecureRandom();
		
		this.cardNumber = generateCardNumber();
		this.pinNumber = generatePinNumber();
		this.balance = 0.0;
		transactions = new ArrayList<>();
		
	}
	
	private long generateCardNumber() {
		
		long last12Digits = (long)random.nextLong() % 1000000000000L;
		last12Digits = Math.abs(last12Digits);
		return 4536000000000000L + last12Digits;
	}
	
	private int generatePinNumber() {
		return 1000 + Math.abs(random.nextInt(9000));
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public long getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getPinNumber() {
		return pinNumber;
	}
	
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;	
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	 public void setAccountId(int accountId) {
		 this.accountId = accountId;
	 }
	 public int getAccountId() {
		 return accountId;
	 }
	 
	 public void addTransaction(Transaction transaction) {
		 transactions.add(transaction);
	 }
	 
	 public List<Transaction> getTransactions(){
		 return transactions;
	 }
	

}
