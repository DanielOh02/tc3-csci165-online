// Daniel Oh
// CSCI 165
// Matrix Stuff 

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class MatrixStuff {


	public static void fillArrayRowMajor(int[][]matrix) {
		
		int row = 0;
		int column = 0;
		
		try {
			
			FileReader fileReader = new FileReader("number_list.txt");
			Scanner scanner = new Scanner(fileReader);
			
			while(scanner.hasNextInt()) {		
				
				int number = scanner.nextInt();
				matrix[row][column] = number;
				
				// checks and see if the column has been filled
				if (column == 19){
					
					row ++;
					column = 0;
				
				} else 
					column ++; 
					
				
			} // end of while loop 
			
			scanner.close();
			
		} catch (FileNotFoundException fnf) {
			
			System.out.println("Error: File Not Found!");
			
		} // end of try and catch 
		
		
		
	} // end of fill array 
	
	public static int findMax(int[][] matrix) {
		
		int row = 0;
		int column = 0;
		int max = matrix[row][column];
		
		while (row < 50) {
			
			// if the number is bigger than the current biggest number then set it as the biggest number
			if (matrix[row][column] > max)
				max = matrix[row][column];
			
			if (column == 19) {
				
				row ++;
				column = 0;				
				
			} else 
				column ++;
	
		} // end of while loop
		
		return max;
		
	} // end of find Max 
	
	public static int findMin(int[][] matrix) {

		int row = 0;
		int column = 0;
		int min = matrix[row][column];
		
		while (row < 50) {
			
			// if the number is smaller than the smallest number then set the it as the smallest number
			if (matrix[row][column] < min)
				min = matrix[row][column];
			
			if (column == 19) {
				
				row ++;
				column = 0;				
				
			} else 
				column ++;
	
		} // end of while loop
		
		return min;
		
	} // end of find min 
	
	public static int findMaxOfRow(int[][] matrix, int row) {
		
		int max = matrix[row][0]; // starts with the first number in the row 
		
		
		for (int column = 0; column < matrix[row].length; column += 1) {
			// same concept as the over find max
			if (matrix[row][column] > max)
				max = matrix[row][column];
		
		} // end of for loop
		
		return max;
		
	} // end of find max of row 
	
	public static int findMinOfRow(int[][] matrix, int row) {
		
		int min = matrix[row][0]; // starts with the first number in the row 
		
		for (int column = 0; column < matrix[row].length; column += 1) {
			// same concept as the other find min
			if (matrix[row][column] < min)
				min = matrix[row][column];
		
		} // end of for loop
		
		return min;
		
	} // end of find min of row
	
	public static int findMaxOfColumn(int[][] matrix, int column) {
		
		int max = matrix[0][column]; // starts with the first number in the column
		
		for (int row = 0; row < matrix.length; row += 1) {
			// same concept as the other find max
			if (matrix[row][column] > max)
				max = matrix[row][column];
		
		} // end of for loop
		
		return max;
		
	} // end of find max of column
	
	public static int findMinOfColumn(int [][] matrix, int column) {
		
		int min = matrix[0][column]; // starts with the first number in the column
		
		for (int row = 0; row < matrix.length; row += 1) {
			// same concept as the other find min
			if (matrix[row][column] < min)
				min = matrix[row][column];
		
		} // end of for loop
		
		return min;
		
	} // end of find min of column
	
	public static void fillArrayColumnMajor(int[][] matrix) {
		
		int row = 0;
		int column = 0;
		
		try {
			
			FileReader fileReader = new FileReader("number_list.txt");
			Scanner scanner = new Scanner(fileReader);
			
			while(scanner.hasNextInt()) {		
				
				int number = scanner.nextInt();
				matrix[row][column] = number;
				
				// checks and see if the column has been filled
				if (row == 49){
					
					column ++;
					row = 0;
				
				} else 
					row ++; 
					
					
			} // end of while loop 
			
			scanner.close(); // close so it does not leak data 
			
		} catch (FileNotFoundException fnf) {
			
			System.out.println("Error: File Not Found!");
			
		} // end of try and catch 
		
		
	} // end of fill array column major
	
	public static void printRow(int[][] matrix, int row, int num_cols) {
		
		int column = 0;
		int num_item = 20 / num_cols;
		int item = 0;
		
		while (column < 20) {
			
			while(item < num_item) {
				System.out.printf("%d ", matrix[row][column]);
				item ++;
				column ++;
				
				if (column > 19)
					break;
				
			} // end of nested while loop
			
			if (column > 19)
				break;
			
			System.out.println("");
			item = 0;
		
		} // end of while loop
		
		
	} // end of print row
	
	public static int smallestChange(int[][] matrix) {
		
		int[] changesList = new int[matrix.length];
		int row = 0;
		int column = 0;
		int value = 0; // total change value in the row
		int change = 0;
		int smallest = 0;
		int smallestRow = 0;
		
		
		
		
		while (row < matrix.length) {
			while (column < matrix[row].length - 1) {
				change = matrix[row][column+1] - matrix[row][column];
				value = value + change;
				column ++;
					
			} // end of nested loop
			// convert it into absolute value and add it to the array
			changesList[row] = Math.abs(value);
			
			column = 0; // reset column
			value = 0;
			row ++;
		
			
		} // end of while loop
			
		smallest = changesList[0]; // set the default smallest number as the first number 
			// scan the array to find the smallest number
		for (int i = 0; i < changesList.length; i++) {
			if (changesList[i] < smallest) {
		    		smallest = changesList[i];
		    		smallestRow = i;
			} // end of if 
		} // end of for loop
	
		return smallestRow;
	} // end of smallest change
	
	
	// main ====================================================================================================
	
	public static void main (String[] args) {
		int[][] matrixR = new int [50][20];
		int[][] matrixC = new int [50][20];
		
		// testing and printing the methods
		
		fillArrayRowMajor(matrixR);
		System.out.println("Filled an array in row major order...");
		
		fillArrayColumnMajor(matrixC);
		System.out.println("Filled an array in column major order...");
		
		System.out.printf("\nThe largest number in the matrix is: %d",findMax(matrixR));
		
		System.out.printf("\nThe smallest number in the matris is: %d", findMin(matrixR));

		System.out.printf("\nThe largest number in row 7 in the row major matrix is: %d",findMaxOfRow(matrixR, 7));
		
		System.out.printf("\nThe smallest number in row 7 in the row major matrix is: %d",findMinOfRow(matrixR, 7));
		
		System.out.printf("\nThe largest number in column 3 in row major matrix is: %d",findMaxOfColumn(matrixR, 3));
		
		System.out.printf("\nThe largest number in column 3 in row major matrix is: %d",findMinOfColumn(matrixR, 0));
		
		System.out.println("\nPrinting out the row 5 in 4 columns");
		printRow(matrixR, 5, 4);
		
		System.out.println("");
		
		System.out.printf("\nThe smallest changed row in the row major matrix is: %d",smallestChange(matrixR));
		
		
	} // end of main
	
	
} // end of class
