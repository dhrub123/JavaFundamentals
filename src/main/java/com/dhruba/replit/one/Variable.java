package one;

class Variable {

  public static void main(String[] args) {
    /*
     * When we define a variable, memory is reserved for it. float is for decimal -
     * ends with f, double is double the precision of float
     */
    int x = 5;
    float f = 5.21f;
    double d = 5.213;
    System.out.println(x + " " + f + " " + d);
    double pi = 3.145;
    double radius = 7.8;
    double area = pi * radius * radius;
    System.out.println("Area of Circle = " + area);

    int num = 7;
    int den = 2;
    int result = 7 / 2;
    System.out.println("result = " + result);
    double fractionalResult = (double) num / den;// casting example
    int remainder = 7 % 2;// remanider by modulo operator
    System.out.println("fractionalResult = " + fractionalResult + " remainder = " + remainder);

    // increment operators
    System.out.println("Pre increment operator --num = " + --num + " Post increment operator den-- = " + den--); // will print 6 and 2

  }

}