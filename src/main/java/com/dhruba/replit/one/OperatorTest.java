package one;

class OperatorTest{

  public static void main(String[] args){
    System.out.println(evenInRange(0));
    System.out.println(evenInRange(24));
    System.out.println(evenInRange(25));
    System.out.println(evenInRange(34));
  }

  public static boolean evenInRange(int x){
    if(x>23 && x <33 && ((x%2)==0)){
      return true;
    }
    return false;
  }
}