package two.oops.multipleInheritance;

class Car{

  private int model;
  private String manufacturer;
  
  public Car(int model, String manufacturer){
    this.model = model;
    this.manufacturer = manufacturer;
  }

  public void printDetails(){
    System.out.println("The model and manufacturer of " + getClass().getSimpleName() + " is " + this.model + " " + this.manufacturer);
  }
}