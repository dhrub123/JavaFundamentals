package two.oops.inheritance;

public class Vehicle {

  int topSpeed;
  String vehicleType;
  String make;
  String model;

  public Vehicle(int topSpeed, String vehicleType, String make, String model) {
    this.topSpeed = topSpeed;
    this.vehicleType = vehicleType;
    this.make = make;
    this.model = model;
  }

  public void drive() {
    System.out.println("We are driving vehicle");
  }

  public void refuel() {
    System.out.println("Vehicle refuelling");
  }

  public String printDetails(){
    return "vehicleType = " + vehicleType + " make = " + make + " model = " + model + " topSpeed = " + topSpeed;
  }

}