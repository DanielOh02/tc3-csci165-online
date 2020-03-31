// Daniel Oh
// CSCI 165
// module 5 discussion

public class Customer {

		private String firstName;
		private String lastName;
		private String email;
		private Address address;
		
		
		public Customer() {};
		
		public Customer(String firstName, String lastName, String email, Address address) {
			setName(firstName, lastName);
			setEmail(email);
			setAddress(address);
			
		} // end of constructor 
		
		public Customer(String firstName, String lastName) {
			setName(firstName, lastName);
			
		}
		
		public Customer(Customer c) {
			
			this.firstName = c.firstName;
			this.lastName = c.lastName;
			this.email = c.email;
			this.address = c.address;
			
		} // end of copy constructor
		
		
		// setters
		
		public void setName(String first, String last) {
			firstName = first;
			lastName = last;
			
		} // end of set name
		
		public void setEmail (String email) {
			this.email = email;
			
		} // end of set email
		
		public void setAddress(Address a) {
			// fix privacy leak by creating copy
			address = new Address(a);
			// address = a;
			
		} // end of set address
		
		// getter 
		
		public String getName() {
			return firstName + " " + lastName;
			
		} // end of get Name
		
		public String getEmail() {
			return email;
			
		} // end of get Email
		
		public Address getAddress() {
			// prevent privacy leak
			Address add = new Address(this.address);
			return add;
			
		} // end of get Address 
		
		public String toString() {
			
			String addressString = address == null ? null : address.toString();
			
			return String.format("Name: %s\nEmails: %s\nAddress: %s", getName(), getEmail(), addressString);
		} // end of toString 
		
		public boolean equals(Customer c) {
			return this.firstName.equals(c.firstName) &&
				   this.lastName.equals(c.lastName)   &&
				   this.email.equals(c.email)         &&
				   this.address == null ? null : this.address.equals(c.address); 
			
		} // end of equals

} // end of class 
