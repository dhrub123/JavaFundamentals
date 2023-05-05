package two.oops.interfaceexample;

class Penguin extends Bird{
  
  public void walk(){
    System.out.println(getClass().getSimpleName() + " is walking");
  }
}