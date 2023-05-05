package two.oops.interfaceexample;

class Executor{
  
  public static void main(String args[]){
    Penguin penguin = new Penguin();
    Eagle eagle = new Eagle();

    penguin.eat();
    penguin.walk();

    eagle.eat();
    eagle.canFly();
  }
}