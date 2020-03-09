// Daniel Oh
// CSCI 165
// Temperature 

public class Temperature {
		
		public static enum Scale {C, F};  
	
		private double degrees = 0;
		private Scale scale = Scale.C; 
		
		
		// constructors 
		public Temperature(){} // no argument 
		
		public Temperature(int temp, Scale scale){
			setBoth(temp, scale);
			
		}  // end of TemperatureIntStirng 
		
		// setters 
		public void setTemp(double temp) {
			if (temp >= -200 && temp <= 200)
				degrees = temp;
			else
				degrees = 0;
			
		} // end of set temperature
		
		public void setScale(Scale scale) {
			if (scale == Scale.F)
				this.scale = Scale.F;
			else 
				this.scale = Scale.C; 
					
		} // end of set scale
		
		public void setBoth(double temp, Scale scale) {
			setTemp(temp);
			setScale(scale);
			
		} // end of set both
		
		// getters 
		public double getDegreesF() {	
			if(scale == Scale.C) {
			degrees = (9 * (degrees)/5) + 32; 
			degrees = round(degrees);
			scale = Scale.F;
			return degrees; 
			
			} else 
				return degrees;
					
		} // end of get DegreesF 
		
		public double getDegreesC() {
			if(scale == Scale.F) {
			degrees = 5 * (degrees - 32)/9; 
			degrees = round(degrees);
			scale = Scale.C; 
			return degrees; 
			
			} else 
				return degrees;				
		
		} // end of get DegreesC 
		
		// compare 
		// the if and else statement makes it so that the temp goes back to the original scale	
		public boolean equals(Temperature t) {
			
			boolean bol;
			// if this temperature is in C 
			if (scale == Scale.C) {
				if (t.scale == Scale.F) {
					bol = this.degrees == t.getDegreesC();
					t.getDegreesF();
					return bol;
					
				} else 
					return this.degrees == t.degrees;
					
				
			} else {
				
				if (t.scale == Scale.C) {
					bol = this.degrees == t.getDegreesF();
					t.getDegreesC();
					return bol;
					
				} else 
					return this.degrees == t.degrees;
					
								
			} // end of if and else block
			
		} // end of equals  
			
	
		// the if and else statement makes it so that the temp goes back to the original scale	
		public int compareTo(Temperature t) {
			// if this temperature is in C
			if (scale == Scale.C) {
				
				if (t.scale == Scale.F) {
					if(this.degrees > t.getDegreesC()) {
						t.getDegreesF();
						return 1;
						
					} else if(this.degrees < t.getDegreesC()) {
						t.getDegreesF();
						return -1;

					} else {
						t.getDegreesF();
						return 0; 
					}
				
				} else {
					
					if(this.degrees > t.degrees) 
						return 1;
					else if (this.degrees < t.degrees)
						return -1;
					else 
						return 0;
					
				}
				
				
			} else {
				
				if (t.scale == Scale.C) {
					if(this.degrees > t.getDegreesF()) {
						t.getDegreesC();
						return 1;
						
					} else if(this.degrees < t.getDegreesF()) {
						t.getDegreesC();
						return -1;

					} else {
						t.getDegreesC();
						return 0; 
					}
					
					
				} else {
					
					if(this.degrees > t.degrees) 
						return 1;
					else if (this.degrees < t.degrees)
						return -1;
					else 
						return 0;
					
				}
			} // end of if and else block 
				
			
		
		} // end of compareTo
		
		// to strings 
		public String toString() {
			return degrees + ((this.scale == Scale.C) ? " Degrees Celsius" : " Degrees Fahrenheit");
			
		}
		
		public double round(double num) {
			return Math.round(num * 100) / 100.0;
			
			
		} // end of round
		
	
} // end of class 
