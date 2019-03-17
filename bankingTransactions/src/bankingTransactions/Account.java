package bankingTransactions;

import java.util.*;

import javax.swing.JOptionPane;

public class Account extends Manager {
	
	private int accountNumber, paymentID, relatedAccounts, bound = 10000000;
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public int getRelatedAccounts() {
		return relatedAccounts;
	}

	public void setRelatedAccounts(int relatedAccounts) {
		this.relatedAccounts = relatedAccounts;
	}

	public int getBound() {
		return bound;
	}

	public void setBound(int bound) {
		this.bound = bound;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private String firstname, lastname, address, country, city;
	private double accountBalance = 0; 
	private boolean active = true;

	public Account(String firstname, String lastname, String address, 
					String country, String city){
		this.accountNumber = new Random().nextInt(bound)+1;
		this.paymentID = new Random().nextInt(bound);
		this.relatedAccounts = 0;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.country = country;
		this.city = city;
	}
	
	public void deposit(double amount){
		if (this.getAccountBalance() >= 0){
			this.setAccountBalance(this.getAccountBalance() + amount);
			JOptionPane.showMessageDialog(null, "Deposit successfull.");
			JOptionPane.showMessageDialog(null, "New balance: " + this.getAccountBalance());
		} else {
			JOptionPane.showMessageDialog(null, "Unable to perform this task.");
		}
	}
	
	public void withdraw(double amount){
		if (this.getAccountBalance() > 0){
			this.setAccountBalance(this.getAccountBalance() - amount);
			JOptionPane.showMessageDialog(null, "Withdraw successfull.");
		} else {
			JOptionPane.showMessageDialog(null, "Unable to perform this task.");
		}
	}

}
