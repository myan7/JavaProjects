package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/

/*
Given the root of a binary search tree, and an integer k,
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */
public class MEDIUM_230_KthSmallestElementinaBST {

    // Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
    // and you need to find the kth smallest frequently, how would you optimize?



    /* InOrder Traversal
    Runtime: 1 ms, faster than 70.51% of Java online submissions for Kth Smallest Element in a BST.
    Memory Usage: 42.6 MB, less than 81.80% of Java online submissions for Kth Smallest Element in a BST.
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list.get(k-1);
    }
    private void inOrder(TreeNode root, List<Integer> list)
    {
        if(root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right,list);
    }

}
