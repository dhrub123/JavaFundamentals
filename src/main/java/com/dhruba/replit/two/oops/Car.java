package two.oops;

public class Car{ //class keyword is used to define a class

  /*
  Fields of a class
  */
  private int numberOfSeats = 5; 
  /* this field is marked private, private members cannot be accessed outside class.
  A good practice is to mark all variables as private and use getter or setter methods to 
  access them */
  String color = "Black";
  final int fuelCapacity = 34; 
  /* value cannot be changed for a final member */
  String manufacturer = "Honda";
  protected int currentFuel;
  /*This member is marked protected which means it cannot be accessed outside the package
    apart from a class that inherits the class containing the protected member.
    default access modifer is similar to protected but more restrictive in that even classes inheriting
    the class containing the protected member cannot access the protected member*/
  static int topSpeed = 90;
  /* All instances of the class will share the static field and it is accessed as Car.topSpeed */

  /*
  Methods of a class
  */
  /*
  public means the member of the class is accessible from anywhere.
  methods are generally marked public since they are the usable members of the class
  */
  public void refuel(int fuel){
    this.currentFuel = fuel;
  }

  protected int getNumberofSeats(){
    return this.numberOfSeats;
  }

  /* the below methods are setter and getter or accessor methods used in oops for data hiding*/
  public void setCurrentFuel(int fuel){
    this.currentFuel = fuel;
  }
  
  protected void getCurrentFuel(){
    System.out.println(this.currentFuel);
  }

  public static void main(String args[]){
    Car car = new Car();//new is used to create an instance of class
    car.refuel(20);
    car.getCurrentFuel();
    System.out.println(Car.topSpeed);
  }

}