Consumers take a parameter but do not produce anything.

| Interface Name  |  Description | Abstract Method  |
|---|---|---|
Consumer<T>|Accept a reference type argument and returns void|void accept(T t)|
DoubleConsumer|Accepts a double value argument and returns void | void accept(double d)|
IntConsumer|Accepts a int value argument and returns void | void accept(int i)|
LongConsumer|Accepts a long value argument and returns void | void accept(long l)|
BiConsumer<T,U>|Accepts two reference type arguments and returns void| void accept(T t, U u)|
ObjDoubleConsumer<T>|Accepts an object value and a double value argument and returns void|void accept(T t, double value)|
ObjIntConsumer<T>|Accepts an object value and a int value argument and returns void|void accept(T t, int value)|
ObjLongConsumer<T>|Accepts an object value and a long value argument and returns void|void accept(T t, long value)|

Chaining - andThen() -- usage - consumer1.andThen(consuemr2) - returns a composed consumer that performs consumer1 function followed by consumer2 function