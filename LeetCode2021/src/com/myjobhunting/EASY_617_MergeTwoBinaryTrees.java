package com.myjobhunting;

// https://leetcode.com/problems/merge-two-binary-trees/
// Algorithm I Day 8

public class EASY_617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return null;
        else if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        } else {
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
        }
        return root1;
    }


//root1 - [9,-1,null,-2,0,-4,null,null,8,-5,-3,6,null,null,null,null,null,null,7]
//root2 - [-1,-2,0,null,null,null,8,6,null,null,7]
//output - [8,-1,0,-2,0,null,8,-4,null,null,8,6,null,-5,-3,6,null,null,7,null,null,null,null,null,7]
//expect - [8,-3,0,-2,0,null,8,-4,null,null,8,6,null,-5,-3,6,null,null,7,null,null,null,null,null,7]

// this is because when I coded, I didn't add root1.left = , and root1.right =
// I just called those 2 functions for left and right subtrees, without saving them.

}
