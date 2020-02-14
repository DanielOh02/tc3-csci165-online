// Daniel Oh
// CSCI 165
// 2/13/2020
// Module 2 Programming assignment

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class FoodTruck {


  public static void main(String [] args){

    // variable for price
    double total = 0;
    double subtotal = 0;

    // variable for keeping track of the quantity, items price
    String[] menu = new String[3];
    double[] prices = new double[3];
    int[] quantity = new int [3];

    double[] itemTotalPrice = new double [3];

  // create file and scanner
  try{
      File menuList = new File("menu.txt");
      File pricesList = new File ("prices.txt");

      Scanner menuScanner = new Scanner(menuList);
      Scanner pricesScanner = new Scanner(pricesList);

      byte index = 0;

      // scan the txt files and store them in a array
      while(menuScanner.hasNextLine()){
        String menuItem = menuScanner.nextLine();
        double price = pricesScanner.nextDouble();

        menu[index] = menuItem;
        prices[index] = price;
        index++;
      } // end of while

    } catch (IOException e) {
        System.out.println("There was a problem writing to the file");
      } // end of catch


  // display of the menu and gathering quantity and name
  System.out.println("Welcome to the CS food truck");

  Scanner input = new Scanner(System.in);

  // get name
  System.out.print("\nEnter your name: ");
  String name = input.nextLine();


  System.out.println("\nEnter the quantity of each item");
  System.out.println("===============================");


  // prints and asks for quantity of each item
  for (int i = 0; i < 3; i++){
  System.out.printf("\n%s - $%.2f: ", menu[i], prices[i]);
  quantity[i] = input.nextInt();

  } // end of for loop

  // finds the total price of each item after getting the quantity
  for (int i = 0; i < 3; i++) {
    itemTotalPrice[i] = (prices[i] * quantity[i]);
  } // end of for loop

  // finds the subtotal
  for (int i = 0; i < 3; i++) {
    subtotal += (prices[i] * quantity[i]);
  } // end of for loop

  // tax amount
  double tax = subtotal * 0.0625; // %6.25

  // finds he total with tax
  total = subtotal + tax;

  // call the invoice method I created, and store them in an array
  String[] invoice = invoice(name);


  // declare each line and format them
  String lineInvoice = (invoice[0]);
  String number = (invoice[1]);
  String divider = "\n===============================================================\n";
  String lineDesc =  String.format("\n%-30s %10s %10s %10s", "Item", "Quantity", "Price", "Total");
  String itemOne =   String.format("\n%-30s %10d %10s %10s", menu[0], quantity[0], currency(prices[0]), currency(itemTotalPrice[0]));
  String itemTwo =   String.format("\n%-30s %10d %10s %10s", menu[1], quantity[1], currency(prices[1]), currency(itemTotalPrice[1]));
  String itemThree = String.format("\n%-30s %10d %10s %10s", menu[2], quantity[2], currency(prices[2]), currency(itemTotalPrice[2]));
  String lineSub =   String.format("\nSubtotal: %53s", currency(subtotal));
  String lineTax =   String.format("\nTaxes: %56s", currency(tax));
  String lineTotal = String.format("\nTotal: %56s %n", currency(total));

  // concatenate all the lines togther in a Single string
  String output = (lineInvoice + "\n" + lineDesc + divider +itemOne + itemTwo + itemThree + divider + lineSub + lineTax + lineTotal);

  // write invoice and receipt an in txt file
  try {
    FileWriter fileWriter = new FileWriter(invoice[1] + ".txt");
    fileWriter.write(output);
    fileWriter.close();


  } catch (IOException e) {
      System.out.println("There was a problem writing to the file");
    } // end of catch

  // display the receipt in the terminal
  System.out.println(output);

  } // end of mains

  // handles name and time and date
  private static String[] invoice(String fullName){

    // finds the first two letters of each name
    int space = fullName.indexOf(" ");
    String firstInitials = fullName.substring(0,2);
    String lastInitials = fullName.substring(space+1, space +3);

    // converts them into upper case
    String firstUpper = firstInitials.toUpperCase();
    String lastUpper = lastInitials.toUpperCase();

    // get the first character of each name
    char firstChar = fullName.charAt(0);
    char lastChar = fullName.charAt(space+1);

    // convert them into integer
    int firstInt = (int) firstChar;
    int lastInt = (int) lastChar;
    int nameLength = fullName.length();

    //get the date and time in correct format
    LocalDateTime current = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    String formattedDateTime = current.format(formatter);

    // time and date dis-concatention
    String date = formattedDateTime.substring(0,10);
    String time = formattedDateTime.substring(11,19);
    String month = formattedDateTime.substring(0,2);
    String day = formattedDateTime.substring(3,5);
    String hour = formattedDateTime.substring(11,13);
    String min = formattedDateTime.substring(14,16);

    // unique number for name converted into String
    String number =  Integer.toString((firstInt + lastInt) * nameLength);

    // creates invoice number
    String invoiceNum = firstUpper + lastUpper + number + month + day + hour + min;

    // format them and store them into a variable
    String lineOne =   String.format("\nInvoice number: %47s", invoiceNum);
    String lineTwo =   String.format("\nDate:           %47s", date);
    String lineThree = String.format("\nTime:           %47s", time);

    // concatenate them into a single String
    String finalOut = lineOne + lineTwo + lineThree;

    // return in an array of the invoice number and the formmated text
    return new String[] {finalOut, invoiceNum};

  } // end of initials

  // adds $ to the value and convert it into a string
  private static String currency(double value){

    // formats the decimal in to 2 decimal points
    DecimalFormat df = new DecimalFormat("#,###,###.00");
    String cost = String.valueOf(df.format(value));
    String output = "$" + cost;

    return output;

  } // end of currency

} // end of class
