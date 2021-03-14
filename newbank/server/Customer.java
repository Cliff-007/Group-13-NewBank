package newbank.server;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
	
	private ArrayList<Account> accounts;
	private String fullName;
	private HashMap<String, String> address;
	private String dob;
	private String taxId;
	private CustomerID customerId;
	
	public Customer() {
		accounts = new ArrayList<>();
		address = new HashMap<>();
	}
	
	public String accountsToString() {
		String s = "";
		for(Account a : accounts) {
			s += a.toString();
		}
		return s;
	}

	public String addressToString() {
		String s = "";
		for(String value: address.values()){
			s += value;
		}
		return s;
	}

	// setters
	public void setAccount(Account account) {
		accounts.add(account);
	}

	public void setFullName(String name) {
		fullName = name;
	}

	public void setAddress(String addressLine1, String addressLine2, String addressLine3) {
		address.put("HouseNumber+Street", addressLine1);
		address.put("City", addressLine2);
		address.put("Postal Code", addressLine3);
	}

	public void setTaxId(String taxIdentifier){
		taxId = taxIdentifier;
	}

	public void setBirthdate(String birthdate){
		dob = birthdate;
	}

	// getters
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public String getFullName() {
		return fullName;
	}

	public HashMap<String, String> getAddress() {
		return address;
	}

	public String getBirthdate() {
		return dob;
	}

	public String getTaxId() {
		return taxId;
	}

	public int getCustomerId() {
		return customerId.getUniqueID();
	}
}
