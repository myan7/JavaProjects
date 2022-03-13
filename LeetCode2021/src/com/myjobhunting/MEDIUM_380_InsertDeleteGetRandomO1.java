package com.myjobhunting;
// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.*;

/*
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present.
Returns true if the item was not present, false otherwise.

bool remove(int val) Removes an item val from the set if present.
Returns true if the item was present, false otherwise.

int getRandom() Returns a random element from the current set of elements
(it's guaranteed that at least one element exists when this method is called).
Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

Example 1:
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]
Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.


Constraints:
-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
 */

/*
Runtime: 29 ms, faster than 84.35% of Java online submissions for Insert Delete GetRandom O(1).
Memory Usage: 87.7 MB, less than 96.69% of Java online submissions for Insert Delete GetRandom O(1).
 */
public class MEDIUM_380_InsertDeleteGetRandomO1 {
    HashMap<Integer, Integer> map; // insert and remove are both O(1) but there is no index in map
    List<Integer> list; // list has index, but the remove is O(n).
    // if we can save all the keys in list, to remove some key by index, we can use list, once get the key by index
    // we can remove it from the hashmap, then remove  will become O(1)
    public MEDIUM_380_InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        // map keeps the val and the index;
        list = new ArrayList<>();
        // keeps the val by its index.
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        // remember we need to keep the value in map, and the index in list, the same.
        // if we remove one element in the middle from map and list (remove by index),
        // the information in map and list will not match.
        /* this is wrong
        int index = map.get(val);
        map.remove(val);
        list.remove(index);
         */
        // to keep O(1) for remove, list.remove by index costs O(N), but list remove the last element is O(1)
        // the idea is to replace the one being removed with the last element in the list, to maintain the other element
        // on their position, which is the same information hold by the map.
        int lastElement = list.get(list.size()-1);
        int index = map.get(val);
        // update both list and map to maintain the same information
        list.set(index,lastElement);
        map.put(lastElement,index);
        // remove the val from map, and the last element in the list
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

    public static void main(String[] args)
    {
        int[] t1 = new int[]{51,2,10,63,57};
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int len = t1.length;
        for(int i = 0; i < len; i++)
        {
            map.put(t1[i], i);
            list.add(t1[i]);
        }
        System.out.println(list.toString());
        System.out.println(map.toString());
        // map doesn't maintain the insertion order or save the key value pair in order.
        System.out.println("===========================================I want to remove val = 10");
        // if I want to remove val 10
        /*int index = map.get(10);
        map.remove(10);
        print(map);
        list.remove(index);*/
        // this is going to take O(N) time.
        // but remove the last item is O(1), because the last index is always list.size()-1
//        System.out.println(list.toString());
//        System.out.println(map.toString());
        System.out.println("===========================================I want to remove val = 10 second thought ");
        int index = map.get(10);
        int lastElement = list.get(list.size()-1);

        list.set(index,lastElement);
        map.put(lastElement,index);
        System.out.println(list.toString());
        System.out.println(map.toString());
        System.out.println("after set");
        list.remove(list.size()-1);
        map.remove(10);
        System.out.println(list.toString());
        System.out.println(map.toString());

        String[] strArr = {"abc", "bcd", "cde"};

        try
        {
            List<String> strList = Arrays.asList(strArr);
            System.out.println(strList.toString());
            strList.add(strList.size(),"123");
            strList.add(0,"000");
        }catch (Exception e)
        {
            System.out.println("Exception in thread \"main\" java.lang.UnsupportedOperationException\n" +
                    "\tat java.base/java.util.AbstractList.add(AbstractList.java:153)\n" +
                    "\tat com.myjobhunting.MEDIUM_380_InsertDeleteGetRandomO1.main(MEDIUM_380_InsertDeleteGetRandomO1.java:137)");
        }
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));
        System.out.println(strList.toString());
        strList.add(strList.size(),"123");
        strList.add(0,"000");
        strArr = strList.toArray(new String[strList.size()]);
        for(String s:strArr)
            System.out.print(s + ", ");


        /*list.add(0);
        list.add(1);
        list.add(2);
        list.add(4);
        print(list);
        list.add(3,3);
        print(list);
        list.remove(0);
        print(list);*/
    }

}
