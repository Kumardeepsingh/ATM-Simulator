package Controller;

import Dao.IAccountCreationDao;

import Model.Account;
import Model.Customer;
import Model.Transaction;
import Service.TransactionService;

public class TransactionController {
	
	private Transaction transaction;
	TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService){
		this.transactionService = transactionService;
		transaction = new Transaction();
	}
	
	public void setAccountId(int accountId) {
		transaction.setAccountId(accountId);
	}
	
	public void setTransactionType(String transactionType) {
		transaction.setTransactionType(transactionType);
	}
	
	public void setAmount(Double amount) {
		transaction.setAmount(amount);
	}
	
	public void createTransaction() {
		transactionService.save(transaction);
		
	}
	
	public Double calculateBalance(int accountId) {
		 return transactionService.calculateBalance(accountId);
		
	}

}
