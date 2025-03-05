package Controller;



import java.sql.Date;

import Dao.CustomerDao;
import Dao.ICustomerDao;
import Model.Customer;

public class CustomerController {
	
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String email;
	private String maritalStatus;
	private String address;
	private String postalCode;
	private long phoneNumber;
	private String idType;
	private String idNumber;
	private long sin;
	private String employmentStatus;
	private String jobTitle;
	private String incomeRange;
	
	private Customer customer;
	private ICustomerDao customerDao;
	
	public CustomerController(ICustomerDao customerDao){
		this.customerDao = customerDao;
		
	}
	
	public void setBasicInfo(String firstName, String lastName, Date dob, String gender, String email, String maritalStatus,
								String address,String postalCode, long phoneNumber) {
		this.firstName = firstName;
		 this.lastName = lastName;
		 this.dob = dob;
		 this.gender = gender;
		 this.email = email;
		 this.maritalStatus = maritalStatus;
		 this.address = address;
		 this.postalCode = postalCode;
		 this.phoneNumber = phoneNumber;
		
	}
	
	public void setAdditionalInfo(String idType, String idNumber, long sin, String employmentStatus, String jobTitle,
									String incomeRange) {
		this.idType = idType;
		 this.idNumber = idNumber;
		 this.sin = sin;
		 this.employmentStatus = employmentStatus;
		 this.jobTitle = jobTitle;
		 this.incomeRange = incomeRange; 
		
	}
	
	
	public void createCustomer() {
		customer = new Customer.CustomerBuilder(firstName, lastName)
								.dob(dob)
								.gender(gender)
								.email(email)
								.maritalStatus(maritalStatus)
								.address(address)
								.postalCode(postalCode)
								.phoneNumber(phoneNumber)
								.idType(idType)
								.idNumber(idNumber)
								.sin(sin)
								.employmentStatus(employmentStatus)
								.jobTitle(jobTitle)
								.incomeRange(incomeRange)
								.build();
		customerDao.save(customer);
		
	}
	
	public void setCustomerID() {
		customer.setCustomerId(customerDao.getCustomerIDbyPhonenumber(customer));
	}
	
	public Customer getCustomer() {
		return customer;
	}
	

}
