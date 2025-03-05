package Service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import Dao.ITransactionBalanceDao;
import Dao.ITransactionCreationDao;
import Dao.ITransactionQueryDao;
import Model.Transaction;

public class TransactionService {
	ITransactionCreationDao transactionDao;
	ITransactionBalanceDao transactionBalanceDao;
	ITransactionQueryDao transactionQueryDao;
	 
	public TransactionService(ITransactionCreationDao transactionDao, ITransactionBalanceDao transactionBalanceDao, ITransactionQueryDao transactionQueryDao){
		this.transactionDao = transactionDao;
		this.transactionBalanceDao = transactionBalanceDao;
		this.transactionQueryDao = transactionQueryDao;
	}
	
	public Double calculateBalance(int AccountId) {
		return transactionBalanceDao.calculateBalance(AccountId);
	}
	
	public void save(Transaction transaction) {
		transactionDao.save(transaction);
	}
	
	public List<Transaction> getTransactionsByAccountId(int accountId){
		return transactionQueryDao.getTransactionsByAccountId(accountId);
	}

}
