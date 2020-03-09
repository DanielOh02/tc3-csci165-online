// Daniel Oh
// CSCI 165
// Driver for Temperature class

public class Driver {
	
	public static void main (String[] args) {
		// create 5 temperature instance 
		Temperature[] temp = new Temperature[5];
		
		// setting temperature to each instance 
		temp[0] = new Temperature(32, Temperature.Scale.C);
		temp[1] = new Temperature(0, Temperature.Scale.C);
		temp[2] = new Temperature(32, Temperature.Scale.F);
		temp[3] = new Temperature(100, Temperature.Scale.F);
		temp[4] = new Temperature(-132, Temperature.Scale.F);
		
		for (Temperature x : temp) {
			System.out.println(x.toString());
		}
		
		// compare 2 temperature
				System.out.println(temp[1].equals(temp[2]));
				System.out.println(temp[0].equals(temp[2]));
				
		// convert F to C 
		temp[3].getDegreesC();
		System.out.println(temp[3].toString());
		
		// convert C to F 
		temp[0].getDegreesF();
		System.out.println(temp[0].toString());
		
		// reset values in temp[0]
		temp[0].setBoth(-40, Temperature.Scale.C);
		System.out.println(temp[0].toString());
		
		
		// testing the compare function
		System.out.println(temp[0].compareTo(temp[3]));
		System.out.println(temp[1].compareTo(temp[2]));
		System.out.println(temp[3].compareTo(temp[4]));
		
			
		
		
	
		
		
	} // end of main 
}
