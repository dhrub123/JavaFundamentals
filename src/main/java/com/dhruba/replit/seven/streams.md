Streams
-------
A stream in Java is a sequence of elements from a source that supports aggregate operations. The source can be a collection or an array or I/O channels.
1. Stream is not a data structure. It is just a bunch of operations applied to a source.
2. It does not change the original data source.
3. A stream can be transformed into another stream by one or more intermediate operations. They are lazily executed.
4. Terminal operations produce the result of a stream.
5. For primitive types there is IntStream, LongStream and DoubleStream interfaces. For objects there is Stream<T>
6. Intermediate Operations: They do not produce any results. They return a new stream. e.g. : filter() and map() etc.
7. Terminal Operations: They produce results. e.g. : count(), toArray(..) and collect(..)
8. Streams operations can also be classified into filtering, slicing, mapping, matching and finding, reduction and collect.

Filtering operations
--------------------
They filter a given stream and return a new stream containing only elements required for next operation.
filter() - Stream filter(Predicate<? super T> predicate)

Map operations
--------------
They transform elements of a stream and return a new stream with the transformed elements.
map() -> Takes a lambda as argumentand uses it to change individual elements of a stream - <R> Stream<R> map(Function<? super T, ? extends R> mapper)
flatmap() -> to flatten a stream of collections to a stream of elements combined from all collections e.g.: 
1. Stream<String[]> -> flatMap -> Stream<String>
2. Stream<Set<String>> -> flatMap -> Stream<String>
3. Stream<List<String>> -> flatMap -> Stream<String>

We need to use flatmap because intermediate methods like filter() and distinct() will not work on streams of collections. So we need to flatten the stream of collections to stream of elements first.

Method References:
------------------

Consumer<String> consumer = s -> System.out.println(s); can be written as Consumer<String> consumer = System.out::println;

Function<Person, Integer>  function = p  -> p.getAge(); can be written as Function<Person, Integer>  function = Person::getAge;

There are 4 kinds of methods references:
1. Static methods -> Classname::MethodName
2. Instance method of a particular object  -> ReferenceVariable::MethodName
3. Instance method of arbitrary object -> Classname::MethodName
4. Constructor Reference -> ClassName::new

Optional
--------
Optional acts as a wrapper and provides a lot of utility methods.
1. empty() - creates an empty optional which contains a null value.
   ```Optional<Person> person = Optional.empty();```
2. of() - for created an object with non null value
   ```Person person = new Person(); Optional<Person> optional = Optional.of(person);```
3. ofNullable() - when we are not sure if the value of object will be null or not

Reduction
---------
Reduces stream to a single value. These operations are immutable, they reduce the result to a single values immutable variable.
e.g. : sum of all elements

1. Identity – an element that is the initial value of the reduction operation and the default result if the stream is empty.
2. Accumulator – a function that takes two parameters: a partial result of the reduction operation and the next element of the stream.
3. Combiner – a function used to combine the partial result of the reduction operation when the reduction is parallelized or there’s a mismatch between the types of the accumulator arguments and the types of the accumulator implementation.

Collectors
----------
This is mutable reduction and is terminal method. The results are collected in an array or Collection object. There are 2 versions of the collect method.
```
1. collect(Collector<? super T,A,R> collector)
2. <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
```

Collectors class
----------------
|Method| 	Purpose|
|------|---------|
|toList() |	Collects stream elements in a List.|
|toSet() |	Collects stream elements in a Set.|
|toMap()|Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.|
|collectingAndThen() 	|Collects stream elements and then transforms them using a Function|
|summingDouble(), summingLong(), summingInt() 	|Sums-up stream elements after mapping them to a Double/Long/Integer value using specific type Function|
|reducing() 	|Reduces elements of stream based on the BinaryOperator function provided|
|partitioningBy() 	|Partitions stream elements into a Map based on the Predicate provided|
|counting() 	|Counts the number of stream elements|
|groupingBy() 	|Produces Map of elements grouped by grouping criteria provided|
|mapping() 	|Applies a mapping operation to all stream elements being collected|
|joining() 	|For concatenation of stream elements into a single String|
|minBy()/maxBy() 	|Finds the minimum/maximum of all stream elements based on the Comparator provided|

Parallel Stream
---------------
1. parallelStream()
2. existing stream can be converted to parallel stream using parallel()

A parallel stream has a lot of overhead compared to a serial one.
So parallel stream shoudl only be used when 
1. there is a large amount of data to process.
2. We have a performance problem
3. All the shared resources between threads need to be synched properly

NQ Formula
----------
N x Q > 10000 where N = number of data items and Q = amount of work per item

Lazy Evaluation in stream
-------------------------
In streams, the intermediated operations are not evaluated until a terminal operation is invoked.

Each intermediate operation creates a new stream, stores the provided operation/function, and returns the new stream. When a terminal operation is called, the traversal of streams begins and the associated function is performed one by one on each element.



