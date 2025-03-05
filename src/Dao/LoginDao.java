package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao implements ILoginDao {

	private DatabaseConnection databaseConnection;
	private Connection connection;
	
	public LoginDao(DatabaseConnection databaseConnection){
		this.databaseConnection = databaseConnection;
		this.connection = databaseConnection.getConnection();
	}
	
	
	@Override
	public boolean login(long cardNumber, int pin) {
		boolean login = false;
		try {
			String query2 ="SELECT * FROM Account WHERE card_number = ? and pin_number = ?";
			PreparedStatement stmt = connection.prepareStatement(query2);
			stmt.setLong(1, cardNumber);
			stmt.setInt(2, pin);
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()){
			}
			else {
				login = true;
			}
		}
			
			catch(Exception e1){
				System.out.println(e1);
			}
		return login;
	
	}
}
