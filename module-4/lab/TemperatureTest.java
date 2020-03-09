// Daniel Oh
// CSCI 165
// Junit test for temperature 

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureTest {

	@Test
	void testTemperature() {
		Temperature temp = new Temperature();
		
		String test = temp.toString();
		assertEquals(test, "0.0 Degrees Celsius"); 
	}

	@Test
	void testTemperatureIntScale() {
		Temperature temp = new Temperature(75, Temperature.Scale.F);
		
		String test = temp.toString();
		assertEquals(test, "75.0 Degrees Fahrenheit");
	}

	@Test
	void testSetTemp() {
		// valid 
		Temperature temp = new Temperature(75, Temperature.Scale.F);
		temp.setTemp(100);
		
		String test = temp.toString();
		assertEquals(test, "100.0 Degrees Fahrenheit");
		
		temp.setTemp(-35.52);
		test = temp.toString();
		assertEquals(test, "-35.52 Degrees Fahrenheit");
		
		// not valid input 
		temp.setTemp(300);
		test = temp.toString();
		assertEquals(test, "0.0 Degrees Fahrenheit");
		
		temp.setTemp(-250);
		test = temp.toString();
		assertEquals(test, "0.0 Degrees Fahrenheit");
	}
	
	@Test
	void testSetScale() {
		// valid 
		Temperature temp = new Temperature(75, Temperature.Scale.F);
		temp.setScale(Temperature.Scale.C);
		
		String test = temp.toString();
		assertEquals(test, "75.0 Degrees Celsius");
		
		
	}

	@Test
	void testSetBoth() {
		// valid 
		Temperature temp = new Temperature(75, Temperature.Scale.F);
		temp.setBoth(35, Temperature.Scale.C);
		String test = temp.toString();
		assertEquals(test, "35.0 Degrees Celsius"); 
		
		temp.setBoth(-3.52, Temperature.Scale.F);
		test = temp.toString();
		assertEquals(test, "-3.52 Degrees Fahrenheit"); 
		
		// not valid values 
		temp.setBoth(-250, Temperature.Scale.C);
		test = temp.toString();
		assertEquals(test, "0.0 Degrees Celsius"); 
		
		temp.setBoth(350, Temperature.Scale.F);
		test = temp.toString();
		assertEquals(test, "0.0 Degrees Fahrenheit"); 
	}

	@Test
	void testGetDegreesF() {
		Temperature temp = new Temperature(35, Temperature.Scale.C);
		
		double test = temp.getDegreesF();
		assertEquals(test, 95); 
		
		temp.setBoth(-40, Temperature.Scale.C);
		test = temp.getDegreesF();
		assertEquals(test, -40); 
		
		temp.setBoth(32, Temperature.Scale.C);
		test = temp.getDegreesF();
		assertEquals(test, 89.6); 
	}

	@Test
	void testGetDegreesC() {
		Temperature temp = new Temperature(95, Temperature.Scale.F);
		
		double test = temp.getDegreesC();
		assertEquals(test, 35); 
		
		temp.setBoth(-40, Temperature.Scale.F);
		test = temp.getDegreesC();
		assertEquals(test, -40); 
		
		temp.setBoth(63, Temperature.Scale.F);
		test = temp.getDegreesC();
		assertEquals(test, 17.22); 
	}

	@Test
	void testEqualsTemperature() {
		Temperature temp = new Temperature(95, Temperature.Scale.F);
		Temperature temp1 = new Temperature(35, Temperature.Scale.C);
		Temperature temp2 = new Temperature(36, Temperature.Scale.C);
		
		
		boolean test = temp.equals(temp1);
		assertEquals(test, true);
		
		boolean test2 = temp1.equals(temp2);
		assertEquals(test2, false);
		
	}

	@Test
	void testCompareTo() {
		Temperature temp = new Temperature(-40, Temperature.Scale.F);
		Temperature temp1 = new Temperature(-40, Temperature.Scale.C);
		Temperature temp2 = new Temperature(36, Temperature.Scale.C);
		Temperature temp3 = new Temperature(100, Temperature.Scale.F);
		
		int test = temp.compareTo(temp1);
		assertEquals(test, 0);
		
		int test2 = temp1.compareTo(temp2);
		assertEquals(test2, -1);
		
		int test3 = temp3.compareTo(temp1);
		assertEquals(test3, 1);
		
	}

	@Test
	void testToString() {
		Temperature temp = new Temperature(100, Temperature.Scale.F);
		
		String test = temp.toString();
		assertEquals(test, "100.0 Degrees Fahrenheit");
	}

}
