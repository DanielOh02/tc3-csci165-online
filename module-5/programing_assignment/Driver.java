import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random; 

// Daniel Oh
// CSCI 165
// module 5 PA

public class Driver {
	
	public static void main (String args[]) {
		
		// making and fill customer list ===================================================================
		Customer[] customerList = new Customer[1000];
		
		int index = 0;
		
		try {
			
			String first;
			String last;
			String email;
			String stAddress;
			String line;
		
			int zipCode;
			Address address;

			FileReader fileReader = new FileReader("customers.txt");
			Scanner scanner = new Scanner(fileReader); 
			
			while (scanner.hasNextLine()) {
					line = scanner.nextLine();
					String[] data = line.split("\t");
					
					first = data[0];
					last = data[1];
					email = data[2];
					stAddress = data[3] + " " + data[4] + " " + data[5];
					zipCode = Integer.parseInt(data[6]);
					
					
					// creates new address and customer instances
					address = new Address(stAddress, zipCode);
					
					customerList[index] = new Customer(first, last, email, address);
					index++;
					
					
				
			} // end of while loop
			
			scanner.close();
			
			
		} catch (FileNotFoundException fnf){
			System.out.println("Error: File Not Found!");

		} // end of catch block
		
		
		
		// making and filling account object  ==========================================================================================
		//reset index 
		index = 0;
		Date date;
		int month;
		int day;
		int year;
		double balance;
		double limit;
		
		
		Account[] accountList = new Account[1000];
		
		// filling the account objects. 
		while(index < 1000) {
			Random rand = new Random();
			month  = rand.nextInt(12);
			day = rand.nextInt(28);
			year = 2020 - (rand.nextInt(20));
			
			date = new Date(month, day, year);
			
			balance = rand.nextInt(100000);
			limit   = balance / 2;
			
			accountList[index] = new Account(customerList[index], balance, limit, date);
			index++;
			
		} // end of while loop 
		
		// making and fill products in objects =================================================================
		
				Product[] productList = new Product[1000];
		
		try {
				
				FileReader filereader = new FileReader("products.txt");
				Scanner scanner = new Scanner(filereader); 
				
				String line;
				String name;
				String desc;
				double price;
				index = 0;
				
				while (scanner.hasNextLine()) {
						line = scanner.nextLine();
						String[] data = line.split("\t");
						
						name = data[0];
						desc = data[1];
						price = Double.parseDouble(data[2]);
						
						
						productList[index] = new Product(name, desc, price);
						index++;
					
				} // end of while loop
				
				scanner.close();
				
				
		} catch (FileNotFoundException fnf){
			System.out.println("Error: File Not Found!");
	
		} // end of catch block
		
		
			
		// making 100 invoice objects ============================================================================
		
		// creating invoice stuff 
		Invoice[] invoiceList = new Invoice[100];
		index = 0;
		int accountIndex;
		int productIndex;
		int numOI; // number of items
		int count; 
		Random rand = new Random();
		while (index < 100) {
			
			count = 0; 
			// chooses which account
			accountIndex = rand.nextInt(999);
			// decides how many item in invoice
			// +1 so there is no chance of having zero items. 
			numOI = rand.nextInt(19) + 1;
			
			invoiceList[index] = new Invoice(accountList[accountIndex], new Date(4,8,2020));
			while (count <= numOI) {
				productIndex = rand.nextInt(999);
				invoiceList[index].addProduct(productList[productIndex]);
				count++;
			} // end of nested while loop
			
			index++;
		} // end of while loop
		
		// printing out all the invoices with command to stop and continue =========================================
		// iterate through all the customer until correct commend 
		int counter = 0;
		String junk = "";
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("type: 'exit' to stop the list or press enter to countiue");	
		
		while (counter != 100) {
			if (junk.equals("exit"))
				break;
			else {
				System.out.println("Invoice #" + (counter+1));
				System.out.println(invoiceList[counter]);
				junk = scan.nextLine();
			counter++;
			
			} // end of if and else 
				
		} // end of while 			
			
	} // end of main 
} // end of class 
