package two.oops;

class ConstructorExample{

  private int day;
  private int month;
  private int year;
  private String event;

  //default constructor
  public ConstructorExample(){
    this.day=0;
    this.month=0;
    this.year=0;
  }

  //parameterized constructor
  public ConstructorExample(int day, int month, int year){
    this.day=day;
    this.month=month;
    this.year=year;
  }

  //calling constructor from a constructor using this()
  public ConstructorExample(int day, int month, int year, String event){
    this(day, month, year);
    this.event = event;
  }

  public void printDate(){
    System.out.println("Date is " + day + "/" + month + "/" + year + " : New Year");
  }

  public static void main(String args[]){
    ConstructorExample ce = new ConstructorExample(1,1,2022,"New Year");
    ce.printDate();
  }
}