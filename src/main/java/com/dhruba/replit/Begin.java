package com.dhruba.replit;

class Begin{

  /*
  System.out is an object and println(String) is a method
  which prints text in console and creates a new line.

  print(String) does not create the new line.

  */
  public static void main(String[] args){
    System.out.println("Beginning to learn java");
    Begin.testMethod();
  }

  public static void testMethod(){
    System.out.print("We are testing a static method ");
    System.out.println("We are testing a static method");
  }
  
}