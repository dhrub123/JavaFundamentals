Interface is 100 percent abstraction. no concrete methods.
An interface can extend another interface and a class can implement multiple interfaces.
An interface cannot be private or protected. An interface also cannot have constructors.

After java 8, interface can have implementations as default method.
But that leads to diamond problem of multiple inheritance in case a class implements multiple interfaces with same default method.
So we have to either override the default method or use syntax like InterfaceA.super.test();
where test() is the default method in InterfaceA.

interface InterfaceA{

  default void test(){
    System.out.println("Default Test from InterfaceA");
  }
}

interface InterfaceB{

  default void test(){
    System.out.println("Default Test from InterfaceB");
  }

  static void testStatic(){
    System.out.println("Static Test from InterfaceB");
  }
}

class Diamond implements InterfaceA,InterfaceB{
  //this leads to diamond problem
  //so we have to either override test or do
  InterfaceA.super.test();
  InterfaceB.super.test();
}

After java8, we can also have static method in interfaces which behaves same as default with the exception that we cannot override it in concrete class. We cannot also call the static method using the concrete class like diamond.testStatic(); Instead we call it like InterfaceB.testStatic();

Functional interfaces are interfaces with only one abstract method. They can have other default methods as well. They are annotated by @FunctionalInterface. If this annotation is added , the compiler will not allow multiple abstract methods in the interface.

@FunctionalInterface
public interface ExampleFunctionalInterface{
  void test(); // only one abstract method

  default void testMem(){
    System.out.println("Test");
  }
}

Multiple inheritance is implemented by combining inheritance and interfaces