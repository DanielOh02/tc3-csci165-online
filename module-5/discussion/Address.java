// Daniel Oh
// CSCI 165
// module 5 discussion

public class Address {
	
	private String street;
	private String city;
	private String state;
	private int zip;
	
	
	public Address () {} 
	
	// overloaded constructor
	public Address (String street, int zip) {
		setStreet(street);
		setZip(zip);
		
	} // end of overloaded constructor
	
	public Address (Address a) {
		this.street = a.getStreet();
		this.zip = a.getZip();
		
		
	} // end of copy
	
	// setters
	
	public void setStreet(String street) {
		this.street = street;
		
	} // end of set street 

	
	public void setZip(int zip) {
		this.zip = zip;
		
	} // end of set zip code
	
	
	// getters 
	
	public String getStreet() {
		return street;
		
	} // get street 
	
	public int getZip() {
		return zip;
	
	} // end of get zip
	
	public String getState() {
		return state;
				
	} // end of get State
	
	public String getCity() {
		return city;
		
	} // end of get City 
	
	public boolean equals(Address a) {
		
		return this.street.equals(a.getStreet()) &&
			   this.zip == a.getZip();
				
		
	} // end of equals 
	
	public String toString() {
		
		
		return String.format("Street: %s Zip: %d", street, zip);
	} // end of to String
	
	
	
	
} // end of class 