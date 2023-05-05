Features of TreeSet:

1. No duplicates and no null(vs no null in hash set)
2. Since Elements are stored in a tree, access and retrieval is fast
3. Elements are stored in ascending order vs random order in hash set.
4. Hashset is faster for add, remove, contains, size operation etc.
5. A TreeMap is used internally
   
Creating a TreeSet:
1. Set<Integer> set = new TreeSet<>(); -> A treeset with an empty treemap is created.
2. Use Constructor with comparator as argument when the object stored in treeset does not implement Comparable interface or we want to custom sort like in descendign order
3. Use constructor with another collection to store elements from another collection in ascending order.
4. Use constructor with argument as SortedSet to copy elements and store in same order as in sortedset

Insert elements:
1. add(E e) - adds a single element and returns true if element is not already present
2. addAll(Collection<> c) - adds multiple elements from another collection.

To store elements in reverse order(descending):
TreeSet<Integer> reverseSet = new TreeSet<>(Comparator.reverseOrder());

Fetching element:
1. first() - Fetch first element
2. last() - fetch last element
3. subSet(E fromElement, E toElement) - fetches element within given range, fromElement is inclusive and toElement is exclusive
4. headSet(E toElement) - returns elements smaller than provided element. toElement is exclusive
5. tailSet(E fromElement) - returns elements greater than provided element. fromElement is exclusive

Removing element:
1. remove(Object o) - returns true if object is present and is removed, else returns false

Additional operations:
1. isEmpty() - check if treeSet is empty
2. size() - size of treeSet
3. contains(Object o) - if particular element is present - set.contains(new Integer(44));