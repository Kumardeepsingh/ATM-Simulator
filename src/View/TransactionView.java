package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;

public class TransactionView extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balance, exit;
	
	private NavigationManager navigationManager;
	
	TransactionView(NavigationManager navigationManager){
		this.navigationManager = navigationManager;

		this.setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		this.add(image);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170, 450, 150, 30);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355, 450, 150, 30);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinChange = new JButton("PIN Change");
		pinChange.setBounds(170, 485, 150, 30);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		balance = new JButton("Check Balance");
		balance.setBounds(355, 485, 150, 30);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exit");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
		this.setSize(900,900);
		this.setLocation(300, 0);
		//this.setUndecorated(true);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deposit) {
			this.dispose();
			navigationManager.navigateToDepositView(navigationManager);
		}
		else if(e.getSource() == withdrawl) {
			this.dispose();
			navigationManager.navigateToWithdrawlTwoView(navigationManager);
		}
		else if(e.getSource() == fastCash) {
			this.dispose();
			navigationManager.navigateToFastCashView(navigationManager);
		}
		else if(e.getSource() == pinChange) {
			this.dispose();
			navigationManager.navigateToPinChangeView(navigationManager);
		}
		else if(e.getSource() == balance) {
			this.dispose();
			navigationManager.navigateToCheckBalanceView(navigationManager);
		}
		
		else if(e.getSource() == miniStatement) {
			this.dispose();
			navigationManager.navigateToMiniStatementView(navigationManager);
		}
		else {
			this.dispose();
			navigationManager.navigateToLoginView(navigationManager);
		}
		
	}
	
	

}
