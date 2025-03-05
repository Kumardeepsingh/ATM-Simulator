package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;
import Dao.Conn;
import Dao.DatabaseConnection;
import Dao.ITransactionCreationDao;
import Dao.TransactionDao;


public class WithdrawlView extends JFrame implements ActionListener{
	JTextField amount;
	JButton withdraw, back;
	private AccountController accountController;
	private TransactionController transactionController;
	private NavigationManager navigationManager;
	
	WithdrawlView(AccountController accountController, TransactionController transactionController, NavigationManager navigationManager){
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
		
		JLabel  text = new JLabel(" Enter the amount you want to Withdraw");
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		text.setBounds(170, 300, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 350, 320, 25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355, 485, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		this.setSize(900, 900);
		this.setLocation(300, 0);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == withdraw) {
			String transactionType = "Withdraw";
			String withdrawAmountText = amount.getText();
			
			
			if (withdrawAmountText.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Enter Some Amount.");
			}
			else {
				Double withdrawAmount = Double.parseDouble(withdrawAmountText);
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
		 if(e.getSource() == back) {
			this.dispose();
			navigationManager.navigateToTransactionView(navigationManager);
		}
		
	}


}
