package bank_sys_mini_project;

import java.util.List; 
import java.util.Scanner; 
	public class BankingSystemApp { 
	private static final BankingService bankingService = new BankingServiceImpl(); 
	private static final Scanner scanner = new Scanner(System.in); 
	public static void main(String[] args) { seedSampleData(); // optional - comment out if you want blank start 
		boolean running = true; 
		while (running) { 
		printMenu(); 
		System.out.print("Enter your choice : "); 
		String choice = scanner.nextLine().trim(); 
		switch (choice) { 
		case "1": addCustomer(); break; 
		case "2": addAccount(); break; 
		case "3": addBeneficiary(); break; 
		case "4": addTransactionMenu(); break; 
		case "5": findCustomerById(); break; 
		case "6": listAccountsByCustomer(); break; 
		case "7": listTransactionsByAccount(); break; 
		case "8": listBeneficiariesByCustomer(); break; 
		case "9": running = false; System.out.println("Thank you!"); break; 
		default: System.out.println("Invalid choice. Try again."); break; 
		} 
		System.out.println(); 
		} 
		scanner.close(); 
		} 
private static void printMenu() { 
		System.out.println("Banking System"); 
		System.out.println("1. Add Customers"); 
		System.out.println("2. Add Accounts"); 
		System.out.println("3. Add Beneficiary"); 
		System.out.println("4. Add Transaction"); 
		System.out.println("5. Find Customer by Id"); 
		System.out.println("6. List all Accounts of specific Customer"); 
		System.out.println("7. List all transactions of specific Account"); 
		System.out.println("8. List all beneficiaries of specific customer"); 
		System.out.println("9. Exit"); 
		} 
private static void addCustomer() { 
	try { 
		System.out.println("Enter Customer Details"); 
		System.out.print("Customer Id : "); 
		int id = Integer.parseInt(scanner.nextLine().trim()); 
		System.out.print("Name : "); 
		String name = scanner.nextLine().trim(); 
		System.out.print("Address : "); 
		String addr = scanner.nextLine().trim(); 
		System.out.print("Contact No. : "); 
		String contact = scanner.nextLine().trim(); 
		Customer c = new Customer(id, name, addr, contact); 
		bankingService.addCustomer(c); 
		System.out.println("Customer added: " + c); 
	} catch (Exception e) { 
		System.out.println("Error adding customer: " + e.getMessage()); 
} 
} 
private static void addAccount() { 
	try { 
		System.out.println("Enter Account Details"); 
		System.out.print("Account Id : "); 
		int id = Integer.parseInt(scanner.nextLine().trim()); 
		System.out.print("Customer Id : "); 
		int custId = Integer.parseInt(scanner.nextLine().trim()); 
		System.out.print("Account Type Saving/Current : "); 
		String type = scanner.nextLine().trim(); 
		System.out.print("Balance : "); 
		double bal = Double.parseDouble(scanner.nextLine().trim()); 
		Account a = new Account(id, custId, type, bal); 
		bankingService.addAccount(a); 
		System.out.println("Account added: " + a); 
	} catch (Exception e) { 
		System.out.println("Error adding account: " + e.getMessage()); 
} 
} 
private static void addBeneficiary() { 
	try { 
		System.out.println("Enter Beneficiary Details"); 
		System.out.print("Beneficiary Id : "); 
		int id = Integer.parseInt(scanner.nextLine().trim()); 
		System.out.print("Customer Id : "); 
		int custId = Integer.parseInt(scanner.nextLine().trim()); 
		System.out.print("Beneficiary Name : "); 
		String name = scanner.nextLine().trim(); 
		System.out.print("Beneficiary Account No. : "); 
		String accNo = scanner.nextLine().trim(); 
		System.out.print("Beneficiary Bank details : "); 
		String bank = scanner.nextLine().trim(); 
		Beneficiary b = new Beneficiary(id, custId, name, accNo, bank); 
		bankingService.addBeneficiary(b); 
		System.out.println("Beneficiary added: " + b); 
	} catch (Exception e) { 
		System.out.println("Error adding beneficiary: " + e.getMessage()); 
} 
} 
private static void addTransactionMenu() { 
	try { 
		System.out.println("Enter Transaction Details"); 
		System.out.print("Account Id : "); 
		int accId = Integer.parseInt(scanner.nextLine().trim()); 
		System.out.print("Type (Deposit/Withdrawal/Transfer) : "); 
		String type = scanner.nextLine().trim(); 
		Integer target = null; 
		if (type.equalsIgnoreCase("transfer")) { 
		System.out.print("Target Account Id : "); 
		target = Integer.parseInt(scanner.nextLine().trim()); 
		} 
		System.out.print("Amount : "); 
		double amt = Double.parseDouble(scanner.nextLine().trim()); 
		// transaction id 0 -> let service auto assign 
		Transaction t = new Transaction(0, accId, type, amt, target); 
		bankingService.addTransaction(t); 
		System.out.println("Transaction completed: " + t); 
	} catch (Exception e) { 
		System.out.println("Transaction failed: " + e.getMessage()); 
} 
} 
private static void findCustomerById() { 
	try { 
		System.out.print("Customer Id : "); 
		int id = Integer.parseInt(scanner.nextLine().trim()); 
		Customer c = bankingService.findCustomerById(id); 
		if (c == null) System.out.println("Customer not found."); 
		else System.out.println("Customer: " + c); 
	} catch (Exception e) { 
		System.out.println("Error: " + e.getMessage()); 
} 
} 
private static void listAccountsByCustomer() { 
	try { 
		System.out.print("Customer Id : "); 
		int id = Integer.parseInt(scanner.nextLine().trim()); 
		List<Account> accounts = bankingService.getAccountsByCustomerId(id); 
		System.out.println("Accounts for Customer ID :" + id); 
		if (accounts.isEmpty()) System.out.println("No accounts found."); 
		else accounts.forEach(a -> System.out.println(a)); 
	} catch (Exception e) { 
		System.out.println("Error: " + e.getMessage()); 
} 
} 
private static void listTransactionsByAccount() { 
	try { 
		System.out.print("Account Id : "); 
		int id = Integer.parseInt(scanner.nextLine().trim()); 
		List<Transaction> txs = bankingService.getTransactionsByAccountId(id); 
		System.out.println("Transactions for Account ID :" + id); 
		if (txs.isEmpty()) System.out.println("No transactions found."); 
		else txs.forEach(t -> System.out.println(t)); 
} catch (Exception e) { 
		System.out.println("Error: " + e.getMessage()); 
} 
} 
private static void listBeneficiariesByCustomer() { 
	try { 
		System.out.print("Customer Id : "); 
		int id = Integer.parseInt(scanner.nextLine().trim()); 
		List<Beneficiary> bs = bankingService.getBeneficiariesByCustomerId(id); 
		System.out.println("Beneficiaries for Customer ID :" + id); 
		if (bs.isEmpty()) System.out.println("No beneficiaries found."); 
		else bs.forEach(b -> System.out.println(b)); 
} catch (Exception e) { 
		System.out.println("Error: " + e.getMessage()); 
} 
} 
// optional seed - shows sample usage from case study 
private static void seedSampleData() { 
	try { 
		Customer c1 = new Customer(1, "Aniket", "Pune", "7868678899"); 
		Customer c2 = new Customer(2, "Nikhil", "Mumbai", "7878330331"); 
		bankingService.addCustomer(c1); 
		bankingService.addCustomer(c2); 
		Account a1 = new Account(101, 1, "Saving", 70000.0); 
		Account a2 = new Account(102, 2, "Current", 80000.0); 
		bankingService.addAccount(a1); 
		bankingService.addAccount(a2); 
		Beneficiary b1 = new Beneficiary(1001, 1, "Mahesh", "6722212", "SBI"); 
		bankingService.addBeneficiary(b1); 
} catch (Exception e) { 
		System.out.println("Seed data error: " + e.getMessage()); 
} 
} 
} 