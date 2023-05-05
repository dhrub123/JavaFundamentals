package two.oops.polymorphism.inheritance;

class DynamicPolymorphism{

/*
Static polymorphsm --> method overloading = decided at compile time
Dynamic polymorphism --> method overriding = decided at runtime
*/
  public static void main(String args[]){
    Shape[] shapes = new Shape[2];
    shapes[0] = new Circle(2.3);
    shapes[1] = new Rectangle(3,7);
    Circle c = (Circle)shapes[0];

    System.out.println("Area of Rectangle = " + shapes[1].getArea() + "\n" + 
                       "Area of Circle = " + shapes[0].getArea() + "\n" + 
                       "Area of Parent = " + c.getAreaOfParent());
    
  }
}