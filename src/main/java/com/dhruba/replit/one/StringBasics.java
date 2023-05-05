package one;

class StringBasics {

  public static void main(String[] args) {

    /*
     * String class is a built in class in Java It has many static and non-static
     * methods
     * 
     * static method - String.valueOf() - takes a int, double or boolean and returns
     * a string representation
     * 
     * non static methods - they require access to the object data e.g.
     * toUpperCase() Strings are immutable , toUpperCase() does not modify the
     * original string, it returns a new string
     */

    String decimalAsAString = String.valueOf(2.17);
    System.out.println(decimalAsAString);
    String test = "We are testing something";
    String convertedToCaps = test.toUpperCase();
    System.out.println(test + " " + convertedToCaps);
    System.out.println("Length of String = " + test.length());
    /*
     * char is primitive vs String which is object
     */

    char testChar = 'G';
    char findCharAtPosition = convertedToCaps.charAt(1);
    System.out.println(testChar + findCharAtPosition);// This will return an int because char is reprsented by numbers internally
    System.out.println(testChar + " " + findCharAtPosition);// This will return string

  }

}