Abstraction can be achieved using abstract keyword or interfaces. Abstraction means telling other classes what things to do, not how to do things.
Abstract Method: 
1) It can only be present in abstract classes or interfaces 2) It cannot have a body 3)It cannot be private since other classes need to implement it.

public void abstract abmethod(parameters);

Abstract Class:
1) It cannot be instantiated 2) It can have normal methods 3) To use an abstract class it must be inherited and the inherited class must implement all abstract methods

abstract class Test {}

generally common methods have implementation in abstract class and specific implementation methods are declared abstract.