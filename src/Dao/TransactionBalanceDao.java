package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Transaction;

public class TransactionBalanceDao implements ITransactionBalanceDao {
	Connection connection;
	DatabaseConnection databaseConnection;
	
	public TransactionBalanceDao(DatabaseConnection databaseConnection){
		
		this.databaseConnection = databaseConnection;
		this.connection = databaseConnection.getConnection();
	}

	
	
	public Double calculateBalance(int AccountId) {
		double balance = 0;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * From Transaction WHERE account_id = " + AccountId);
			
			while(rs.next()) {
			if(rs.getString("transaction_type").equals("Deposit")) {
				balance += rs.getDouble("amount");
			}
			else {
				balance -= rs.getDouble("amount");
			}
			}
			
		}
		catch(Exception e1){
			System.out.println(e1);
		}
		return balance;
	}
		
	}




