import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;



// Daniel Oh
// CSCI 165
// Methods for map data drawer
public class MapData {
	
	// fill the array from dat files
	public static int[][] MapDataArray(String filename){
		
		int[] size = fileSize(filename);
		
		int columnInitial =  size[1];
		int rowInitial = size[0];
		
		int[][] map = new int [rowInitial][columnInitial];
		
		
		int row = 0;
		int column = 0;

	
		try {
		
			FileReader fileReader = new FileReader(filename);
			Scanner scanner = new Scanner(fileReader);
			
 			while(scanner.hasNextInt()) {		
				
				int number = scanner.nextInt();
				map[row][column] = number;
				
				// checks and see if the column has been filled
				if (column == columnInitial - 1){
					
					row ++;
					column = 0;
				} else 
					column ++; 
			} // end of while loop 
 			
			scanner.close();
			
		} catch (FileNotFoundException fnf){
			System.out.println("Error: File Not Found!");

			
		} // end of try-catch block
		
		return map;
			
	} // end of MapDataArray
	
	// findMax in the whole map
	public static int findMax(int[][] matrix) {
		
		int row = 0;
		int column = 0;
		int max = matrix[row][column];
		
		while (row < matrix.length) {
			
			// if the number is bigger than the current biggest number then set it as the biggest number
			if (matrix[row][column] > max)
				max = matrix[row][column];
			
			if (column == matrix[row].length - 1) {
				
				row ++;
				column = 0;				
				
			} else 
				column ++;
	
		} // end of while loop
		
		return max;
		
	} // end of find Max 
	
	// findMin in the whole map
	public static int findMin(int[][] matrix) {

		int row = 0;
		int column = 0;
		int min = matrix[row][column];
		
		while (row < matrix.length) {
			
			// if the number is smaller than the smallest number then set the it as the smallest number
			if (matrix[row][column] < min)
				min = matrix[row][column];
			
			if (column == matrix[row].length - 1) {
				
				row ++;
				column = 0;				
				
			} else 
				column ++;
	
		} // end of while loop
		
		return min;
		
	} // end of find min 
	
	// find the lowest number between 3 numbers
	public static int leastChange(int num1, int num2, int num3) {
		
		int[] array = new int [3];
		array[0] = num1;
		array[1] = num2;
		array[2] = num3;
		
		int min = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];
		
		} // end of for loop
		
		return min;
				
	}// end of least change
	
	// gives an array of the file size
	public static int[] fileSize(String filename) {
		int[] size = new int[2];
		
		int indexOfU = filename.indexOf("_");
		int indexOfP = filename.indexOf(".");
		int indexOfX = filename.indexOf("x");
		
		int y =  Integer.parseInt(filename.substring(indexOfU + 1, indexOfX));
		int x = Integer.parseInt(filename.substring(indexOfX + 1, indexOfP));
		
		size[0] = x;
		size[1] = y;
		
		return size;
		
	}

	// test to make sure it works 
	public static void main(String args[]) {
		
		int[][] map = MapDataArray("Colorado_844x480.dat");
		System.out.println(map.length);
		System.out.println(findMax(map));
		System.out.println(map[95].length);
		System.out.println(	);
	
	} // end of main 
	
	
	
	
} // end of class
