package bankingTransactions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Manager {

	public static void main(String[] args) {
		
		
		JLabel masterLabel, balanceLabel, name,
			   accountNum, relatedAccs, lastname;
		
		JTextField entry;
		JButton deposit, withdraw;
		
		Account customer = new Account("CustomerFirst", "CustomerLast","CustAddress",
				"CustCountry", "CustCity");
		customer.setAccountBalance(456322.75);
		
		JFrame frame = new JFrame("Basic Account Management");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(5,1));
		frame.setSize(400, 200);
		
		masterLabel = new JLabel("Deposit/Withdraw");
		balanceLabel = new JLabel("Balance: $" + customer.getAccountBalance());
		entry = new JTextField();
		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		
		accountNum = new JLabel("Account numebr: " + customer.getAccountNumber());
		relatedAccs = new JLabel("Connected accounts: " + customer.getRelatedAccounts());
		name = new JLabel("Name: " + customer.getFirstname());
		lastname = new JLabel("Lastname: " + customer.getLastname());
		
		
		deposit.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				String value = entry.getText();
				customer.deposit(Double.parseDouble(value));
				balanceLabel.setText("Balance: $" + customer.getAccountBalance()+"");
				entry.setText("");
			} 
		});
		
		withdraw.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				String value = entry.getText();
				customer.withdraw(Double.parseDouble(value));
				if (customer.getAccountBalance() <= 0){
					customer.setAccountBalance(0);
					balanceLabel.setText("Balance: $" + customer.getAccountBalance());
					entry.setText("");
				} else {
					balanceLabel.setText("Balance: $" + customer.getAccountBalance());
					entry.setText("");
				}
			} 
		});
		
		frame.add(masterLabel); // row 1, pos 1
		frame.add(entry); // row 1, pos 2
		frame.add(deposit); // row 2, pos 1
		frame.add(withdraw); // row 2, pos 2
		frame.add(balanceLabel); // row 3, pos 1
		frame.add(relatedAccs); // row 3, pos 2
		frame.add(name); // row 4, pos 1
		frame.add(lastname); // row 4, pos 2
		frame.add(accountNum); // row 5, pos 1
		frame.add(new JLabel("")); // row 5, pos 2
		
		frame.setVisible(true);
		

	}

}
