Functional Programming - Functions can exist outside the scope of objects. We can assign functions to a reference variable or pass them as parameters to another method. A lambda expression is an anonymous function which is not bound to an identifier and can be passes as a parameter to other methods.

Example:

Step 1
------
```
Greeting.java
--------------
@FunctionalInterface
public interface Greeting{
  void greet();
}

Exec.java
---------
public class Exec{
  public static void wish(Greeting greeting){
    greeting.greet();
  }
  //Uses anonymous class
  public static void main(String[] args){
    wish(new Greeting(){
      @Override
      public void greet(){
        System.out.println("Hello");
      }
    });
  }
}
```

Step 2
------
The compiler knows that wish(Greeting greeting) takes a parameter of type Greeting. So we do not need to create an anonymous class here.
```
Greeting.java
--------------
@FunctionalInterface
public interface Greeting{
  void greet();
}

Exec.java
---------
public class Exec{
  public static void wish(Greeting greeting){
    greeting.greet();
  }
  
  public static void main(String[] args){
    wish(
      public void greet(){
        System.out.println("Hello");
      }
    );
  }
}
```
Step 3
------
Greeting interface has only one method, so no need for method name. Also since the method does not return anything, no need for return type. And since there is a single line, no need for curly braces.
```
Greeting.java
--------------
@FunctionalInterface
public interface Greeting{
  void greet();
}

Exec.java
---------
public class Exec{
  public static void wish(Greeting greeting){
    greeting.greet();
  }
  
  public static void main(String[] args){
    wish(
      () -> System.out.println("Hello");//-> declares a lambda expression
    );
  }
}
```


