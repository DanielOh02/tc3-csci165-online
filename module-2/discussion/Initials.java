// Daniel Oh
// CSCI
// 2/6/2020


import java.util.Scanner;

public class Initials{
  public static void main(String[] args){

    // gathers input from the terminal
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter you first name: ");
    String firstName = input.nextLine(); // first name

    System.out.print("Please enter you last name: ");
    String lastName =  input.nextLine(); // last name

    String fullName = firstName + " " +lastName;

    int i = fullName.indexOf(" "); // finds the index of the space

    // gets the first charaters of each name
    char firstChar = fullName.charAt(0); // first name
    char lastChar = fullName.charAt(i+1); // last name

    // converts characters into string for concatenation
    String initials = Character.toString(firstChar) + Character.toString(lastChar);

    // 1. print characters individually
    System.out.printf("%nThe first character of your first name is: %c",firstChar);
    System.out.printf("%nThe first character of your last name: %c ",lastChar);

    // 2. convert them into Values
    System.out.printf("%nYour first name character vaule is: %d",(int)firstChar);
    System.out.printf("%nYour last name character value is: %d",(int)lastChar);

    // 3. Sum them up
    System.out.printf("%nThe sum of the value of the charaters are: %d", ((int) (firstChar + (int) firstChar)));

    // 4. conatenate them into string and print
    System.out.printf("%nYour charaters concatenated together: %s", initials);



  } // end of main
} // end of class
