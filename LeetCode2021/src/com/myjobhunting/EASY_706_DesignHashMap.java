package com.myjobhunting;

// https://leetcode.com/problems/design-hashmap/

import java.util.LinkedList;

/*
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

Example 1:
Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

Constraints:
0 <= key, value <= 10^6
At most 10^4 calls will be made to put, get, and remove.
 */
public class EASY_706_DesignHashMap {

    /*
    Runtime: 24 ms, faster than 70.69% of Java online submissions for Design HashMap.
    Memory Usage: 62.2 MB, less than 50.05% of Java online submissions for Design HashMap.
     */
    class MyHashMap {
        LinkedList<Entry>[] map;
        final int SIZE  = 977;

        public MyHashMap() {
            map = new LinkedList[SIZE];
        }

        public void put(int key, int value) {
            int bucket = key%SIZE;
            if(map[bucket] == null)
            {
                map[bucket] = new LinkedList<Entry>();
            }
            else
            {
                for(Entry entry: map[bucket])
                {
                    if(entry.key == key)
                    {
                        entry.val = value;
                        return;
                    }
                }
            }
            map[bucket].add(new Entry(key,value));
        }

        public int get(int key) {
            int bucket = key%SIZE;
            LinkedList<Entry> entries = map[bucket];
            if(entries == null)
                return -1;
            for(Entry entry : entries)
            {
                if(entry.key == key)
                    return entry.val;
            }
            return -1;
        }

        public void remove(int key) {
            int bucket = key%SIZE;
            Entry target = null;
            if(map[bucket] == null)
            {
                return;
            }
            else
            {
                for(Entry entry: map[bucket])
                {
                    if(entry.key == key)
                        target = entry;
                }
                map[bucket].remove(target);
            }
        }

        class Entry{
            int key;
            int val;
            public Entry(){}
            public Entry(int key, int val)
            {
                this.key = key;
                this.val = val;
            }
        }
    }

    /*
    Runtime: 18 ms, faster than 87.34% of Java online submissions for Design HashMap.
    Memory Usage: 50 MB, less than 79.38% of Java online submissions for Design HashMap.
     */
    class MyHashMap0 {
        int[] map;

        public MyHashMap0() {
            map = new int[1000001];
        }

        public void put(int key, int value) {
            map[key] = value + 1;
        }

        public int get(int key) {
            return map[key]-1;
        }

        public void remove(int key) {
            map[key] = 0;
        }
    }


}
