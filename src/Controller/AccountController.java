package Controller;


import java.util.*;

import Model.*;
import Service.*;


public class AccountController {
	
	private AccountService accountService;
	private PinChangeService pinChangeService;
	private TransactionService transactionService;
    private Account account;

    public AccountController(AccountService accountService, PinChangeService pinChangeService, TransactionService transactionService) {
        this.accountService = accountService;
        this.pinChangeService = pinChangeService;
        this.transactionService = transactionService;
        this.account = new Account();
    }
    
    public void  loadAllTransactions() {
    	List<Transaction> transactions = transactionService.getTransactionsByAccountId(account.getAccountId());
    	for(Transaction transaction:transactions ) {
    		account.addTransaction(transaction);
    	}
    }
    
    public List<Transaction> getTransactions() {
        return account.getTransactions();
    }
	
	public void setAccountType(String accountType) {
		account.setAccountType(accountType);
	}
	
	public void createAccount() {
		accountService.createAccount(account);
		
	}
	
	public long getCardnumber() {
		return account.getCardNumber();
	}
	
	public int getPinNumber() {
		return account.getPinNumber();
	}
	
	public void setPinNumber(int pinNumber){
		account.setPinNumber(pinNumber);
	}
	
	public void setAccountID() {
		account.setAccountId(accountService.getAccountIDByCustomerID(account));
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setBalance(Double balance) {
		account.setBalance(balance);
	}
	
	public double getBalance() {
		return account.getBalance();
	}
	
	public int getAccountId() {
		return account.getAccountId();
	}
	public void updateBalance() {
		accountService.updateBalance(account);
	}
	
	public void setCustomerId(int customerId) {
		account.setCustomerId(customerId);
	}
	
	public void setAccountFromCardNumber(Long cardNumber) {
		account = accountService.getAccountByCardNumber(account,cardNumber);
	}
	
	public void changePinNumber() {
		pinChangeService.changePinNumber(account);
	}
	 

}
