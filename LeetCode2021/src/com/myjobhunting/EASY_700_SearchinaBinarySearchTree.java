package com.myjobhunting;

// https://leetcode.com/problems/search-in-a-binary-search-tree/

/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
If such a node does not exist, return null.

Example 1:
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:
Input: root = [4,2,7,1,3], val = 5
Output: []

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 10^7
root is a binary search tree.
1 <= val <= 10^7
 */
public class EASY_700_SearchinaBinarySearchTree {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
    Memory Usage: 42.9 MB, less than 82.31% of Java online submissions for Search in a Binary Search Tree.
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        else if(root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }
}
