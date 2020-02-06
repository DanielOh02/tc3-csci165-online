// Daniel Oh
// CSCI 165
// Disc 2
// 2/5/2020

import java.util.Scanner;
import java.lang.Math;
import java.lang.Integer;

public class Primitives{
    public static void main(String[] args){

      // Problem #1 Defining and initializing of each Java Primitive types
      int intExample = 93;
      String intDesc = "Int is and 32-bit signed two's complement integer. Basically stores interger in the range of -2billion to 2 billion.";
      // Desc = Description

      double doubleExample = 18.215;
      String doubleDesc = "Store decimals, but is not accurate for precise values. It's range is bigger than float type but it's range is beyond the scope of this discussion.";

      float floatExample = (float)0.333;
      String floatDesc = "Stores decimals and also not precise valaue. It's range is beyond the scope of this discussion.";

      short shortExample = 123;
      String shortDesc = "Stores integer with the range of -32,768 and 32,767.";

      long longExample = 999999;
      String longDesc = "64-bit two's complement integer. Used for storing very large numbers. It's range is bigger than type int.";

      byte byteExample = 127;
      String byteDesc = "Stores integer in  the range of -128 and 127.";

      char charLetterExample = 'A';
      char charNumberExample = 0101;
      String charDesc = "Stores any characters from the unicode. Can be typed in a letter form or unicode form.";

      boolean booleanExample = false;
      String booleanDesc = "It has two possible values: True or False.";

      // %d = integer formatting %s = string formatting %c = char formatting %b = boolean  % n = line separate
      // %f =  floats and double formatting
      // printing example and description of each primitive type
      System.out.printf("This is an byte type: %d%nDescription: %s%n", byteExample, byteDesc);                                                   // byte
      System.out.printf("%nThis is an short type: %d%nDescription: %s%n", shortExample, shortDesc);                                              // short
      System.out.printf("%nThis is an int type: %d%nDescription: %s%n", intExample, intDesc);                                                    // integer
      System.out.printf("%nThis is an long type: %d%nDescription: %s%n", longExample, longDesc);                                                 // long
      System.out.printf("%nThis is an float type: %f%nDescription: %s%n", floatExample, floatDesc);                                              // float
      System.out.printf("%nThis is an double type: %f%nDescription: %s%n", doubleExample, doubleDesc);                                           // double
      System.out.printf("%nThese are char type: %nletter: %c and code: %c %nDescription: %s%n", charLetterExample, charNumberExample, charDesc); // char
      System.out.printf("%nThis is an double booleanDesc: %b%nDescription: %s%n", booleanExample, booleanDesc);                                  // boolean

      // demonstrating widdening

      byte b = 100;
      short s = b;  // byte value is widdened to short
      double d = b; // byte value is widdened to double
      System.out.println("\ndemonstrating widdening");
      System.out.println("Byte: "+ b);
      System.out.println("Byte value is widdened to short: " + s);
      System.out.println("Byte value is widdened to double: "+ d);

      // demonstrating shorting

      int i = 12345678;
       short si = (short)i;  // int value is shortened to short
      byte bi = (byte)i; // int value is shortened to byte
      System.out.println("\ndemonstrating widdening");
      System.out.println("Int: "+ i);
      System.out.println("Byte value is shortened to short: " + si);
      System.out.println("Byte value is shortened to byte: "+ bi);

      // spacer
      System.out.println();
      System.out.println("===================================================="); // Spacer



      // problem #2 Reading input math

      // gathers input
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter a number: ");
      int n = input.nextInt();

      // display
      System.out.println("Your number Sqaured is:" +  (int) Math.pow(n, 2));
      System.out.println("Your number Cubed is:" + (int) Math.pow( n, 3));
      System.out.println("Your number raised to the power of 4 is:" + (int) Math.pow( n, 4));

      // spacer
      System.out.println();
      System.out.println("===================================================="); // Spacer


      // problem #3 Class Integer

      int max = Integer.MAX_VALUE;
      int min = Integer.MIN_VALUE;
      // display of the max and min
      System.out.println("Max value of Int type: " + max);
      System.out.println("Min value of Int type: " + min);

      // demonstration

      // compare(int x, int y) Compares two int values numerically fpr equality
      // compareUnsigned(int x, int y) Compares two int values numerically treating the values as unsigned

      System.out.println(Integer.compare(12, 12)); // returns 0
      System.out.println(Integer.compare(12, 0));  // returns 1
      System.out.println(Integer.compare(-2, 12)); // returns -1

      System.out.println(Integer.compareUnsigned(15, -8)); // this returns -1
      System.out.println(Integer.compareUnsigned(8, 5)); // this returns 1

      // CompareingUnsigned treats any values as unsigned values
      // which are not just an absolute vaule. It can cause unwatned errors
      // if signed and unsigned vaules are used.

      // Spacer
       System.out.println();
       System.out.println("===================================================="); // Spacer

       // problem #4 Class division and modululs

       System.out.print("Please enter a divided: ");
       int divided = input.nextInt();
       System.out.print("Please enter a divisor: ");
       int divisor = input.nextInt();

       double operatorDiv = divided / divisor; // to variables so I can use it in the printf
       int operatorMod = divided % divisor; // same reason as above

       // display the outcome along with descriptive message.
       System.out.printf("\nThis was calculated using the floorDiv: %d%nWhich rounds down to the nearers integer after dividing%n",Math.floorDiv(divided, divisor));
       System.out.printf("%nThis was calculated using the / operator: %f%nWhich returns a double type%n", operatorDiv);
       System.out.printf("%nThis was calculated using the floorMod: %d%nWhich is not that diffrent from the modululs operator%n",Math.floorMod(divided, divisor));
       System.out.printf("%nThis was calculated using the modululs operator: %d%nWhich returns a int type%n", operatorMod);








    } // end of main
} // end of class
