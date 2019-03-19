package bankingTransactions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Manager {
	
	public static boolean isNumeric(String str) {
		  return str.matches("-?\\d+(\\.\\d+)?"); 
	}
	
	public static void main(String[] args) {
		
		
		JLabel masterLabel, balanceLabel, nameLabel, addressLabel, cityLabel,
			   accountNum, relatedAccs, lastnameLabel;
		
		JTextField entry;
		JButton deposit, withdraw, changeAccountNumber;
		
		Account customer = new Account("CustomerFirst", "CustomerLast","CustAddress",
				"CustCountry", "CustCity");
		customer.setAccountBalance(456322.75);
		
		JFrame frame = new JFrame("Basic Account Management");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(6,1));
		frame.setSize(400, 200);
		
		masterLabel = new JLabel("Deposit/Withdraw");
		balanceLabel = new JLabel("Balance: $" + customer.getAccountBalance());
		entry = new JTextField();
		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		changeAccountNumber = new JButton("Change Details");
		
		accountNum = new JLabel("Account numebr: " + customer.getAccountNumber());
		relatedAccs = new JLabel("Connected accounts: " + customer.getRelatedAccounts());
		nameLabel = new JLabel("Name: " + customer.getFirstname());
		lastnameLabel = new JLabel("Lastname: " + customer.getLastname());
		addressLabel = new JLabel("Address: " + customer.getAddress());
		cityLabel = new JLabel("City: " + customer.getCity());
		
		changeAccountNumber.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String choice = JOptionPane.showInputDialog("Type 1 for name, 2 for lastname, 3 for address, 4 for city");
				if (isNumeric(choice)){
					int c = Integer.parseInt(choice);
					if (c == 1){
						String first = JOptionPane.showInputDialog("Choose a new name");
						customer.setFirstname(first);
						JOptionPane.showMessageDialog(null, "First name changed successfully");
						nameLabel.setText(customer.getFirstname());
					} else if (c == 2){
						String last = JOptionPane.showInputDialog("Choose a new lastname");
						customer.setLastname(last);
						JOptionPane.showMessageDialog(null, "Lastname changed successfully");
						lastnameLabel.setText(customer.getLastname());
					} else if (c == 3){
						String addr = JOptionPane.showInputDialog("Choose a new address");
						customer.setAddress(addr);
						JOptionPane.showMessageDialog(null, "Address changed successfully");
						addressLabel.setText(customer.getAddress());						
					} else if (c == 4){
						String cty = JOptionPane.showInputDialog("Choose a new city");
						customer.setCity(cty);
						JOptionPane.showMessageDialog(null, "City changed successfully");
						cityLabel.setText(customer.getCity());
						
					} else {
						JOptionPane.showMessageDialog(null, "Not able to process this request.");
						return;
					}
					JOptionPane.showMessageDialog(null, "Operation Completed.");
				} else {
					JOptionPane.showMessageDialog(null, "Operation Cancelled.");
				}
			}
			
		});
		deposit.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				String value = entry.getText();
				if (isNumeric(value)){
					customer.deposit(Double.parseDouble(value));
					balanceLabel.setText("Balance: $" + customer.getAccountBalance()+"");
					entry.setText("");
				} else {
					entry.setText("");
					JOptionPane.showMessageDialog(null, "Operation Cancelled.");
				}
			} 
		});
		
		withdraw.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				String value = entry.getText();
				if (isNumeric(value)){
					customer.withdraw(Double.parseDouble(value));
					if (customer.getAccountBalance() <= 0){
						customer.setAccountBalance(0);
						balanceLabel.setText("Balance: $" + customer.getAccountBalance());
						entry.setText("");
					} else {
						balanceLabel.setText("Balance: $" + customer.getAccountBalance());
						entry.setText("");
					}
				} else {
					entry.setText("");
					JOptionPane.showMessageDialog(null, "Operation Cancelled.");
				}
			} 
		});
		
		frame.add(masterLabel); // row 1, pos 1
		frame.add(entry); // row 1, pos 2
		frame.add(deposit); // row 2, pos 1
		frame.add(withdraw); // row 2, pos 2
		frame.add(balanceLabel); // row 3, pos 1
		frame.add(relatedAccs); // row 3, pos 2
		frame.add(nameLabel); // row 4, pos 1
		frame.add(lastnameLabel); // row 4, pos 2
		frame.add(accountNum); // row 5, pos 1
		frame.add(changeAccountNumber); // row 5, pos 2
		frame.add(addressLabel); // row 6, pos 1
		frame.add(cityLabel); // row 6, pos 2
		
		frame.setVisible(true);
		

	}

}
