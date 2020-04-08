// Daniel Oh
// CSCI 165
// module 5 PA
public class Account {
	
	private String accountID;
	
	private Customer customer;
	
	private double balance = 0.0;
	
	private double creditLimit = 0.0;
	
	private Date date;
	
	private double discountLevel = 0.0;
	
	public Account(Customer customer){
		this.customer = new Customer(customer);
		
	}
	
	public Account(Customer customer, double balance, double creditLimit, Date date) {
		
		this.customer = new Customer(customer);
		this.balance = balance;
		this.creditLimit = creditLimit;
		this.date = new Date(date);
		this.accountID = makeID(this.customer);
	
	}
	
	public Account(Account a) {
		this.accountID = a.accountID;
		this.customer = new Customer(a.customer);
		this.balance = a.balance;
		this.creditLimit = a.creditLimit;
		this.date = new Date(a.date);
		this.discountLevel = a.discountLevel;
		
	}
	
	private String makeID(Customer customer) {
		
		// replaces all the vowels and space with void 
		String id = customer.getName().replaceAll("[AEIOUaeiou\\s]", "").toUpperCase();
		id += date.toString().replaceAll("/", "");
		
		return id;
	} // end of make ID
	
	public Customer getCustomer()	{
		// prevent privacy leak
		Customer cus = new Customer(this.customer);
		return cus;
		
	} // end of get customer
	
	public double getBalance() {
		
		return balance;
		
	} // end of get balance
	
	public double getCreditLimit() {
		
		return creditLimit;
	} // end of get credit limit
	
	public void setBalance(double sum) {
		
		balance = sum;
	} // end of set balance
	
	public void setCreditLimit(double limit) {
		
		creditLimit = limit;
	} // end of set credit limit
	
	public boolean equals(Account a) {
		return this.accountID.equals(a.accountID)   &&
		       this.customer.equals(a.customer) 	&&
		       this.balance == a.balance			&&
		       this.creditLimit == a.creditLimit	&&
		       this.date.equals(a.date)				&&
		       this.discountLevel == a.discountLevel;    
			
		
	} //end of equals
	
	public int compareTo(Account a) {
		if (this.balance > a.balance) 
			return 1;
		else if (this.balance < a.balance)
			return -1;
		else
			return 0;
		
	} // end of compare to 
	
	public String toString() {
		
		return String.format(
				"Account ID:....%s"
		    + "\nCustomer:......%s"
        	+ "\nBalance:.......$%.2f"
			+ "\nCredit Limit:..$%.2f"
			+ "\nDate Created:..%s"
			+ "\nDiscountLevel:.%.2f"
			,accountID, customer.toString(), balance, creditLimit, date.toString(), discountLevel);
	} // end of to string 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end of class
