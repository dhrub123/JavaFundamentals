HashSet is a class in java.utils package.
1. Does not allow duplicate elements
2. Allows only one null element
3. Elements are inserted in random order
4. Internally backed by a hashmap

Create a HashSet:
1. Set<Integer> set = new HashSet<>(); -> This creates a hashset of initial capacity 16 and load factor of 0.75 which means the set will be resized when it is 75 percent full.
2. Use a constructor with initial capacity -> to avoid frequent resizing
3. Use a constructor with initial capacity and load factor
4. Use a constructor that takes another set -> capacity will be set to capacity of set passed as argument but load factor will default to .75

Inserting element:
set.add(E e); -> If the element is not already present, then the element is inserted and true is returned. If present, false is returned.

Fetching Element:
set.contains(E e); -> elements are stored in random order in hashset, so we cannot get them but we can check if set contains the element.

Remove Element:
1. set.remove(Object o); -> if element is removed, true returned else false returned.
2. set.clear(); -> removes all elements from set
3. set.isEmpty() -> returns true if set is empty