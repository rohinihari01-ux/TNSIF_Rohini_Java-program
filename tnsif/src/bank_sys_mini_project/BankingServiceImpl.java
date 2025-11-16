package bank_sys_mini_project;
import java.util.*; 
import java.util.concurrent.atomic.AtomicInteger; 
import java.util.stream.Collectors; 
	public class BankingServiceImpl implements BankingService { 
		private final Map<Integer, Customer> customers = new HashMap<>(); 
		private final Map<Integer, Account> accounts = new HashMap<>(); 
		private final Map<Integer, Transaction> transactions = new HashMap<>(); 
		private final Map<Integer, Beneficiary> beneficiaries = new HashMap<>(); 
// atomic counters for auto ID generation if desired 
		private final AtomicInteger transactionIdCounter = new AtomicInteger(1); 
@Override 
	public void addCustomer(Customer customer) { 
		customers.put(customer.getCustomerID(), customer); 
} 
@Override 
	public void addAccount(Account account) { 
		if (!customers.containsKey(account.getCustomerID())) { 
			throw new IllegalArgumentException("Customer with ID " + account.getCustomerID() + " does not exist."); 
} 
		accounts.put(account.getAccountID(), account); 
} 
int tid;
@Override 
public void addTransaction(Transaction transaction) { 
  tid = transaction.getTransactionID(); 
// if user passed 0 as ID, assign auto id 
  if (tid == 0) { 
	  tid = transactionIdCounter.getAndIncrement(); 
	  transaction.setTransactionID(tid); 
} else { 
// ensure counter stays ahead 
	  transactionIdCounter.updateAndGet(cur -> Math.max(cur, tid + 1)); 
} 
 Account acc = accounts.get(transaction.getAccountID()); 
  if (acc == null) { 
	  throw new IllegalArgumentException("Account " + transaction.getAccountID() + " not found."); 
} 
  String type = transaction.getType().toLowerCase(); 
  double amount = transaction.getAmount(); 
  switch (type) { 
  case "deposit": 
	  acc.setBalance(acc.getBalance() + amount); 
	  break; 
  case "withdrawal": 
  case "withdraw": 
	  if (acc.getBalance() < amount) { 
		  throw new IllegalArgumentException("Insufficient balance for withdrawal."); }
acc.setBalance(acc.getBalance() - amount); 
break; 
case "transfer": 
Integer targetId = transaction.getTargetAccountID(); 
	if (targetId == null) throw new IllegalArgumentException("Transfer requires target account id."); 
Account target = accounts.get(targetId); 
	if (target == null) throw new IllegalArgumentException("Target account " + targetId + " not found."); 
	if (acc.getBalance() < amount) throw new IllegalArgumentException("Insufficient balance for transfer."); 
acc.setBalance(acc.getBalance() - amount); 
target.setBalance(target.getBalance() + amount); 
break; 
default: 
throw new IllegalArgumentException("Unknown transaction type: " + transaction.getType()); 
} 
transactions.put(transaction.getTransactionID(), transaction); 
} 
@Override 
public void addBeneficiary(Beneficiary beneficiary) { 
	if (!customers.containsKey(beneficiary.getCustomerID())) { 
		throw new IllegalArgumentException("Customer with ID " + beneficiary.getCustomerID() + " does not exist."); 
} 
beneficiaries.put(beneficiary.getBeneficiaryID(), beneficiary); 
} 
@Override 
public Customer findCustomerById(int id) { return customers.get(id); } 
@Override 
public Account findAccountById(int id) { return accounts.get(id); } 
@Override 
public Transaction findTransactionById(int id) { return transactions.get(id); } 
@Override 
public Beneficiary findBeneficiaryById(int id) { return beneficiaries.get(id); } 
@Override 
public List<Account> getAccountsByCustomerId(int customerId) { 
	return accounts.values().stream() .filter(a -> a.getCustomerID() == customerId) .collect(Collectors.toList()); } 
@Override 
public List<Transaction> getTransactionsByAccountId(int accountId) { 
	return transactions.values().stream() .filter(t -> t.getAccountID() == accountId || (t.getTargetAccountID() != null && t.getTargetAccountID() == accountId)) .collect(Collectors.toList()); 
} 
@Override 
public List<Beneficiary> getBeneficiariesByCustomerId(int customerId) { 
	return beneficiaries.values().stream() .filter(b -> b.getCustomerID() == customerId) .collect(Collectors.toList()); 
} 
@Override 
public Collection<Account> getAllAccounts() { return accounts.values(); } 
@Override 
public Collection<Customer> getAllCustomers() { return customers.values(); } 
@Override 
public Collection<Transaction> getAllTransactions() { return transactions.values(); } 
@Override 
public Collection<Beneficiary> getAllBeneficiaries() { return beneficiaries.values(); } 
} 
