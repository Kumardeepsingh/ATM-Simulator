package Dao;

import java.util.List;

import Model.Transaction;

public interface ITransactionQueryDao {
	public List<Transaction> getTransactionsByAccountId(int accountId);
}
