package one.printing;

class FormattedPrinting {

  /*
   * Use System.out.format Format Specifier -- %f for floating point number and %d
   * for integer %9.2f --> means 2 places after decimal and 9 places with left
   * padding including decimal
   */
  public static void main(String[] args) {
    System.out.format("%1.2f is the approximation of pi ", 3.14123);
    System.out.format("%9.2f is the approximation of pi ", 3.14123);
    System.out.format("%d %d %d \n %2d %2d %2d", 2, 4, 8, 16, 32, 63);
  }

}