package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Customer;
import Model.Transaction;

public class TransactionDao implements ITransactionCreationDao {
	
	Connection connection;
	DatabaseConnection databaseConnection;
	
	public TransactionDao(DatabaseConnection databaseConnection){
		
		this.databaseConnection = databaseConnection;
		this.connection = databaseConnection.getConnection();
	}

	@Override
	public void save(Transaction transaction) {
		try {
			String query1 = "insert into Transaction values(default,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(query1);
			stmt.setString(1, transaction.getTransactionType());
			stmt.setDouble(2, transaction.getAmount());
			stmt.setDate(3, transaction.getDate());
			stmt.setInt(4, transaction.getAccountId());
			stmt.executeUpdate();
		}
		catch(Exception e1){
			System.out.println(e1);
		}
	}
	
	
		
	}


