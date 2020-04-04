import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random; 

// Daniel Oh
// CSCI 165
// module 5 Lab
public class Driver {
	
	
	
	public static void main (String args[]) {
		
		Customer[] customerList = new Customer[1000];
		
		String first;
		String last;
		String email;
		String stAddress;
		String line;
		int index = 0;
		int    zipCode;
		Address address;

		
		try {
			
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
		
		
		// iterate through all the customer until correct commend 
		int counter = 0;
		String junk = "";
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("type: 'exit' to stop the list or press enter to countiue");	
		
		while (counter != 1000) {
			if (junk.equals("exit"))
				break;
			else {
				System.out.println("Customer #" + (counter+1));
				System.out.println(customerList[counter]);
				junk = scan.nextLine();
			counter++;
				
			}
		} // end of while loop
		
		
		// account stuff ==========================================
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
		
		// iterate through all the account objects until correct commend 
		// reset counter
		counter = 0;
		junk = "";
				
		System.out.println("type: 'exit' to stop the list or press enter to countiue");	
			
		while (counter != 1000) {
			if (junk.equals("exit"))
				break;
			else {
				System.out.println("Account #" + (counter + 1));
				System.out.println(accountList[counter]);
				junk = scan.nextLine();
				counter++;
					
					} // end of else
				} // end of while loop
		
		
		
	} // end of main 
} // end of class 
