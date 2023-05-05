package two.oops;

class Rectangle{

  private int length;
  private int width;
  
  public Rectangle(){
    this.length = 0;
    this.width = 0;
  }

  public Rectangle(int length, int width){
    this.length = length;
    this.width = width;
  }

  public int getArea(){
    return this.length * this .width;
  }

  public static void main(String args[]){
    Rectangle rectangle =  new Rectangle(4,5);
    System.out.println("Area of rectangle = " + rectangle.getArea());
  }
  
}