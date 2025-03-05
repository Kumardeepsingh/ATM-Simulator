package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Account;
import Model.Customer;

public class AccountDao implements IAccountCreationDao, IAccountBalanceDao, IAccountQueryDao, IAccountPinDao {
	DatabaseConnection databaseConnection;
	Connection connection;
	
	int accountId;
	
	public AccountDao(DatabaseConnection databaseConnection){
		this.databaseConnection = databaseConnection;
		this.connection = databaseConnection.getConnection();
	}
	
	@Override
	public void save(Account account) {
		try {
			String query1 = "insert into Account values(default,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(query1);
			stmt.setString(1, account.getAccountType());
			stmt.setLong(2, account.getCardNumber());
			stmt.setInt(3, account.getPinNumber());
			stmt.setDouble(4, account.getBalance());
			stmt.setInt(5, account.getCustomerId());
			
			
			stmt.executeUpdate();
		}
		
		catch(Exception e1){
			System.out.println(e1);
		}
	}
	
	@Override
	public int getAccountIDByCustomerID(Account account) {
		
		try {
			String query = "SELECT account_id FROM Account WHERE customer_id = ?";
		
		ResultSet resultSet;
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, account.getCustomerId());
		resultSet = statement.executeQuery();
		resultSet.next();
		accountId = resultSet.getInt("account_id");
		
		}
		catch(Exception e1){
			System.out.println(e1);
		}
		return accountId;
		
	}
	@Override
	public void updateBalance(Account account) {
		try {
			String query = "UPDATE Account SET balance = ? WHERE account_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setDouble(1, account.getBalance());
			statement.setInt(2, account.getAccountId());
			statement.executeUpdate();
			
			
			}
			catch(Exception e1){
				System.out.println(e1);
			}
			
			
		}
	
	
	 
	 public Account getAccountByCardNumber(Account account, long cardNumber) {
	        

	        try {
	            String query = "SELECT * FROM Account WHERE card_number = ?";
	            PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setLong(1, cardNumber);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                account.setAccountId(rs.getInt("account_id"));
	                account.setCardNumber(rs.getLong("card_number"));
	                account.setBalance(rs.getDouble("balance"));
	                account.setPinNumber(rs.getInt("pin_number"));
	                account.setCustomerId(rs.getInt("customer_id"));
	                account.setAccountType(rs.getString("account_type"));
	            }
	   	 } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return account; 
	    }

	@Override
	public void changePinNumber(Account account) {
		try {
			String query = "UPDATE Account SET pin_number = ? WHERE account_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setDouble(1, account.getPinNumber());
			statement.setInt(2, account.getAccountId());
			statement.executeUpdate();
			
			
			}
			catch(Exception e1){
				System.out.println(e1);
			}
			
			
		}
		
	
}
	


