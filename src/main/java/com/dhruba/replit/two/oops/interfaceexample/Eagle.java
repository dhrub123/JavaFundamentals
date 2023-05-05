package two.oops.interfaceexample;

class Eagle extends Bird implements Fly{
  
  public void canFly(){
    System.out.println(getClass().getSimpleName() + " is flying");
  }
}