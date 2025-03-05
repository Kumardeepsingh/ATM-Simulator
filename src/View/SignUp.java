package View;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


import com.toedter.calendar.JDateChooser;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;
import Dao.Conn;
import Dao.CustomerDao;
import Dao.DatabaseConnection;
import Dao.ICustomerDao;




public class SignUp extends JFrame implements ActionListener{
	
	JTextField fNameTextField, lNameTextField, addressTextField, emailTextField, postalCodeTextField, phoneNumberTextField;
	JButton next;
	JRadioButton male, female, married, unmarried, other;
	JDateChooser dateChooser;
	int customerID;
	private CustomerController customerController;
	private NavigationManager navigationManager;
	SignUp(CustomerController customerController, NavigationManager navigationManager){
		
		this.customerController = customerController;
		this.navigationManager = navigationManager;

		this.getContentPane().setBackground(Color.white);
		this.setSize(850,800);
		this.setLocation(350,10);
		this.setLayout(null);
		
		JLabel title = new JLabel("APPLICATION FORM: ");
		title.setFont(new Font("Ralewat", Font.BOLD, 38));
		title.setBounds(200, 20, 600, 38);
		this.add(title);
		
		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Ralewat", Font.BOLD, 22));
		personDetails.setBounds(270, 70, 400, 30);
		this.add(personDetails);
		
		JLabel fName = new JLabel("First Name:");
		fName.setFont(new Font("Ralewat", Font.BOLD, 20));
		fName.setBounds(100, 140, 110, 30);
		this.add(fName);
		
		fNameTextField = new JTextField();
		fNameTextField.setFont(new Font("Raleway,", Font.BOLD, 14));
		fNameTextField.setBounds(300,140,400,30);
		this.add(fNameTextField);
		
		JLabel lName = new JLabel("Last Name:");
		lName.setFont(new Font("Ralewat", Font.BOLD, 20));
		lName.setBounds(100, 190, 110, 30);
		this.add(lName);
		
		lNameTextField = new JTextField();
		lNameTextField.setFont(new Font("Raleway,", Font.BOLD, 14));
		lNameTextField.setBounds(300,190,400,30);
		this.add(lNameTextField);

		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Ralewat", Font.BOLD, 20));
		dob.setBounds(100, 240, 150, 30);
		this.add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		this.add(dateChooser);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Ralewat", Font.BOLD, 20));
		gender.setBounds(100, 290, 150, 30);
		this.add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.white);
		this.add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450,290,70,30);
		female.setBackground(Color.white);
		this.add(female);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(female);
		genderGroup.add(male);
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Ralewat", Font.BOLD, 20));
		email.setBounds(100, 340, 150, 30);
		this.add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway,", Font.BOLD, 14));
		emailTextField.setBounds(300,340,400,30);
		this.add(emailTextField);
		
		JLabel maritalStatus = new JLabel("Marital Status:");
		maritalStatus.setFont(new Font("Ralewat", Font.BOLD, 20));
		maritalStatus.setBounds(100, 390, 150, 30);
		this.add(maritalStatus);
		
		married = new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.white);
		this.add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.white);
		this.add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(630,390,100,30);
		other.setBackground(Color.white);
		this.add(other);
		

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Ralewat", Font.BOLD, 20));
		address.setBounds(100, 440, 150, 30);
		this.add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway,", Font.BOLD, 14));
		addressTextField.setBounds(300,440,400,30);
		this.add(addressTextField);
		
		JLabel postalCode = new JLabel("Postal Code:");
		postalCode.setFont(new Font("Ralewat", Font.BOLD, 20));
		postalCode.setBounds(100, 490, 150, 30);
		this.add(postalCode);
		
		postalCodeTextField = new JTextField();
		postalCodeTextField.setFont(new Font("Raleway,", Font.BOLD, 14));
		postalCodeTextField.setBounds(300,490,400,30);
		this.add(postalCodeTextField);
		
		JLabel phoneNumber = new JLabel("Phone Number:");
		phoneNumber.setFont(new Font("Ralewat", Font.BOLD, 20));
		phoneNumber.setBounds(100, 540, 150, 30);
		this.add(phoneNumber);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setFont(new Font("Raleway,", Font.BOLD, 14));
		phoneNumberTextField.setBounds(300,540,400,30);
		this.add(phoneNumberTextField);
		
		next =  new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		this.add(next);
		
		
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String firstName = fNameTextField.getText();
		String lastName = lNameTextField.getText();
		java.util.Date date = dateChooser.getDate();
		
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}
		if(female.isSelected()){
			gender = "Female";
		}
		String email = emailTextField.getText();
		String maritalStatus = null;
		if(married.isSelected()) {
			maritalStatus = "Married";
		}
		if(unmarried.isSelected()){
			maritalStatus = "Unmarried";
		} 
		if(other.isSelected()){
			maritalStatus = "Other";
		} 
		String address = addressTextField.getText();
		String postalCode = postalCodeTextField.getText();
		String phoneNumberText = phoneNumberTextField.getText();
		
		
		if (firstName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "First Name is Required");
		}
		else if (lastName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Last Name is Required");
		}
		else if (date == null) {
			JOptionPane.showMessageDialog(null, "Date is Required");
		}
		else if (gender == null) {
			JOptionPane.showMessageDialog(null, "Please select a gender");
		}
		else if (email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Email is Required");
		}
		else if (maritalStatus == null) {
			JOptionPane.showMessageDialog(null, "Please select yout Marital Status");
		}
		else if (address.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Address is Required");
		}
		else if (postalCode.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Postal Code is Required");
		}
		else if (phoneNumberText.isBlank()) {
			JOptionPane.showMessageDialog(null, "Phone Number is Required");
		}
		else {
			Date dob = new Date(date.getTime());
			
			long phoneNumber = Long.parseLong(phoneNumberText);
			customerController.setBasicInfo(firstName, lastName, dob,  gender,  email,  maritalStatus,
								 address, postalCode,  phoneNumber);
			this.dispose();
			navigationManager.navigateToSignUpTwoView(navigationManager);
		}
		
		
	}
	
}
