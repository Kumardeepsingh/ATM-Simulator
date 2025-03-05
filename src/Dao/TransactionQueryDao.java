package Dao;

import java.sql.Connection;
import java.sql.*;
import java.util.*;


import Model.Transaction;

public class TransactionQueryDao implements ITransactionQueryDao {
	
	Connection connection;
	DatabaseConnection databaseConnection;
	
	public TransactionQueryDao(DatabaseConnection databaseConnection){
		
		this.databaseConnection = databaseConnection;
		this.connection = databaseConnection.getConnection();
	}

	@Override
	public List<Transaction> getTransactionsByAccountId(int accountId) {
		List<Transaction> transactions = new ArrayList<>();
		try {
			String query = "SELECT * FROM Transaction WHERE account_id = ?";
			PreparedStatement Statement = connection.prepareStatement(query);
			Statement.setInt(1, accountId);
			ResultSet rs = Statement.executeQuery();
			
			while(rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setAccountId(rs.getInt("account_id"));
				transaction.setDate(rs.getDate("transaction_date"));
				transactions.add(transaction);
			}
		
		}
		catch(Exception e) {
            e.printStackTrace();
		}
		return transactions;
	}

}
