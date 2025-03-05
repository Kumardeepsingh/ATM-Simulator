package Model;

import java.sql.Date;

public class Customer {
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
	private int customerId;
	 
	 private Customer(CustomerBuilder builder){
		 this.firstName = builder.firstName;
		 this.lastName = builder.lastName;
		 this.dob = builder.dob;
		 this.gender = builder.gender;
		 this.email = builder.email;
		 this.maritalStatus = builder.maritalStatus;
		 this.address = builder.address;
		 this.postalCode = builder.postalCode;
		 this.phoneNumber = builder.phoneNumber;
		 this.idType = builder.idType;
		 this.idNumber = builder.idNumber;
		 this.sin = builder.sin;
		 this.employmentStatus = builder.employmentStatus;
		 this.jobTitle = builder.jobTitle;
		 this.incomeRange = builder.incomeRange; 
	 }
	 
	 
	 // getters
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public String getLastName() {
		 return lastName;
	 }
	 
	 public Date getDOB() {
		 return dob;
	 }
	 
	 public String getGender() {
		 return gender;
	 }
	 
	 public String getEmail() {
		 return email;
	 }
	 
	 public String getMaritalStatus() {
		 return maritalStatus;
	 }
	 
	 public String getAddress() {
		 return address;
	 }
	 
	 public long getPhoneNumber() {
		 return phoneNumber;
	 }
	 
	 public String getIdtype() {
		 return idType;
	 }
	 
	 public String getPostalCode() {
		 return postalCode;
	 }
	 
	 public String getIdNumber() {
		 return idNumber;
	 }
	 
	 public long getSIN() {
		 return sin;
	 }
	 
	 public String getEmploymentStatus() {
		 return employmentStatus;
	 }
	 
	 public String getJobTitle() {
		 return jobTitle;
	 }
	 
	 public String getIncomeRange() {
		 return incomeRange;
	 }
	 
	 public void setCustomerId(int customerId) {
		 this.customerId = customerId;
	 }
	 public int getCustomerId() {
		 return customerId;
	 }
	 
	 
	 
	 // nested builder class
	 
	 public static class CustomerBuilder {
			
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
			
			public CustomerBuilder(String firstName, String lastName){
				this.firstName = firstName;
				this.lastName = lastName;
			}
			
			public CustomerBuilder dob (Date dob) {
				this.dob = dob;
				return this;
			}
			
			public CustomerBuilder gender (String gender) {
				this.gender = gender;
				return this;
			}
			
			public CustomerBuilder email (String email) {
				this.email = email;
				return this;
			}
			
			public CustomerBuilder maritalStatus (String maritalStatus) {
				this.maritalStatus = maritalStatus;
				return this;
			}
			
			public CustomerBuilder address (String address) {
				this.address = address;
				return this;
			}
			
			public CustomerBuilder postalCode (String postalCode) {
				this.postalCode = postalCode;
				return this;
			}
			
			public CustomerBuilder phoneNumber (long phoneNumber) {
				this.phoneNumber = phoneNumber;
				return this;
			}
			
			public CustomerBuilder idType (String idType) {
				this.idType = idType;
				return this;
			}
			
			public CustomerBuilder idNumber (String idNumber) {
				this.idNumber = idNumber;
				return this;
			}
			
			public CustomerBuilder sin (long sin) {
				this.sin = sin;
				return this;
			}
			
			public CustomerBuilder employmentStatus (String employmentStatus) {
				this.employmentStatus = employmentStatus;
				return this;
			}
			
			public CustomerBuilder jobTitle (String jobTitle) {
				this.jobTitle = jobTitle;
				return this;
			}
			
			public CustomerBuilder incomeRange (String incomeRange) {
				this.incomeRange = incomeRange;
				return this;
			}
			
			public Customer build() {
				return new Customer(this);
			}
			
			

		}

}
