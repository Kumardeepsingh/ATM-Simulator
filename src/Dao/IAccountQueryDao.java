package Dao;

import Model.Account;

public interface IAccountQueryDao {
	 public Account getAccountByCardNumber(Account account, long cardNumber);
	 public int getAccountIDByCustomerID(Account account);
	 

}
