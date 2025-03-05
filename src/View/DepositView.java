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
import Dao.DatabaseConnection;
import Dao.IAccountCreationDao;
import Dao.ITransactionCreationDao;
import Dao.TransactionDao;

public class DepositView extends JFrame implements ActionListener {
	
	JTextField amount;
	JButton deposit, back;
	
	
	
	
	private AccountController accountController;
	private TransactionController transactionController;
	private NavigationManager navigationManager;
	
	DepositView(AccountController accountController, TransactionController transactionController, NavigationManager navigationManager){
		
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
		
		JLabel  text = new JLabel(" Enter the amount you want to deposit");
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		text.setBounds(170, 300, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 350, 320, 25);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355, 485, 150, 30);
		image.add(deposit);
		deposit.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		image.add(back);
		back.addActionListener(this);
		
		
		this.setSize(900, 900);
		this.setLocation(300, 0);
		this.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deposit) {
			String transactionType = "Deposit";
			String depositAmountText = amount.getText();
			
			if (depositAmountText.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Enter Some Amount.");
			}
			else {
				Double depositAmount = Double.parseDouble(depositAmountText);
				transactionController.setTransactionType(transactionType);
				transactionController.setAmount(depositAmount);
				transactionController.setAccountId(accountController.getAccountId());
				transactionController.createTransaction();
				accountController.setBalance(transactionController.calculateBalance(accountController.getAccountId()));
				accountController.updateBalance();
				JOptionPane.showMessageDialog(null, "$" + depositAmount + " Successfully Deposited.");
				this.dispose();
				navigationManager.navigateToTransactionView(navigationManager);
			}
		}
		 if(e.getSource() == back) {
			this.dispose();
			navigationManager.navigateToTransactionView(navigationManager);
		}
		
	}

}
