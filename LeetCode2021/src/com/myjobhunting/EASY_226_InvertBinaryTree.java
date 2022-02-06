package com.myjobhunting;

// https://leetcode.com/problems/invert-binary-tree/

public class EASY_226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode r = root.right;

        root.right = root.left;
        root.left = r;

        root.right = invertTree(root.right);
        root.left = invertTree(root.left);
        return root;
    }
}
