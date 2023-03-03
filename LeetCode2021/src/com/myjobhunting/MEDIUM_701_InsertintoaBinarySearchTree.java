package com.myjobhunting;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/

/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree.
Return the root node of the BST after the insertion.
It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion,
as long as the tree remains a BST after insertion. You can return any of them.

Example 1:
Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:
Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]

Example 3:
Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-10^8 <= Node.val <= 10^8
All the values Node.val are unique.
-10^8 <= val <= 10^8
It's guaranteed that val does not exist in the original BST.
 */
public class MEDIUM_701_InsertintoaBinarySearchTree {


    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
    Memory Usage: 43.6 MB, less than 74.09% of Java online submissions for Insert into a Binary Search Tree.
     */
    public TreeNode insertIntoBST_rec(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        // insert into the right subtree
        if (val > root.val)
            root.right = insertIntoBST_rec(root.right, val);
            // insert into the left subtree
        else
            root.left = insertIntoBST_rec(root.left, val);
        return root;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
    Memory Usage: 43 MB, less than 84.12% of Java online submissions for Insert into a Binary Search Tree.
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            // insert into the right subtree
            if (val > node.val) {
                // insert right now
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                else node = node.right;
            }
            // insert into the left subtree
            else {
                // insert right now
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                else node = node.left;
            }
        }
        return new TreeNode(val);
    }
}