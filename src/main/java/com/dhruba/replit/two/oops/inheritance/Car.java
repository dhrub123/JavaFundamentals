package two.oops.inheritance;

/**
To compile inherited classes use javac at root, 1st the parent class and then the child class
javac two/oops/inheritance/Vehicle.java
javac two/oops/inheritance/Car.java
and then
java two/oops/inheritance/Car
**/
public class Car extends Vehicle{
  private String powerType; 
  
  public Car(int topSpeed, String vehicleType, String make, String model, String powerType){
    super(topSpeed, vehicleType, make, model);
    this.powerType = powerType;
  }

  public String printDetails(){
    return super.printDetails() + " powerType = " + powerType;
  }

  public static void main(String args[]){
    Car accord = new Car(220, "Car", "Honda", "Accord", "Petrol");
    System.out.println(accord.printDetails());
  }
  
}