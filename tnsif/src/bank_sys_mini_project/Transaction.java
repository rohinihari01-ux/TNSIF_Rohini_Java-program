package bank_sys_mini_project;

import java.time.LocalDateTime; 
import java.util.Objects; 
	public class Transaction { 
	private int transactionID; 
	private int accountID; //primary account involved 
	private String type;           // Deposit / Withdrawal / Transfer 
	private double amount; 
	private LocalDateTime timestamp; 
	private Integer targetAccountID; // optional, for transfer 
	public Transaction(int transactionID, int accountID, String type, double amount, Integer targetAccountID) { 
		this.transactionID = transactionID; 
		this.accountID = accountID; 
		this.type = type; 
		this.amount = amount; 
		this.timestamp = LocalDateTime.now(); 
		this.targetAccountID = targetAccountID; 
} 
	public int getTransactionID() { return transactionID; } 
	public void setTransactionID(int transactionID) { this.transactionID = transactionID; } 
	public int getAccountID() { return accountID; } 
	public void setAccountID(int accountID) { this.accountID = accountID; } 
	public String getType() { return type; } 
	public void setType(String type) { this.type = type; } 
	public double getAmount() { return amount; } 
	public void setAmount(double amount) { this.amount = amount; } 
	public LocalDateTime getTimestamp() { return timestamp; } 
	public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; } 
	public Integer getTargetAccountID() { return targetAccountID; } 
	public void setTargetAccountID(Integer targetAccountID) { this.targetAccountID = targetAccountID; } 
@Override 
public String toString() { 
String t = "Transaction ID: " + transactionID + ", Type: " + type + ", Amount: " + amount + ", Account ID: " + accountID + ", Timestamp: " + timestamp; 
if (targetAccountID != null) { t += ", Target Account ID: " + targetAccountID; } 
	return t; } 
@Override 
public boolean equals(Object o) { 
	if (this == o) return true; 
	if (o == null || getClass() != o.getClass()) return false; 
	Transaction that = (Transaction) o; 
	return transactionID == that.transactionID; 
} 
@Override 
public int hashCode() { 
	return Objects.hash(transactionID); 
} 
}