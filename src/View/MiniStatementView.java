package View;

import java.awt.Color;
import java.awt.Font;
import java.util.*;

import javax.swing.*;

import Controller.AccountController;
import Controller.TransactionController;
import Model.Transaction;

public class MiniStatementView extends JFrame {
	
	private AccountController accountController;
	private NavigationManager navigationManager;
	
	MiniStatementView(AccountController accountController, NavigationManager navigationManager){
		this.accountController = accountController;
		this.navigationManager = navigationManager;
		this.setTitle("Mini Statement");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		
		//JLabel mini = new JLabel();
		//mini.setBounds(20, 140, 400, 200);
		//this.add(mini);
		
		JLabel bank = new JLabel("Candian Bank");
		bank.setBounds(150, 20, 100, 20);
		this.add(bank);
		
		//JLabel card = new JLabel();
		//card.setBounds(20, 80, 300, 20);
		//this.add(card);
		
		accountController.loadAllTransactions();
		
		
		
		JTextArea textArea = new JTextArea(formatTransactions(accountController.getTransactions()));
        textArea.setEditable(false);
        textArea.setFont(new Font("Raleway", Font.PLAIN, 12)); 

        
        JScrollPane scrollPane = new JScrollPane(textArea);

        
        scrollPane.setBounds(10, 60, 370, 440);
        this.add(scrollPane);
        
                
		JLabel balance = new JLabel("Your Current Balance is: $" + accountController.getBalance());
		balance.setBounds(20, 520, 300, 20);
		this.add(balance);
		
		
		
		this.setSize(400, 600);
		this.setLocation(20, 20);
		this.setVisible(true);
	}
	
	private String formatTransactions(List<Transaction> transactions) {
        StringBuilder statement = new StringBuilder();
        statement.append("Mini Statement\n");
        statement.append("===============================\n");
        statement.append(String.format("%-13s %11s %12s\n", "Date", "Type", "Amount"));
        statement.append("===============================\n");

        // Loop through transactions and format each one
        for (Transaction t : transactions) {
            statement.append(String.format("%-15s %-10s %-10.2f\n", t.getDate(), t.getTransactionType(), t.getAmount()));
        }

        statement.append("===============================\n");
        statement.append("Thank you for using Beem ATM.\n");
        return statement.toString();
    }

	

}
