package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;
import Dao.Conn;
import Dao.DatabaseConnection;
import Dao.ITransactionCreationDao;
import Dao.TransactionDao;


public class FastCashView extends JFrame implements ActionListener{
	
	private AccountController accountController;
	private TransactionController transactionController;
	private NavigationManager navigationManager;

	JButton amount1, amount2, amount3, amount4, amount5, amount6, back;
	
	FastCashView(AccountController accountController, TransactionController transactionController, NavigationManager navigationManager){

		this.accountController = accountController;
		this.transactionController = transactionController;
		this.navigationManager = navigationManager;
		this.setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		this.add(image);
		
		JLabel text = new JLabel("Please select Withdrawal Amount");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);
		
		amount1 = new JButton("$ 10");
		amount1.setBounds(170, 415, 150, 30);
		amount1.addActionListener(this);
		image.add(amount1);
		
		amount2 = new JButton("$20");
		amount2.setBounds(355, 415, 150, 30);
		amount2.addActionListener(this);
		image.add(amount2);
		
		amount3 = new JButton("$30");
		amount3.setBounds(170, 450, 150, 30);
		amount3.addActionListener(this);
		image.add(amount3);
		
		amount4 = new JButton("$40");
		amount4.setBounds(355, 450, 150, 30);
		amount4.addActionListener(this);
		image.add(amount4);
		
		amount5 = new JButton("$50");
		amount5.setBounds(170, 485, 150, 30);
		amount5.addActionListener(this);
		image.add(amount5);
		
		amount6 = new JButton("$100");
		amount6.setBounds(355, 485, 150, 30);
		amount6.addActionListener(this);
		image.add(amount6);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		this.setSize(900,900);
		this.setLocation(300, 0);
		//this.setUndecorated(true);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == back) {
			this.dispose();
			navigationManager.navigateToTransactionView(navigationManager);
		}
		else {
			String transactionType = "Withdraw";
			String amountText = ((JButton)e.getSource()).getText().substring(1);
			
			if (amountText.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Enter Some Amount.");
			}
			else {
				Double withdrawAmount = Double.parseDouble(amountText);
				Double balance = accountController.getBalance();
				if ( balance < withdrawAmount) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				else {
				
				transactionController.setTransactionType(transactionType);
				transactionController.setAmount(withdrawAmount);
				transactionController.setAccountId(accountController.getAccountId());
				transactionController.createTransaction();
				accountController.setBalance(transactionController.calculateBalance(accountController.getAccountId()));
				accountController.updateBalance();
				JOptionPane.showMessageDialog(null, "$" + withdrawAmount + " Successfully Withdrawn.");
				this.dispose();
				navigationManager.navigateToTransactionView(navigationManager);
			}
			}
		}
		
	}
	

}

