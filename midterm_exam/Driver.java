// Daniel Oh
// CSCI 165
// Driver for Fraction


public class Driver {
	
	public static void main (String [] args) {
	
	// arrays
	Fraction[] fraction = new Fraction [9];
	int[] numerators   = {1, 2, 3, 4, 11, 6, 7, 8, 13};
	int[] denominators = {2, 5, 4, 6, 3, 8, 21, 13, 5};
	
	// making 9 fractions 
	for (int i = 0; i < fraction.length; i++) {
		fraction[i] = new Fraction(numerators[i], denominators[i]);
	} // end of for loop
	
	int smallest = 0;
	int largest = 0;
	
	// find the largest and the smallest fraction
	for (int i = 1; i < fraction.length - 1; i++) {
		// find smallest
		if (fraction[i].compareTo(fraction[smallest]) == -1)
			smallest = i;
		
		// find largest
		if (fraction[i].compareTo(fraction[largest]) == 1)
			largest = i;
			

	} // end of for loop
	
	
	// cloning 
	Fraction clone = new Fraction(fraction[3]);
	
	
	// creating more fractions! 
	Fraction f1 = new Fraction(5, 7);
	Fraction f2 = new Fraction(8, 10);
	Fraction f3 = new Fraction(f2);
	f3.reduce();
	
	Fraction f4 = new Fraction();
	// testing setters
	f4.setNumerator(23);
	f4.setDenominator(7);
	
	Fraction f5= new Fraction(1,4); 
	Fraction f6 = new Fraction(5,20);
	
	
	//methods
	// adding
	System.out.printf("This fraction class can add two fractions together -----------------------> %s + %s = %s", f1.toString(), f2.toString(), f1.add(f2));
	// subtract
	System.out.printf("%nand also subtract two fractions, but it can never be a negative fraction -> %s - %s = %s", f1.toString(), f2.toString(), f1.subtract(f2));
	// multiply
	System.out.printf("%nand it can multiply and reduces the fracion ------------------------------> %s * %s = %s", f1.toString(), f2.toString(), f1.multiply(f2));
	// to decimal
	System.out.printf("%nit can also convert fractions into decimals ------------------------------> %s = %f",f1.toString(),f1.toDecimal());
	
	// reducing 
	System.out.printf("%n%nThis class can reduce fractions! -> %s = %s",f2.toString(), f3.toString());
	// improper fractions
	System.out.printf("%nIf the fraction is improper it returns mixed fraction to print.%n==== Demo ==== %nnumerator:  %d %ndenominator: %d %nprint = %s", f4.getNumerator(), f4.getDenominator(), f4);

	
	
	// array
	System.out.printf("%n%nThe smallest fraction in the array is: %s", fraction[smallest].toString());
	System.out.printf("%nThe largest fraction in the array is : %s", fraction[largest].toString());
	
	
	// clone
	System.out.printf("%n%nThis fraction -> %s was cloned from the %drd fraction -> %s", clone.toString(),3 ,fraction[3].toString());
	System.out.printf("%n'clone' == 'original'  : %b ", clone == fraction[3]);
	System.out.printf("%noriginal.equals(clone) : %b ", fraction[3].equals(clone));
	
	// equals
	System.out.println("\n\nTesting if the equals method work");
	System.out.printf("%s = %s: %b",f5 , f6, f5.equals(f6));
	System.out.printf("%n%s = %s: %b",f3 , f1, f3.equals(f1));
	
	// compare 
	System.out.println("\n\nTesting if the compareTo method work");
	System.out.printf("%s compared to %s: %d",f3 , f6, f3.compareTo(f6));
	System.out.printf("%n%s compared to %s: %d",f5 , f6, f5.compareTo(f6));
	System.out.printf("%n%s compared to %s: %d",f5 , f2, f5.compareTo(f2));
	
	
	
	} // end of main 
} // end of class
