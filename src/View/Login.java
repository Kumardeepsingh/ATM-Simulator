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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;
import Dao.IAccountCreationDao;



public class Login extends JFrame implements ActionListener{
	
	JButton login, clear, signUp;
	JTextField cardTextField;
	JPasswordField pinPasswordField;
	private AccountController accountController;
	private LoginController loginController;
	private NavigationManager navigationManager;
	
	
	Login(AccountController accountController, LoginController loginController, NavigationManager navigationManager){
		
		this.accountController = accountController;
		this.loginController = loginController;
		this.navigationManager = navigationManager;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("AUTOMATED TELLER MACHINE");
		this.setSize(800,480);
		this.setLocation(350, 200);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		this.add(label);
		
		JLabel text = new JLabel("Welcom to ATM");
		text.setFont(new Font("Osward", Font.BOLD,38));
		text.setBounds(200, 40, 300, 40);
		this.add(text);
		
		JLabel cardNo = new JLabel("Card No:");
		cardNo.setFont(new Font("Raleway", Font.BOLD,28));
		cardNo.setBounds(120, 150, 150, 30);
		this.add(cardNo);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial", Font.BOLD,14));
		this.add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD,28));
		pin.setBounds(120, 220, 150, 30);
		this.add(pin);
		
		pinPasswordField = new JPasswordField();
		pinPasswordField.setBounds(300,220,230,30);
		pinPasswordField.setFont(new Font("Arial", Font.BOLD,14));
		this.add(pinPasswordField);
		
		login = new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		this.add(login);
		
		clear = new JButton("clear");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		this.add(clear);
		
		signUp = new JButton("SIGN UP");
		signUp.setBounds(300,350,230,30);
		signUp.setBackground(Color.black);
		signUp.setForeground(Color.white);
		signUp.addActionListener(this);
		this.add(signUp);
		
		
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			Long cardNumber = Long.parseLong(cardTextField.getText().toString());
			int pin = Integer.parseInt(pinPasswordField.getText().toString());
			accountController.setAccountFromCardNumber(cardNumber);
			
			boolean validate = loginController.login(cardNumber, pin);
			if(validate){
				this.dispose();
				navigationManager.navigateToTransactionView(navigationManager);
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				cardTextField.setText("");
				pinPasswordField.setText("");
			}
			
			
		}
		if(e.getSource() == signUp) {
			this.dispose();
			navigationManager.navigateToSignUpView(navigationManager);
		}
		
		if(e.getSource() == clear) {
			cardTextField.setText("");
			pinPasswordField.setText("");
		}
		
	}
}
