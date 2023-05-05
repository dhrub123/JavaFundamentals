Class in java.utils package that implements Map interface. It stores key-value pair.
1. Keys should be unique and only one null key allowed.
2. Keys are stored in random order.
3. Values can be null or duplicate.

Create a hashmap:
1. Map<String,Integer> map = new Hashmap() - created using a no arg constructor. A hashmap with an initial capacity of 16 and load factor of .75 is created. So it will be resized when the hashmap has 12 elements.(16*.75). During a resize, the capacity of hashmap is doubled. So there is now index 0 to 31. All the elements in the hashmap will be rearranged among these 32 buckets. This is a time consuming operation as the index for each key needs to be calculated.
2. Using constructor with initial capacity.- load factor will default to .75. This reduces number of resizes.
3. Using contructor with initial capacity and load factor to avoid frequent resizing.
4. Using constructor which takes another map as parameter. Size will be same as passed map and load factor will be .75

Insertion: 
1. put(k key, v value) - if key not present, a new key value pair will be inserted, if key is present, value will be updated.
2. putIfAbsent(k key, v value) - if key not present, a new key value pair will be inserted, if key is present, value will not be updated.
3. putAll(Map) - copied all contents of a map to specified map. Any existing mappings for any keys will be replaced.

Fetching:
1. get(object key) - takes key as parameter and returns value corresponding to key. If key is not present, returns null.
2. getOrDefault(object key) - if key is present, then corresponding value is returned, else default value is returned.

Replacing:
1. replace(K key, V oldValue, V newValue) - if current value of key is equal to old value passed, it replaces old value with new value and returns true, else returns false
2. replaceAll(biFunction) - replaces values of all keys with the result of the provided bifunction - replaceAll((k,v) -> v + 10);

Removal:
1. remove(Object key) - removes key from map if presnet and returns value of key removed. If key not present, returns null.
2. remove(Object key, Object value) - removes key from map only if value of key matches passed value and returns true, else returns false.

Additional operations:
1. Check if Key is present in HashMap: - containsKey(Object key) - returns true if key is presnt else false
2. Check if Value is present in HashMap: - containsValue(Value v) - returns true if one or more keys are mapped to the specified value
3. Fetch all keys of hashmap - keySet() - returns set of all keys present in hashmap - Set<String> keys = stockPrice.keySet();
4. Fetch all values of hashmap - values() - returns a collection containing all values in map - Collection<Integer> values = stockPrice.values();
5. Check if hashmap is empty - isEmpty() - returns true if map does not have any elements and false if elements are present

Linked Hash Map:
Same as hashMap with one difference, each entry maintains a record of the entry after and before it. It also keeps track of the first and lat element as head and tail in the doubly linked list.

1. No duplicates
2. one null key and many null vlaues allowed

Create LinkedHashMap :
1. no-arg constructor LinkedHashMap() - default capacity of 16 and load factor of .75. Elements are stored in insertion order.
2. constructor taking initial capacity - LinkedHashMap(int capacity)
3. constructor taking initial capacity and load factor - LinkedHashMap(int capacity, float loadFactor)
4. constructor with access order flag - LinkedHashMap(int capacity, float loadFactor, boolean accessOrder) - if accessOrder flag is false, elements are stored in insertion order, else elements are stored in order of access(most recently accessed element is kept last)
5. constructor with another map - initial capacity is capacity of passed map and load factor is .75

Inserting into LinkedHashMap:

1. put(); - elements are stored in insertion order
2. if accessflag is true, elements are stored in order of access

