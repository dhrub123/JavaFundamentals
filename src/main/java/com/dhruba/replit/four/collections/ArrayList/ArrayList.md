We have Collection Interface extended by List, Set and Queue interface. We also have a seperate Map Interface.

Collection is an interface providing standard data structure functionality while Collections is a class which provides utility methods to search, sort and synchronize collection elements.

ArrayList: java.util.ArrayList
1) Elements are stored in order of insertion.
2) Duplicate as well as null objects can be stored.

ArrayList stores data in an array. Before Java8, an array with default size 10 was created internally. Now an array of size zero is created. This is Lazy Initialization and saves memory. When an element is added to arraylist, only then size of array changes to 10. Before adding element to arraylist, if capacity is full, then a new array of size (n + n/2 + 1) is created and the contents of the old array is copied to the new array.

Time Complexity : 
1) Adding Element - o(1) in most cases, more if array list is full
2) Removing element - o(1) best case and o(n) worst case. There are 2 remove methods - one takes index. This will take o(1) time if last element is removed, else o(n) time because once element at index is removed, the remaining elements to the right needs to be moved left. The other method takes the element to be removed. The array is scanned from beginning to find the element to be removed and this takes o(n) time.
3) Fetch element - this takes constant time o(1)

Creating an Array List : 

1. List list = new ArrayList(); - creates a list of  size 0.
2. List list = new ArrayList(50); - creates a list with initial capacity to avoid frequent resizing.
3. List list1 = new ArrayList(list); - creates a list using an exisiting list.

Inserting Element in an ArrayList: 
1. list.add(Element e) --> adds one element at the end
2. list.add(int index, Element e) --> adds one element at a particular index and shifts remaining elements to the right.
3. list.addAll(list) --> Adds all elements of another list at the end
4. list.addAll(int index,list) --> Adds all elements of another list starting at specified position, shifts rest to right

Parameterized List: It specifies the data type a list can hold.
List<String> list = new ArrayList<String>();

Fetching elements from an ArrayList: 
list.get(int index);
list.size(); --> gets size

Removing elements from a list: 
1. list.remove(int index)
2. list.remove(Object o) --> 1st occurence of element will be removed. Only takes objects, no primitives
3. ArrayList.removeRange(int fromIndex, int toIndex) --> all elements fromIndex inclusive and toindex exclusive will be removed. This is exclusive to arraylist, list will not have it.
4. list.removeAll(Collection c) --> all elements within collection c will be removed from list
5. ArrayList.clear() --> arraylist will be emptied


Replacing elements in ArrayList: 

list.replaceAll(UnaryOperator)
List<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.replaceAll((e) -> e.toUpperCase());

Updating element in ArrayList:
list.update(int index, E e)

Check if list contains element;
list.contains(Object o); --> true/false
list.indexOf(Object o); --> first occurence
list.lastIndexOf(Object o); --> last occurence

