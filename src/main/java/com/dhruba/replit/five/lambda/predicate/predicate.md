Predicate interface in java.util.function

  | Interface Name  |  Description | Abstract Method  | Other Methods |
|---|---|---|---|
|Predicate<T>|Represents a predicate(boolean-value function) of one argument(reference type)|boolean test(T t)|default Predicate and(Predicate p), default Predicate or(Predicate p), static Predicate isEqual(Obj target), default Predicate negate()|
|DoublePredicate|  Accepts one double value argument|boolean test(double value)||
|IntPredicate|Accepts one int value argument   |boolean test(int value)||
|LongPredicate|Accepts one long value argument   |boolean test(long value)||
|BiPredicate<T,U>|Accepts 2 arguments(reference types)|boolean test(T t, U u)|default BiPredicate<T,U> and(BiPredicate<T, U> other), default BiPredicate<T,U> or(BiPredicate<T, U> other), default BiPredicate<T,U> negate()|