package com.myjobhunting;

// https://leetcode.com/problems/design-hashset/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)


Constraints:

0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.
 */
public class EASY_705_DesignHashSet {

    /*
    Runtime: 585 ms, faster than 13.60% of Java online submissions for Design HashSet.
    Memory Usage: 50.1 MB, less than 83.83% of Java online submissions for Design HashSet.
     */
    class MyHashSet {
        List<Integer> list;
        int index;
        public MyHashSet() {
            list = new ArrayList<>();
        }

        public void add(int key) {
            index = binarySearch(list, key);
            if(index == -1)
                list.add(key);
            Collections.sort(list);
        }

        public void remove(int key) {
            index = binarySearch(list,key);
            if(index != -1)
                list.remove(index);
        }

        public boolean contains(int key) {
            index = binarySearch(list,key);
            if(index == -1)
                return false;
            return true;
        }

        private int binarySearch(List<Integer> list, int key)
        {
            int left = 0, right = list.size()-1;
            while(left <= right)
            {
                int mid = left + (right -left)/2;
                if(list.get(mid) == key)
                    return mid;
                else if(list.get(mid) < key)
                    left = mid + 1;
                else
                    right = mid -1;
            }
            return -1;
        }
    }

    /*
    Runtime: 28 ms, faster than 54.83% of Java online submissions for Design HashSet.
    Memory Usage: 81.7 MB, less than 18.51% of Java online submissions for Design HashSet.
     */
    class MyHashSet2 {
        boolean[] arr;
        public MyHashSet2() {
            arr = new boolean[1000001];
        }

        public void add(int key) {
            arr[key] = true;
        }

        public void remove(int key) {
            arr[key] = false;
        }

        public boolean contains(int key) {
            return arr[key];
        }
    }

    /*
    Runtime: 141 ms, faster than 21.55% of Java online submissions for Design HashSet.
    Memory Usage: 56.6 MB, less than 56.77% of Java online submissions for Design HashSet.
     */
    class MyHashSet3 {
        private List<List<Integer>> table;
        int index;
        public MyHashSet3() {
            table = new ArrayList<>();
            for(int i = 0; i< 10; i++)
                table.add(null);
        }

        public void add(int key) {
            index = key%10;
            List<Integer> child = table.get(index);
            if(child == null)
            {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                table.set(index, list);
            }
            else
            {
                if(!child.contains(key))
                    child.add(key);
            }
        }

        public void remove(int key) {
            index = key%10;
            int pos = findpos(key);
            if(pos != -1)
                table.get(index).remove(pos);

        }

        public boolean contains(int key) {
            index = key%10;
            if(table.get(index) == null)
                return false;
            for(int val : table.get(index))
                if(val == key)
                    return true;
            return false;
        }

        private int findpos(int key)
        {
            index = key%10;
            if(table.get(index) == null)
                return -1;
            for(int i = 0; i < table.get(index).size(); i++)
                if(table.get(index).get(i) == key)
                    return i;
            return -1;
        }
    }

    /*
    Runtime: 14 ms, faster than 89.44% of Java online submissions for Design HashSet.
    Memory Usage: 48.9 MB, less than 95.89% of Java online submissions for Design HashSet.
     */
    class MyHashSet4 {
        private List<List<Integer>> table;
        int index;
        int CONST = 769;
        public MyHashSet4() {
            table = new ArrayList<>();
            for(int i = 0; i< CONST; i++)
                table.add(null);
        }

        public void add(int key) {
            index = key%CONST;
            List<Integer> child = table.get(index);
            if(child == null)
            {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                table.set(index, list);
            }
            else
            {
                if(!child.contains(key))
                    child.add(key);
            }

        }

        public void remove(int key) {
            index = key%CONST;
            int pos = findpos(key);
            if(pos != -1)
                table.get(index).remove(pos);

        }

        public boolean contains(int key) {
            index = key%CONST;
            if(table.get(index) == null)
                return false;
            for(int val : table.get(index))
                if(val == key)
                    return true;
            return false;
        }

        private int findpos(int key)
        {
            index = key%CONST;
            if(table.get(index) == null)
                return -1;
            for(int i = 0; i < table.get(index).size(); i++)
                if(table.get(index).get(i) == key)
                    return i;
            return -1;
        }
    }

    /*
    Runtime: 17 ms, faster than 82.02% of Java online submissions for Design HashSet.
    Memory Usage: 56.2 MB, less than 67.49% of Java online submissions for Design HashSet.
     */
    class MyHashSet_LC {
        private Bucket[] bucketArray;
        private int keyRange;

        /** Initialize your data structure here. */
        public MyHashSet_LC() {
            this.keyRange = 769;
            this.bucketArray = new Bucket[this.keyRange];
            for (int i = 0; i < this.keyRange; ++i)
                this.bucketArray[i] = new Bucket();
        }

        protected int _hash(int key) {
            return (key % this.keyRange);
        }

        public void add(int key) {
            int bucketIndex = this._hash(key);
            this.bucketArray[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = this._hash(key);
            this.bucketArray[bucketIndex].delete(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int bucketIndex = this._hash(key);
            return this.bucketArray[bucketIndex].exists(key);
        }
    }


    class Bucket {
        private BSTree tree;

        public Bucket() {
            tree = new BSTree();
        }

        public void insert(Integer key) {
            this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
        }

        public void delete(Integer key) {
            this.tree.root = this.tree.deleteNode(this.tree.root, key);
        }

        public boolean exists(Integer key) {
            TreeNode node = this.tree.searchBST(this.tree.root, key);
            return (node != null);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class BSTree {
        TreeNode root = null;

        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || val == root.val)
                return root;

            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }

        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null)
                return new TreeNode(val);

            if (val > root.val)
                // insert into the right subtree
                root.right = insertIntoBST(root.right, val);
            else if (val == root.val)
                // skip the insertion
                return root;
            else
                // insert into the left subtree
                root.left = insertIntoBST(root.left, val);
            return root;
        }

        /*
         * One step right and then always left
         */
        public int successor(TreeNode root) {
            root = root.right;
            while (root.left != null)
                root = root.left;
            return root.val;
        }

        /*
         * One step left and then always right
         */
        public int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null)
                root = root.right;
            return root.val;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;

            // delete from the right subtree
            if (key > root.val)
                root.right = deleteNode(root.right, key);
                // delete from the left subtree
            else if (key < root.val)
                root.left = deleteNode(root.left, key);
                // delete the current node
            else {
                // the node is a leaf
                if (root.left == null && root.right == null)
                    root = null;
                    // the node is not a leaf and has a right child
                else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                }
                // the node is not a leaf, has no right child, and has a left child
                else {
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
            }
            return root;
        }
    }

}
