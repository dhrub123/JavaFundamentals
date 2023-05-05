package two.oops.multipleInheritance;

class Elantra extends Car implements Sedan{

  private String variant;
  
  public Elantra(int model, String variant){
    super(model, "Hyundai");
    this.variant = variant;
  }

  public void bootspace(){
    System.out.println("Bootspace = " + Sedan.bootspace);
  }

  public void printDetails(){
    super.printDetails();
    System.out.println("Variant = " + this.variant);
    
  }
  
}