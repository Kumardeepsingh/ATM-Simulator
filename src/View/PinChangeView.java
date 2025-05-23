package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.AccountController;
import Controller.CustomerController;
import Controller.LoginController;
import Controller.TransactionController;

public class PinChangeView  extends JFrame implements ActionListener{
	
	JPasswordField pin, rePin;
	JButton change, back;
	private AccountController accountController;
	private NavigationManager navigationManager;
	PinChangeView(AccountController accountController, NavigationManager navigationManager){
		this.accountController = accountController;
		this.navigationManager = navigationManager;
		this.setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		this.add(image);
		
		JLabel text = new JLabel("Change your PIN");
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		text.setBounds(270, 280, 500, 35);
		image.add(text);
		
		JLabel pinText = new JLabel("New PIN");
		pinText.setForeground(Color.white);
		pinText.setFont(new Font("Raleway", Font.BOLD, 16));
		pinText.setBounds(165, 320, 100, 25);
		image.add(pinText);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 25));
		pin.setBounds(330, 320, 180, 25);
		image.add(pin);
		
		
		
		JLabel rePinText = new JLabel("Re-Enter New PIN");
		rePinText.setForeground(Color.white);
		rePinText.setFont(new Font("Raleway", Font.BOLD, 16));
		rePinText.setBounds(165, 360, 180, 25);
		image.add(rePinText);
		
		rePin = new JPasswordField();
		rePin.setFont(new Font("Raleway", Font.BOLD, 25));
		rePin.setBounds(330, 360, 180, 25);
		image.add(rePin);
		
		change = new JButton("CHANGE");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		this.setSize(900, 900);
		this.setLocation(300, 0);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == change) {
			int pinNumber = Integer.parseInt(pin.getText());
			int rePinNumber = Integer.parseInt(rePin.getText());
			if(pinNumber != rePinNumber) {
				JOptionPane.showMessageDialog(null, "Pin do not Match. Please Try Again");
				pin.setText("");
				rePin.setText("");
			}
			else {
				
				accountController.setPinNumber(pinNumber);
				accountController.changePinNumber();
				JOptionPane.showMessageDialog(null, "PIN Changed Succesfully");
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
