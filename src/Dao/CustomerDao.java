package Dao;

import java.sql.*;





import Model.Customer;

public class CustomerDao implements ICustomerDao {
	DatabaseConnection databaseConnection;
	Connection connection;
	

	int customerID;
	
	public CustomerDao(DatabaseConnection databaseConnection){
		
		this.databaseConnection = databaseConnection;
		this.connection = databaseConnection.getConnection();
		this.connection = connection;
		}
	
	
	
	public void save(Customer customer) {
		try {
			String query1 = "insert into customer values(default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(query1);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setDate(3, customer.getDOB());
			stmt.setString(4, customer.getGender());
			stmt.setString(5, customer.getEmail());
			stmt.setString(6, customer.getMaritalStatus());
			stmt.setString(7, customer.getAddress());
			stmt.setString(8, customer.getPostalCode());
			stmt.setLong(9, customer.getPhoneNumber());
			stmt.setString(10, customer.getIdtype());
			stmt.setString(11, customer.getIdNumber());
			stmt.setLong(12, customer.getSIN());
			stmt.setString(13, customer.getEmploymentStatus());
			stmt.setString(14, customer.getJobTitle());
			stmt.setString(15, customer.getIncomeRange());
			
			stmt.executeUpdate();
			
			
			
		
		}
		
		catch(Exception e1){
			System.out.println(e1);
		}
		
		
	}
	
	public int getCustomerIDbyPhonenumber(Customer customer) {
		
		try {
		String query2 ="SELECT customer_id FROM Customer WHERE phone_number = "+ customer.getPhoneNumber();
		ResultSet resultSet;
		Statement statement = connection.createStatement();
		resultSet = statement.executeQuery(query2);
		resultSet.next();
		customerID = resultSet.getInt("customer_id");
		
		}
		catch(Exception e1){
			System.out.println(e1);
		}
		return customerID;
		
	}

}
