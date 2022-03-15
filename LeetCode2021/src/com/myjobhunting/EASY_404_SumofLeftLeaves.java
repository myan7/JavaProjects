package com.myjobhunting;
// https://leetcode.com/problems/sum-of-left-leaves/

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given the root of a binary tree, return the sum of all left leaves.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:
Input: root = [1]
Output: 0

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
 */
public class EASY_404_SumofLeftLeaves {

    /*
    Runtime: 2 ms, faster than 7.31% of Java online submissions for Sum of Left Leaves.
    Memory Usage: 41.9 MB, less than 44.16% of Java online submissions for Sum of Left Leaves.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int total = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty())
        {
            TreeNode subRoot = stack.pop();
            // check if the left node is a leaf node
            if(isLeaf(subRoot.left))
                total += subRoot.left.val;

            // if the right node exists, put it on the stack;
            if(subRoot.right != null)
                stack.push(subRoot.right);

            // if the left node exists, put it on the stack;
            if(subRoot.left != null)
                stack.push(subRoot.left);
        }
        return total;
    }
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    /*
    Runtime: 1 ms, faster than 30.06% of Java online submissions for Sum of Left Leaves.
    Memory Usage: 42.4 MB, less than 12.87% of Java online submissions for Sum of Left Leaves.
     */
    private int sum = 0;
    public int sumOfLeftLeaves1(TreeNode root) {
        helper(root, null);
        return sum;
    }

    private void helper(TreeNode root, TreeNode p){
        if(root == null)
            return;
        if(root.left == null && root.right == null && p != null && p.left == root)
            sum += root.val;
        helper(root.left, root);
        helper(root.right, root);
    }
}
