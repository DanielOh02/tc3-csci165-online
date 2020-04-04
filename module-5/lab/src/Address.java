import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

//Daniel Oh
//CSCI 165
//module 5 lab

public class Address {
	
	private String street;
	private String city;
	private String state;
	private int zip;
	
	public static ArrayList<ZipData> zipList = new ArrayList<ZipData>(); 
	
	private static void fillList() {
		int linenum = 1;
		int dataZip;
		String dataCity;
		String dataState;
		
		String line;
		
		try {
			
			FileReader fileReader = new FileReader("zip_code_database.csv");
			Scanner scanner = new Scanner(fileReader); 
			
			while (scanner.hasNextLine()) {
				// skips the first line which are just labels
				if(linenum != 1) {
					
					line = scanner.nextLine();
					
					String[] data = line.split(",");
					
					dataZip = Integer.parseInt(data[0]);
					dataCity = data[2];
					dataState = data[3];
					
					ZipData zD = new ZipData(dataZip, dataCity, dataState);
					
					zipList.add(zD);
					
				} else {
					
					line = scanner.nextLine();
					linenum++;
					
				} // end of else
				
			} // end of while loop
			
			scanner.close();
			
			
		} catch (FileNotFoundException fnf){
			  System.out.println("Error: File Not Found!");

			} // end of catch block
		
	} // end of fill list
	
	public static ZipData locate(int zip) {
		
		ZipData data = null;
		
		for (ZipData zd : zipList) {
			if (zd.getZip() == zip) {
				data = zd;	
				break;
			} // end of if
		} // for loop
		
		return data;
		
	} // end of locate
	
	// static block (more like a line) 
	static {fillList();}	
	
	
	public Address () {} 
	
	// overloaded constructor
	public Address (String street, int zip) {
		setStreet(street);
		setZip(zip);
		
		
	} // end of overloaded constructor
	
	public Address (Address a) {
		this.street = a.street;
		this.zip = a.zip;
		this.state = a.state;
		this.city = a.city;
		
	} // end of copy
	
	// setters
	
	public void setStreet(String street) {
		this.street = street;
		
	} // end of set street 

	
	public void setZip(int zip) {
		
		this.zip = zip;
		
		// auto automatically update city and state
		ZipData zd = Address.locate(zip);
		city = zd.getCity(); 
		state = zd.getState();
		
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
		
		return 	this.street.equals(a.street) 	&&
				this.city.equals(a.city) 		&&
				this.state.equals(a.state) 		&&
				this.zip == a.zip;
				
		
	} // end of equals 
	
	
	public String toString() {
		
		
		return String.format("%s %s %s, %d", street, city, state, zip);
	} // end of to String
	
	
	
	
} // end of class 