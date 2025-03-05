package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;





public class SignUpTwo extends JFrame implements ActionListener{
	
	JTextField idNumberTF, sinTF, employerNameTF, jobTitleTF;
	JButton next;
	JComboBox idTypeCombo, employmentCombo,incomeCombo;
	
	private CustomerController customerController;
	private NavigationManager navigationManager;
	
	SignUpTwo(CustomerController customerController, NavigationManager navigationManager){
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
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Ralewat", Font.BOLD, 22));
		additionalDetails.setBounds(270, 70, 400, 30);
		this.add(additionalDetails);
		
		JLabel idType = new JLabel("Type of ID:");
		idType.setFont(new Font("Ralewat", Font.BOLD, 20));
		idType.setBounds(100, 140, 110, 30);
		this.add(idType);
		
		String[] valID = {"BCID","Driver's License","Passport"};
		
		idTypeCombo = new JComboBox(valID);
		idTypeCombo.setBounds(300,140,400,30);
		idTypeCombo.setBackground(Color.white);
		this.add(idTypeCombo);
		
		
		JLabel idNumber = new JLabel("ID Number:");
		idNumber.setFont(new Font("Ralewat", Font.BOLD, 20));
		idNumber.setBounds(100, 190, 110, 30);
		this.add(idNumber);
		
		idNumberTF = new JTextField();
		idNumberTF.setFont(new Font("Raleway,", Font.BOLD, 14));
		idNumberTF.setBounds(300,190,400,30);
		this.add(idNumberTF);

		
		JLabel sin = new JLabel("SIN:");
		sin.setFont(new Font("Ralewat", Font.BOLD, 20));
		sin.setBounds(100, 240, 150, 30);
		this.add(sin);
		
		sinTF = new JTextField();
		sinTF.setFont(new Font("Raleway,", Font.BOLD, 14));
		sinTF.setBounds(300,240,400,30);
		this.add(sinTF);
		
		
		
		JLabel employmentStatus = new JLabel("Employment Status:");
		employmentStatus.setFont(new Font("Ralewat", Font.BOLD, 20));
		employmentStatus.setBounds(100, 290, 200, 30);
		this.add(employmentStatus);
		
		String[] valEmployment = {"Full-Time", "Part-Time", "Unemployed","Self-Employed"};
		
		employmentCombo = new JComboBox(valEmployment);
		employmentCombo.setBounds(300,290,400,30);
		employmentCombo.setBackground(Color.white);
		this.add(employmentCombo);
		
		
		JLabel employerName = new JLabel("Employer Name:");
		employerName.setFont(new Font("Ralewat", Font.BOLD, 20));
		employerName.setBounds(100, 340, 200, 30);
		this.add(employerName);
		
		employerNameTF = new JTextField();
		employerNameTF.setFont(new Font("Raleway,", Font.BOLD, 14));
		employerNameTF.setBounds(300,340,400,30);
		this.add(employerNameTF);
		
		JLabel jobTitle = new JLabel("Job Title:");
		jobTitle.setFont(new Font("Ralewat", Font.BOLD, 20));
		jobTitle.setBounds(100, 390, 150, 30);
		this.add(jobTitle);
		
		jobTitleTF = new JTextField();
		jobTitleTF.setFont(new Font("Raleway,", Font.BOLD, 14));
		jobTitleTF.setBounds(300,390,400,30);
		this.add(jobTitleTF);
		
		
		
		
		JLabel incomeRange = new JLabel("Income Range:");
		incomeRange.setFont(new Font("Ralewat", Font.BOLD, 20));
		incomeRange.setBounds(100, 450, 150, 30);
		this.add(incomeRange);
		
		String[] valIncome = {"Null", "< $30,000", "< $60,000","< $100,000","> $100,000"};
		
		incomeCombo = new JComboBox(valIncome);
		incomeCombo.setBounds(300,450,400,30);
		incomeCombo.setBackground(Color.white);
		this.add(incomeCombo);
		
		
		
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
		String idType = (String)idTypeCombo.getSelectedItem();
		String idNumber = idNumberTF.getText();
		String sinText = sinTF.getText();
		String employmentStatus = (String)employmentCombo.getSelectedItem();
		String employerName = employerNameTF.getText();
		String jobTitle = jobTitleTF.getText();
		String income = (String)incomeCombo.getSelectedItem();
		
		if (idNumber.isEmpty()) {
			JOptionPane.showMessageDialog(null, "ID Number is Required");
		}
		
		
		else if (sinText.isEmpty()) {
			JOptionPane.showMessageDialog(null, "SIN is required");
		}
		
		else if (employerName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Employer Name is required. ENTER N/A IF NOT APPLICABLE.");
		}
		else if (jobTitle.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Job Title is required. ENTER N/A IF NOT APPLICABLE.");
		}
		
		
		else {
			
			long sin = Long.parseLong(sinText);
			
			customerController.setAdditionalInfo(idType, idNumber, sin, employmentStatus, jobTitle, income);
			
			
			this.dispose();
			navigationManager.navigateToSignUpThreeView(navigationManager);
		}
		
	}
	
}
