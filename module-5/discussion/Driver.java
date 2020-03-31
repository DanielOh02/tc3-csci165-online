// Daniel Oh
// CSCI 165
// module 5 discussion


public class Driver {
	
	public static void main (String args[]) {
		
		// create object address
		Address add1 = new Address("Parkview Dr.", 97035);
		
		Customer cus1 = new Customer("Daniel", "Oh", "test@example.com", add1);	
		
		System.out.println("Original: ");
		System.out.println(cus1);
		
		// maintained access to add1 after passing it through the costumer constructor 
		add1.setZip(53021);
		System.out.println("\nData leak using setmethods(): ");
		System.out.println(cus1);
		
		
		// granted access by get address()
		System.out.println("\nData leak using getAddress(): ");
		Address add2 = cus1.getAddress();
		
		add2.setZip(35642);
		add2.setStreet("LEAKS");
		
		System.out.println(cus1);
		
		
	
		
	} // end of main 	
} // end of class 
