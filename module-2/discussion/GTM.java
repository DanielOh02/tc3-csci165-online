// Daniel Oh
// 2/6/2020
// CSCI 165

import java.util.Scanner;

public class GTM{
  public static void main(String[] args){

    // gather input
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter your time zone offset to GMT in hours: ");
    int offSetHours = input.nextInt();

    // converted inorder: min to second to milisec
    long offSetMili = offSetHours * 60 * 60 * 1000; // converted into milisec

    // get the time from your system in miliseconds
    long currentTime = System.currentTimeMillis();

    // adds the off set time to the current time in miliseconds
    long offSetTime = currentTime + offSetMili;

    // converts miliseconds into more readable time format
    long milliseconds = offSetTime % 1000;
    long seconds = (offSetTime / 1000) % 60; // since there is 1000 milisec in a second convert the milisec into seconds and find the remainder of 60
    long minutes = (offSetTime / (1000 * 60)) % 60; // convert milisec into minutes find the remainder
    long hour = (offSetTime / (1000 * 60 * 60)) % 24; // convert milliseconds into hours and find the remainder

    // display in the correct format
    System.out.printf("The time is: %d:%d:%d:%d", hour, minutes, seconds, milliseconds);

  } // end of main
} // end of class
