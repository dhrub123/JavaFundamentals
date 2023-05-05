The supplier interface does not take any argument but produces value when get() is invoked.

| Interface Name  |  Description | Abstract Method  |
|---|---|---|
|Supplier<T>|Represents a supplier of results (reference type)|T get()|
|DoubleSupplier|A supplier of double-value results|double getAsDouble()|
|IntSupplier|A supplier of int-value results|int getAsInt()|
|LongSupplier|A supplier of long-value results|long getAsLong()|
|BooleanSupplier|A supplier of boolean-value results|boolean getAsBoolean()|