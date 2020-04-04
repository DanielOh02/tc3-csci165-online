// Daniel Oh
// CSCI 165
// module 5 lab 

public class ZipData {

	private int zip;
	private String city;
	private String state;

	
	public ZipData(int zip, String city, String state) {
		
		this.zip = zip;
		this.city = city;
		this.state = state;
		
		
	} // end of overloaded 
	
	public int getZip() {
		return zip;
		
	} // end of zip 
	
	public String getCity() {
		return city;
		
	} // end of get city  
	
	public String getState() {
		return state;
		
	} // end of get state
	
	public boolean equals(ZipData zd) {
		return this.zip == zd.zip          &&
			   this.state.equals(zd.state) &&
			   this.city.equals(zd.city);
		
	} // end of equals
	
	public String toString() {
		
		return String.format("zip: %d, city: %s, state: %s", zip, city, state); 
		
	} // end of to String 
	
	
} // end of class
