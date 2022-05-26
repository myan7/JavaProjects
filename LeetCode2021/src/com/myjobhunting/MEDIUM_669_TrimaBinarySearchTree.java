package com.myjobhunting;

// https://leetcode.com/problems/trim-a-binary-search-tree/


/*
Given the root of a binary search tree and the lowest and highest boundaries as low and high,
trim the tree so that all its elements lies in [low, high].
Trimming the tree should not change the relative structure of the elements that will remain in the tree
(i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree.
Note that the root may change depending on the given bounds.

Example 1:
Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]

Example 2:
Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]

Constraints:
The number of nodes in the tree in the range [1, 104].
0 <= Node.val <= 10^4
The value of each node in the tree is unique.
root is guaranteed to be a valid binary search tree.
0 <= low <= high <= 10^4
 */
public class MEDIUM_669_TrimaBinarySearchTree {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Trim a Binary Search Tree.
    Memory Usage: 41.9 MB, less than 84.81% of Java online submissions for Trim a Binary Search Tree.
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Trim a Binary Search Tree.
    Memory Usage: 42.2 MB, less than 81.50% of Java online submissions for Trim a Binary Search Tree.
     */
    public TreeNode trimBST_iterative(TreeNode root, int low, int high) {
        // Fix root
        while (root != null) {
            if (root.val < low) {
                root = root.right;
            } else if (root.val > high) {
                root = root.left;
            } else {
                break;
            }
        }
        if (root == null) return root;

        // Everyone to left  of root is less than "high",
        // so we only need to check for "low"
        TreeNode left = root;
        while (left.left != null) {
            if (left.left.val < low) {
                left.left = left.left.right;
            } else {
                left = left.left;
            }
        }

        // Everyone to right  of root is more than "low",
        // so we only need to check for "high"
        TreeNode right = root;
        while (right.right != null) {
            if (right.right.val > high) {
                right.right = right.right.left;
            } else {
                right = right.right;
            }
        }

        return root;
    }

}
