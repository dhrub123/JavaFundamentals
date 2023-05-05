package two.oops.polymorphism.inheritance;

class Rectangle extends Shape{

  private double length;
  private double breadth;
  
  public Rectangle(double length, double breadth){
    this.length = length;
    this.breadth = breadth;
  }

  public double getArea(){
    return length * breadth;
  } 
  
}