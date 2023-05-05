package one;
import java.util.Random;

class LoopTest{

  public static void main(String[] args){
    
    checkTemperature();
    flipCoin();
    testWhile();
    printFactors(42);
    testForLoop();
    testForEachLoop();
  }

  public static void checkTemperature(){
    /*if statement*/
    int temperature = -5;
    if(temperature < 0){
      System.out.println("It is very cold");
    }else{
      System.out.println("Not so cold");
    }
  }
  
  public static void flipCoin(){
    //Random Number generation code
    Random randomNumber = new Random();
    int generatedRandomNumber = randomNumber.nextInt(2); // This gives next random number between 0 inclusive and 2(not inclusive)
    if(generatedRandomNumber == 0){
      System.out.println("Head");
    }else{
      System.out.println("Tail");
    }
  }

  public static void testWhile(){
    //while loop - test for an unspecified no. of time till a condition change
    int i = 0;
    while(i < 100){
      i+=2;
      System.out.print(i + " ");
    }
    System.out.println("\n");
  }

  public static void printFactors(int x){
    int possibleFactor = 1;
    while(possibleFactor <= x){
      if(x % possibleFactor == 0){
        System.out.print(possibleFactor + " ");
      }
      possibleFactor++;
    }
    System.out.println("\n");
  }

  public static void testForLoop(){
    for(int i = 10; i>0;  i--){
      System.out.print( i + " ");
    }
    System.out.println("\n");
  }

  public static void testForEachLoop(){
    int[] primes = {2,3,5,7,11,13,17};
    for(int p : primes){
      System.out.print( p + " ");
    }
    System.out.println("\n");
  }  

  
  
}