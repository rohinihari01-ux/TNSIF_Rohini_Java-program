package bank_sys_mini_project;

import java.util.Objects; 
	public class Customer { 
		private int customerID; 
		private String name; 
		private String address; 
		private String contact; 
	public Customer(int customerID, String name, String address, String contact) { 
		this.customerID = customerID; 
		this.name = name; 
		this.address = address; 
		this.contact = contact; 
		} 
	public int getCustomerID() { return customerID; } 
	public void setCustomerID(int customerID) { this.customerID = customerID; } 
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; } 
	public String getAddress() { return address; } 
	public void setAddress(String address) { this.address = address; } 
	public String getContact() { return contact; } 
	public void setContact(String contact) { this.contact = contact; } 
@Override 
	public String toString() { 
		return "Customer ID: " + customerID + ", Name: " + name + ", Address: " +address + ", Contact: " + contact; 
} 
@Override 
public boolean equals(Object o) { 
	if (this == o) return true; 
	if (o == null || getClass() != o.getClass()) return false; 
	Customer customer = (Customer) o; 
	return customerID == customer.customerID; 
} 
@Override 
public int hashCode() { 
	return Objects.hash(customerID); 
} 
}