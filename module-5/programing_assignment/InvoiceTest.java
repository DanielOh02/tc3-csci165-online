import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Daniel Oh
// CSCI 165
// module 5 PA

class InvoiceTest {

	@Test
	void testGetAmountDue() {
		Date date = new Date (1, 13, 2002);
		Address add = new Address("4925 Parkview Dr.", 97035); 
		Customer cus = new Customer("Daniel", "Oh" , "DO020@mail.com", add);
		Account acc = new Account(cus, 150, 70, date);
		System.out.println(acc);
		
		date.setMonth(6);
		add = new Address("112 sage place", 14850);
		cus = new Customer ("David", "Oh", "test@gmail.com", add);
		Account acc1 = new Account(cus, 150, 4, date);
		System.out.println();
		System.out.println(acc);
		
		
		
		Product pro1 = new Product ("name 1", "test1", 5.99);
		Product pro2 = new Product ("name 2", "test2", 12.57);
		Product pro3 = new Product ("name 3", "test3", 6.26);
		Product pro4 = new Product ("name 4", "test4", 23.50);
		Product pro5 = new Product ("name 5", "test5", 7.53);
		Product pro6 = new Product ("name 6", "test6", 15.23);
		Product pro7 = new Product ("name 7", "test7", 2.99);
		
		Date oD = new Date(4,7,2020);
		
		Invoice inv = new Invoice(acc, oD);
		inv.addProduct(pro1);
		inv.addProduct(pro2);
		inv.addProduct(pro3);
		inv.addProduct(pro4);
		inv.addProduct(pro5);
		inv.addProduct(pro6);
		inv.addProduct(pro7);
		
		assertEquals(inv.getAmountDue(), 74.07);
		
		Invoice inv1= new Invoice(acc1, oD);
		
		
		inv1.addProduct(pro2);
		inv1.addProduct(pro3);
		inv1.addProduct(pro4);
		inv1.addProduct(pro5);
		
		assertEquals(inv1.getAmountDue(), 49.86);
		
		Invoice inv2= new Invoice(acc1, oD);

		inv2.addProduct(pro3);
		inv2.addProduct(pro4);
		inv2.addProduct(pro1);
		inv2.addProduct(pro7);
		
		assertEquals(inv2.getAmountDue(), 38.74);
		
		Invoice inv3= new Invoice(acc1, oD);
		
		assertEquals(inv3.getAmountDue(), 0.0);
	}

	@Test
	void testCompareTo() {
		Date date = new Date (1, 13, 2002);
		Address add = new Address("4925 Parkview Dr.", 97035); 
		Customer cus = new Customer("Daniel", "Oh" , "DO020@mail.com", add);
		Account acc = new Account(cus, 150, 70, date);
		System.out.println(acc);
		
		date.setMonth(6);
		add = new Address("112 sage place", 14850);
		cus = new Customer ("David", "Oh", "test@gmail.com", add);
		Account acc1 = new Account(cus, 150, 4, date);
		System.out.println();
		System.out.println(acc);
					
		Product pro1 = new Product ("name 1", "test1", 5.99);
		Product pro2 = new Product ("name 2", "test2", 12.57);
		Product pro3 = new Product ("name 3", "test3", 6.26);
		Product pro4 = new Product ("name 4", "test4", 23.50);
		Product pro5 = new Product ("name 5", "test5", 7.53);
		Product pro6 = new Product ("name 6", "test6", 15.23);
		Product pro7 = new Product ("name 7", "test7", 2.99);
		
		Date oD = new Date(4,7,2020);
		
		Invoice inv = new Invoice(acc, oD);
		inv.addProduct(pro1);
		inv.addProduct(pro2);
		inv.addProduct(pro3);
		inv.addProduct(pro4);
		inv.addProduct(pro5);
		inv.addProduct(pro6);
		inv.addProduct(pro7);
				
		Invoice inv1= new Invoice(acc1, oD);
			
		inv1.addProduct(pro2);
		inv1.addProduct(pro3);
		inv1.addProduct(pro4);
		inv1.addProduct(pro5);
		
				
		Invoice inv2= new Invoice(acc1, oD);

		inv2.addProduct(pro3);
		inv2.addProduct(pro4);
		inv2.addProduct(pro1);
		inv2.addProduct(pro7);				
		
		Invoice inv3= new Invoice(acc1, oD);				
		
		assertEquals(inv.compareTo(inv1), 1);
		assertEquals(inv3.compareTo(inv2), -1);
		assertEquals(inv.compareTo(inv), 0);
	}

}
