package Dao;

import Model.Customer;

public interface ICustomerDao {
	public void save(Customer customer);
	public int getCustomerIDbyPhonenumber(Customer customer);
	

}
