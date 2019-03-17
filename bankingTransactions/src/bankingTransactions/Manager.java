package bankingTransactions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Manager {

	public static void main(String[] args) {
		
		
		JLabel masterLabel, balanceLabel;
		JTextField entry;
		JButton deposit, withdraw;
		
		Account customer = new Account("CustomerFirst", "CustomerLast","CustAddress",
				"CustCountry", "CustCity");
		customer.setAccountBalance(456322.75);
		
		JFrame frame = new JFrame("Basic Account Management");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 200);
		frame.setLayout(new GridLayout(4,1));
		frame.setSize(300, 150);
		
		masterLabel = new JLabel("Deposit/Withdraw");
		balanceLabel = new JLabel("Balance: $" + customer.getAccountBalance());
		entry = new JTextField();
		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		
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
		
		frame.add(masterLabel);
		frame.add(entry);
		frame.add(deposit);
		frame.add(withdraw);
		frame.add(balanceLabel);
		frame.setVisible(true);

	}

}
