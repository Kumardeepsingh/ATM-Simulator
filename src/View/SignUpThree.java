package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;
import Dao.AccountDao;
import Dao.Conn;
import Dao.IAccountBalanceDao;
import Dao.IAccountCreationDao;
import Dao.IAccountQueryDao;
import Service.AccountService;

public class SignUpThree extends JFrame implements ActionListener{
	
	JRadioButton saving, chequing;
	JButton submit, cancel;
	
	
	private CustomerController customerController;
	private AccountController accountController;
	private NavigationManager navigationManager;
	
	public SignUpThree(CustomerController customerController, AccountController accountController, NavigationManager navigationManager){
		this.customerController = customerController;
		this.accountController = accountController;
		this.navigationManager = navigationManager;
		
		
		JLabel l1 = new JLabel("Page3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD,32));
		l1.setBounds(260, 40, 400, 40);
		this.add(l1);
		
		JLabel accounttype = new JLabel("Account Type");
		accounttype.setFont(new Font("Raleway", Font.BOLD,22));
		accounttype.setBounds(380, 120, 200, 30);
		this.add(accounttype);
		
		saving = new JRadioButton("Saving Account");
		saving.setFont(new Font("Raleway", Font.BOLD,16));
		saving.setBackground(Color.WHITE);
		saving.setBounds(220,200,200,20);
		this.add(saving);
		
		chequing = new JRadioButton("Chequing Account");
		chequing.setFont(new Font("Raleway", Font.BOLD,16));
		chequing.setBackground(Color.WHITE);
		chequing.setBounds(520,200,200,20);
		this.add(chequing);
		
		ButtonGroup accountButtons = new ButtonGroup();
		accountButtons.add(saving);
		accountButtons.add(chequing);
		
		JLabel cardNummber = new JLabel("Card Number: ");
		cardNummber.setFont(new Font("Raleway", Font.BOLD,22));
		cardNummber.setBounds(220, 250, 180, 30);
		this.add(cardNummber);

		JLabel number = new JLabel("4536-XXXX-XXXX-XXXX");
		number.setFont(new Font("Raleway", Font.BOLD,22));
		number.setBounds(380, 250, 300, 30);
		this.add(number);
		
		JLabel cardDetails = new JLabel("Your 16 Digits Card Number");
		cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
		cardDetails.setBounds(220, 280, 300, 20);
		this.add(cardDetails);
		
		JLabel pin = new JLabel("Pin Number: ");
		pin.setFont(new Font("Raleway", Font.BOLD,22));
		pin.setBounds(220, 330, 180, 30);
		this.add(pin);
		
		JLabel pinDetails = new JLabel("Your 4 Digits PIN Number");
		pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
		pinDetails.setBounds(220, 360, 300, 20);
		this.add(pinDetails);
		
		JLabel pinNumber = new JLabel("XXXX");
		pinNumber.setFont(new Font("Raleway", Font.BOLD,22));
		pinNumber.setBounds(380, 330, 300, 30);
		this.add(pinNumber);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(250, 450, 100, 30);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.addActionListener(this);
		this.add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(520, 450, 100, 30);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.addActionListener(this);
		this.add(cancel);
		
		


		
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(null);
		this.setSize(850, 820);
		this.setLocation(350, 0);
		this.setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			String accountType = null;
			if(saving.isSelected()) {
				accountType = "Saving";
			}
			if(chequing.isSelected()) {
				accountType = "Chequing";
			}
			
			if (accountType == null) {
				JOptionPane.showMessageDialog(null, "Please select a Account Type");
			}
			else {
				customerController.createCustomer();
				customerController.setCustomerID();
				accountController.setAccountType(accountType);
				accountController.setCustomerId(customerController.getCustomer().getCustomerId());
				accountController.createAccount();
				accountController.setAccountID();
				JOptionPane.showMessageDialog(null, "Card Number: " + accountController.getCardnumber() + "\n PIN: " + accountController.getPinNumber());
				this.dispose();
				navigationManager.navigateToDepositView(navigationManager);
			}
		}
		else {
			this.dispose();
			navigationManager.navigateToLoginView(navigationManager);
		}
		
	}

}
