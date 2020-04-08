import java.util.ArrayList;

// Daniel Oh
// CSCI 165
// Programming assignment for module 5


public class Invoice {
	
	private String invoiceNumber;
	private Account account;
	private Date orderDate;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	// constructors 
	public Invoice() {}
	
	public Invoice(Account acct, Date date) {
		account = new Account(acct);
	 
		orderDate = new Date(date);  
		
		invoiceNumber = MakeInvoiceNum(account, date);
	} 
	
	private String MakeInvoiceNum(Account acct, Date date) {
		String ID = acct.getCustomer().getName();
		ID += date.toString();	
		return ID.replaceAll("[/\\s]", "");
	}
	
	public Account getAccount() {
		// prevent privacy leak
		Account acct = new Account(this.account);
		return acct;
		
	} // end of get Account
	
	public Date getDate() {
		// prevent privacy leak
		return new Date(orderDate);
	} // end of get Date
	
	public double getAmountDue() {
		double total = 0.0;
		for (Product x : products) {
			total += x.getPrice();
			
		} 
		
		return total;
	} // end of get AmountDue
	
	public void addProduct(Product p) {
		products.add(p);
		
	} // end of add product
	
	public int compareTo(Invoice i) {
		if (getAmountDue() > i.getAmountDue()) 
			return 1;
		else if (getAmountDue() < i.getAmountDue())
			return -1;
		else 
			return 0;
		
	} // end of compareTo 
	
	public String toString() {
		String strg = String.format("Invoice Number: %s"
						 + "\n========== Account =========="
						 + "\n%s\n============================="
						 + "\nOrder Date: %s"
						 + "\n========= Products ==========", invoiceNumber, account.toString(), orderDate.toString());
		
		for (Product x : products) 
			strg += "\n" + x.toString();
		
		strg += String.format("\n============================="
							+ "\nTotal Price: $%.2f",  getAmountDue()); 
		return strg;
		
	} // end of to String 
	
} // end of class 



