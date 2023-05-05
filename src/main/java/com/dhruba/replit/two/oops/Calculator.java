package two.oops;

class Calculator{

  private double number1;
  private double number2;

  public Calculator(double num1, double num2){
    this.number1 = num1;
    this.number2 = num2;
  }

  public double add(){
    return number1 + number2;
  }

  public double subtract(){
    return number1 - number2;
  }

  public double multiply(){
    return number1 * number2;
  }

  public double divide(){
    if(number2 != 0){
      return number1/number2;
    }else{ return 0;}
  }

  public static void main(String args[]){
    Calculator calculator = new Calculator(27.0,8.0);
    System.out.println("27.0 + 8.0 = " + calculator.add() + "\n" +
                       "27.0 - 8.0 = " + calculator.subtract() + "\n" +
                       "27.0 * 8.0 = " + calculator.multiply() + "\n" +
                       "27.0 / 8.0 = " + calculator.divide());
  }

  
}