// Daniel Oh
// CSCI 165
// 2/10/2020
// Scanning and writing tickets

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;




public class Tickets{

    public static void main(String[] args){

        /*
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt

        */
      // Put this outside the try statement becasue I want to call it outside the try statement
      int lineNumber = 1; // for personal purposes, to know if its going thourgh every line.
      int validTixNumber = 0; // So I can keep track if I have the right amount of solutions


        // try to scan this file
      try{
          // create File instance to reference text file and opens tickets.txt
          File ticketList = new File("tickets.txt");

          // instantiate scanner object
          Scanner fileScanner = new Scanner(ticketList);

          // keep scanning untill there is no next line
          while(fileScanner.hasNextLine()){

            String  ticket  = fileScanner.nextLine();                            // gets the ticket number from that line
            String  last = ticket.substring(ticket.length() - 1);                // find the last digit string using substring() which extracts characters from string and finds the index of the last digit by using length() -1
            int     last_digit = Integer.valueOf(last);                          // convert last digit string into integer
            String  reduced_ticket = ticket.substring(0, ticket.length() - 1);   // gets ticket number without the last digit by slicing
            int     ticket_number = Integer.valueOf(reduced_ticket);             // convert the ticket number from string to integer
            int     remainder = ticket_number % 7;                               // finds the remainder of the ticket number divided by 7
            boolean validity = remainder == last_digit;                          // checks if the last digit matches the remainder of the ticket number divided by 7
            lineNumber ++; // increase by one

            // only ran only if validity is true
            if (validity == true) {
              validTixNumber ++; // increase by one

              // instantiate fileWriter object and append instead of overwriting.
              try (FileWriter fileWriter = new FileWriter("valid_tix.txt", true)) {
                    fileWriter.write(ticket);                                    // write the valid ticket number
                    fileWriter.write("\n");                                      // leave a space for next ticket
                    fileWriter.close();                                          // close to pervent errors

              // if there is errors trying to write in the file run this
              } catch (IOException e) {
                  System.out.println("There was a problem writing to the file");

              } // end of catch

            } // end of if

            // display the the process because I like watching it.
            //remove the comment block to to see the terminal logs
            /*
            String  format = "\nOriginal Ticket #: %s\nLast Digit: %d\nReduced Ticket #: %d\nRemainder: %d\nValidity: %b\n"; // use this format
            System.out.printf(format, ticket, last_digit, ticket_number, remainder, validity); // fill the spots with these variable
            */

          } // end of while
          fileScanner.close(); // to pervent data leak.


          // run this if there is an  error

        } catch(FileNotFoundException fnf){
          System.out.println("ERROR: File Not Found!");

        } // end of catch

    // display results of script
    System.out.printf("\nNumber of lines scanned: %d \nNumber of valid tickets: %d", lineNumber, validTixNumber);




    } // end of main
} // end of class
