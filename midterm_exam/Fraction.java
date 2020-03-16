// Daniel Oh
// CSCI 165
// Mid term

public class Fraction {

	private int numerator = 1;
	private int denominator = 1;
		
	
	// constructors
	public Fraction() {}
	
	public Fraction(int num, int den) {
		
		setNumerator(num);
		setDenominator(den);
		
	} // end of overloaded constructor 
	
	public Fraction(Fraction f) {
		this.numerator = f.getNumerator();
		this.denominator = f.getDenominator();
		
	}
	
	
	// mutators
	public void setDenominator(int num) {
		if (num != 0)
			denominator = Math.abs(num);
			
	} // end of set Denominator 
	
	public void setNumerator(int num) {
		if (num != 0)
		 numerator = Math.abs(num);
		 	 
	} // end of set Numerator
	
	public int getDenominator() {
		return denominator;
		
	} // end of get denominator
	
	public int getNumerator() {
		return numerator;
		
	} // end of  get Numerator
	
	
	// methods
	public double toDecimal() {
		return (double) numerator / (double) denominator;
		
		
	} // end of to Decimal
	
	private int gcd(int num, int den) {	
		int gcd = 0;
		// check every single possible number (not the fastest but it works)
		for(int i = num; i > 0; i--) {
			if ((num % i == 0) && (den % i == 0)) {
				gcd = i;
				break;
			} // end of if
		} // end of for loop
		
		return gcd;
		
		
	} // end of greatest common divisor 
	
	public void reduce() {
		int gcd = (gcd(numerator, denominator));
		numerator = numerator / gcd;
		denominator = denominator /gcd;
		
	} // end of reduce
		
	private int lcm(int den1, int den2) {
		
		int lcm;
		
		// find the largest number
		// if the condition is true then den1, if not den2 
		lcm = (den1 > den2) ? den1 : den2;
		
		// find the lcm
		// this also just tries every single number (not the fastest but it works)
		while (true) {
			if (lcm % den1 == 0 && lcm % den2 == 0)
				break;
			lcm++;
		}
		
		return lcm;
		
	} // end of least common multiple 
	
	public Fraction add(Fraction f) {
		
		// made variables so I don't have to type a long string every time
		int num1 = numerator;
		int den1 = denominator;
		int num2 = f.getNumerator();
		int den2 = f.getDenominator();
		
		
		int lcm = lcm(den1, den2);
		
		// multiples and converting it to the same denominator
		int m1 = lcm / den1;
		num1 =  m1 * num1;
		den1 =  m1 * den1;
		
		// multiples and converting it to the same denominator
		int m2 = lcm / den2;
		num2 = m2 * num2;
		den2 = m2 * den2;
		
		// adding
		Fraction add = new Fraction(num1 + num2, den1); // denominator don't change
		add.reduce();
		
		
		return add;
		
		
	} // end of add
	
	public Fraction subtract(Fraction f) {
		// same with add method but just subtracting  
		int num1 = numerator;
		int den1 = denominator;
		int num2 = f.getNumerator();
		int den2 = f.getDenominator();
		
		
		int lcm = lcm(den1, den2);
		
		// multiples and converting it to the same denominator
		int m1 = lcm / den1;
		num1 =  m1 * num1;
		den1 =  m1 * den1;
		
		// multiples and converting it to the same denominator
		int m2 = lcm / den2;
		num2 = m2 * num2;
		den2 = m2 * den2;
		
		// subtracting
		Fraction sub = new Fraction(num1 - num2, den1); 
		sub.reduce();
		
		
		return sub;
		
		
		
	} // end of subtract
	
	public Fraction multiply(Fraction f) {
		
		Fraction mult = new Fraction(numerator * f.getNumerator(), denominator * f.getDenominator());
		mult.reduce(); // the majority of the j unite test were reduced so I reduced it
		
		return mult;
		
	} // end of multiply
	
	public boolean equals(Fraction f) {
		// clone them so it does not mutate the original copys 
		Fraction f1 = new Fraction(this);
		Fraction f2 = new Fraction(f);
		// reduce them 
		f1.reduce();
		f2.reduce();
		
		
		return f1.getNumerator() == f2.getNumerator() && f1.getDenominator() == f2.getDenominator();
		
	} // end of equals
	
	public int compareTo(Fraction f) {
		// simple if you convert it to Decimals
		double num1 = this.toDecimal();
		double num2 = f.toDecimal();
		
		if (num1 > num2)
			return 1;
		else if (num1 < num2)
			return -1;
		else
			return 0;			
	
		 
		
		
	} // end of compare to 
	
	public String toString() {	
			
		int num ;
		int whole ;
		
		// check to see if its a improper fraction
		if (numerator >= denominator) {
			// check if the number is a whole number
			if (numerator % denominator == 0) {
				
				whole = numerator / denominator;
				// converting int to String
				String number = String.format("%d", whole);
				
				return  number;
				
			} else {
				
			// so it prevents unwanted mutation to the fraction
			Fraction f = new Fraction (this);
			
			
			
			f.reduce(); // looks better reduced
			whole = (int) Math.floor(f.getNumerator() / f.getDenominator());
			num = f.getNumerator() % f.getDenominator();
			
			return whole + " " + num + "/" + f.getDenominator();	
				
				
			} // end of if and else block 
			
		} // end of toString
			
		// return normal fraction
		return numerator + "/" + denominator;
		
	} // end of to string 
	
} // end of class
