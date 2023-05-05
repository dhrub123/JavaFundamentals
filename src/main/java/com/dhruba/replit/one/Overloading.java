package one;

class Overloading {
  public static void main(String[] args) {
    square(4);
    square(4.0);
  }

  /*
   * Method overloading - method with same name but different parameters in order.
   * Different return types are not enough.
   */

  public static int square(int x) {
    System.out.println(x * x);
    return x * x;
  }

  public static double square(double x) {
    System.out.println(x * x);
    return x * x;
  }
}