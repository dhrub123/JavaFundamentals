LinkedList implements List and Deque interface.
1. Elements are inserted in order of insertion
2. Supports duplicate elements and any number of null elements.

Internal Implementation:

LinkedList has a static inner class called node having three fields - item -> contains value of current element, next -> pointer to next element, prev -> pointer to previous element. So it is basically a doubly linked list which has references to both previous and next node.
When a new element is added to a linkedlist, a new node is created and the previous and next is set depending on the location of the element. When a node is removed at index i, the next field of the node at i-1 becomes i+1 and the previous field of the node at i+1 becomes i-1.

Time complexities: 
1. Adding an element - o(1) if at beginning or end and o(n) if position of insertion needs to be searched but this is rare. The benefit is when an element is added in a linked list, other elements are not rearranged.
2. Removing an element - o(1) if we know position of element to remove and o(n) if we need to search and remove element.
3. Searching element - o(n)

Creating a Linked List: 
1. List<Integer> list = new LinkedList<Integer>();
2. List<Integer> list = new LinkedList<Integer>(oldList);

Inserting an element in a Linked List:
1. add(E e) or addlast(E e) -> adds element at end of list.
2. add(int index, E e) -> add element at a particular index.
3. addAll(anotherList) -> all elements of another list will be added at the end.

Fetching element from LinkedList:
1. getFirst() - get first element of linked list
2. getlast() - get last element of linked list
3. get(int index) - get element at a particular index

Removing element from LinkedList:
1. removeFirst() - remove first element of linked list
2. removelast() - remove last element of linked list
3. remove(int index) - remove element at a particular index
4. remove(Object o) - remove particular element, first occurence
5. removeLastOccurence(Object o) - remove particular element, last occurence

Sorting LinkedList: 
Collections.sort(linkedList)