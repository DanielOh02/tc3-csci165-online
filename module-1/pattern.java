// Daniel Oh
// CSCI 165

public class pattern {

  public static void main (String[] args) {

// first shape
    for(int i = 4; i >= 0 ; i--) {
      for(int j = 0; j < i; j++) {
        System.out.print("*");
      } //end of second for loop
      System.out.println("*");
    } // end of first for loop

    System.out.println();

// second shape
    for(int i = 0; i <= 4; i++){
      for(int j = 0; j <= 4; j++){
        if(i==0||j==0||i==4||j==4){
          System.out.print("*");
        } // end of if
        else{
          System.out.print(" ");
        } // end of else

      } // end of second for loop
      System.out.println();
    } // end  of first for loop

// third shape

// no idea how to do this with loop
  System.out.println();
  System.out.println("*****");
  System.out.println(" *** ");
  System.out.println(" **  ");
  System.out.println(" *** ");
  System.out.println("*****");


  } // end of main
} // end of class
