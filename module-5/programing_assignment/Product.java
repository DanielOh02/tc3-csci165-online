// Daniel Oh
// CSCI 165
// Programming assignment for module 5

public class Product {
	
	private String name;
	private String description;
	private double price;
	
	public Product() {}
	
	public Product(String name, String desc, double price) {
		setName(name);
		this.description = desc;
		setPrice(price);
		
		
	} 
	
	// copy constructor
	
	public void setName(String name) {
		this.name = name;
		
	} // end of set name
	
	public String getName() {
		
		return name;
	} // end of get name
	
	public void setPrice(double price) {
		
		this.price = price;
	} // end of set price 
	
	public double getPrice() {
		
		return price;
	} // end of get Price
	
	public boolean equals(Product p) {
		
		return this.name.equals(p.name) &&
			   this.description.equals(p.description) &&
			   this.price == p.price;
	} // end of equals 
	
	public String toString() {
		
		return String.format("Product: %s, Description: %s, Price: $%.2f", name, description, price);
	} // end of to String 
} // end of class
