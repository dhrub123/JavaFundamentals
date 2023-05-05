In TreeMap, keys are stored in sorted order.
1. Entries are stored in natural ordering of keys, so the key object must either implement Comparable or a Comparator must be passed while creating TreeMap.
2. Null keys are not allowed nut null values are allowed.

Create a Treemap - 
1. no-arg constructor - Key object must implement Comparable - Map<String, Integer> hashMap = new HashMap<>();
2. constructor with comparator as argument - when keys do not implement comparable or we want custom sorting - TreeMap<String, Integer> reverseMap = new TreeMap<>(Comparator.reverseOrder());
3. constructor with argument type map - a treemap created from another map and keys stored in ascending order. - TreeMap<String, Integer> treeMap1 = new TreeMap<>(hashMap);
4. contructor with argument type sorted map - a treemap created with same ordering as sortedmap - TreeMap<String, Integer> treeMap2 = new TreeMap<>(reverseMap); - here elements will be stored in order of elements in reverse map since it is already sorted

Insert Elements:

1. put(K key, V value) - if key is not present, then new k-v pair will be added, else value will be updated for key
2. putAll(Map m) - copies elements of map to specified map and replace any values for overlapping keys - TreeMap<String, Integer> map = new TreeMap<>(); TreeMap<String, Integer> finalMap = new TreeMap<>();finalMap.putAll(map);

Fetching Element from treemap:
1. get(Object o) - will return value if key present , else null
2. fetching smallest key - firstKey(), for smallest entry - firstEntry()
3. fetching largest key - lastKey(), for largest entry - lastEntry()

Removing Elements : 

1. remove(Object o) - returns previous value for key if present , else null

Update values:
1. replace without checking previous value - replace(key k, value v) - replaces value of specified key with provided value and returns old value which has been updated. If key is not present, null returned.
2. replace after checking previous value - replace(K key, V oldValue, V newValue) - if old value matches value of key present in map, then value is replaced and true is returned, else false is returned.