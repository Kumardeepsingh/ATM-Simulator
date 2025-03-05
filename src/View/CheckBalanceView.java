package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;

public class CheckBalanceView extends JFrame implements ActionListener{
	
	JButton back;
	double balance;
	private AccountController accountController;
	private NavigationManager navigationManager;
	
	
	
	CheckBalanceView(AccountController accountController, NavigationManager navigationManager){
		
		this.accountController = accountController;
		this.navigationManager = navigationManager;
		
		this.setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		this.add(image);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		balance = accountController.getBalance();
		
		JLabel text = new JLabel("Your Current Account Balancce is $" + balance);
		text.setForeground(Color.white);
		text.setBounds(170, 300, 400, 30);
		image.add(text);
		
		this.setSize(900, 900);
		this.setLocation(300, 0);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			this.dispose();
			navigationManager.navigateToTransactionView(navigationManager);
		}
		
	}

}
