package one;

import java.util.Arrays;

class ArrayBasics {

  public static void main(String[] args) {
    /*
     * An array cannot be resized and type of an array should be decided in advance
     */

    int[] integerArray = { 1, 3, 2, 4, 5 };// shortcut way

    int[] integerArrayTwo = new int[5];
    integerArrayTwo[0] = 1;
    integerArrayTwo[1] = 2;
    integerArrayTwo[2] = 3;
    integerArrayTwo[3] = 4;
    integerArrayTwo[4] = 5;

    System.out.println(integerArray.length);
    //java.util.Arrays add utility classes to array
    Arrays.sort(integerArray); // This modifies the array
    System.out.println(Arrays.toString(integerArray));
    System.out.println("At position 1 after sorting = " + integerArray[1]);

    // Reading from input; e.g. run program as java one.ArrayBasics TestInput
    System.out.println(args[0]);
    
  }

}