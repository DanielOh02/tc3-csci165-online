// Daniel Oh
// 1/24/2020
// CSCI 165
// Command line Arguments

// file name must match the public class identifier
public class HelloWorld2{

  // main method is the starting point of any Java app
  public static void main(String[] args){

    String name = "";
        for (String s : args){
          name += (" " + s);
        }
          System.out.println("Hello" + name + ". Nice work processing the arguments");

  } // end of main


} // end of class
