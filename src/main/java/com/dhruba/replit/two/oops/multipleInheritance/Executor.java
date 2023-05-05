package two.oops.multipleInheritance;

class Executor{
  
  public static void main(String args[]){

    Elantra baseModel = new Elantra(2019, "XE");
    Elantra topModel = new Elantra(2020, "IMT");

    baseModel.printDetails();
    baseModel.bootspace();

    topModel.printDetails();
    topModel.bootspace();
  }
}