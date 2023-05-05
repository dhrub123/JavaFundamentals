package one.printing;

class PrintSpecialCharacters {

  public static void main(String[] args) {

    /* String concatenation operator is + */

    System.out.println("42 " + "is my fav");
    System.out.println(42 + 22 + " is 64"); // --> This results in 64

    /*
     * When running a package, run it from base directory, like java Printing.PrintSpecialCharacters
     */

    /*
     * Special characters 
      \" works as escape character 
      \n is new line 
      \t is tab
     */

    System.out.println("42 " + "is my fav" + " \nAnd I am trying to print a line with an \"");
  }

}