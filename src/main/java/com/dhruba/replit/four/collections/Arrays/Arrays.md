Arrays is a class in java.utils package which has methods for searching and sorting arrays.

Searching element in Array - Arrays.binarySearch(numbers,4); - does a binary search on numbers array for element 4.
1. array passed as argument should be sorted
2. index of the element is returned. If element is not present, index of first element in array greater than element specified is returned
3. No guarantee if there are duplicates
4. Complexity of binary search is o(logn) vs that of linear search o(n)
5. We can also mention start and end index of an array to search through part of an array. - Arrays.binarySearch(numbers, 5, 9, 4);
6. In order to binary search through an array of objects, the object should implement comparable or we should pass a comparator to the binary search.

Sorting an Array:
sort() method - quicksort is used for primitives and merge sort for objects.
1. sort(array) - sorts full aray in ascending order
2. sort(array,fromIndex,toIndex) - sorts only elements from fromIndex and toIndex
3. parallelSort() = introduced in java8. The earlier sort() methods were sequential sorts. Now the array is broken down into subarrays that are sorted and results merged. There are few conditions. if array size <= 8192 or only 1 core in processor, then sequential sort performed, else parallel sort