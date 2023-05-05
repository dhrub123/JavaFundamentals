Function 
--------
It takes an object of type T and returns an object of type R. They allow us to specify input and output type.

| Interface Name  |  Description | Abstract Method  |
|---|---|---|
|BiFunction<T,U,R>	|Represents a function that accepts two arguments and produces a result.|1. R apply(T t,U u) 2. default <V> BiFunction<T,U,V> andThen(Function<? super R,? extends V> after)|
|Function<T,R>|Represents a function that accepts one argument and produces a result.|1.R apply(T t) 2.default <V> Function<V,R> compose(Function<? super V,? extends T> before) 3.default <V> Function<T,V> andThen(Function<? super R,? extends V> after) |

Unary Operator:
--------------
Takes one argument of type T and returns value of same type.

| Interface Name  |  Description | Abstract Method  |
|---|---|---|
|UnaryOperator<T>|Represents an operation on a single operand that produces a result of the same type as its operand (reference type)|T apply(T t)|
|DoubleUnaryOperator|Accepts single double-value operand and produces a double-value result|double applyAsDouble(double operand)|
|IntUnaryOperator|Accepts single int-value operand and produces a int-value result|int applyAsInt(int operand)|
|LongUnaryOperator|Accepts a single long-value operand and produces a long-value result|long applyAsLong(long operand)|

BinaryOperator<T> 
-----------------
It takes only one parameter and the result is of the same type.

| Interface Name  |  Description | Abstract Method  |
|---|---|---|
|BinaryOperator<T>|Represents an operation upon two operands of the same type, producing a result of the same type as the operands (reference type)|T apply(T t, T u)|
|DoubleBinaryOperator|Accepts two double-value operands and produces a double-value result|double applyAsDouble(double left, double right)|
|IntBinaryOperator|Accepts two int-value operands and produces an int-value result|int applyAsInt(int left, int right)|
|LongBinaryOperator|Accepts two long-value operands and produces a long-value result|applyAsLong(long left, long right)|

Capturing Lambdas:
------------------
If a lambda accesses instance variables of its enclosing class or local variables (final or effectively final) from its enclosing scope

It can capture 3 types of variables - Static, Instance and Local(A local variable must be final or effectively final - effectively final means that value is never changed after initialization)