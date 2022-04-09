package com.myjobhunting;

// https://leetcode.com/problems/invert-binary-tree/

public class EASY_226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode node = new TreeNode(root.val);
        node.left = invertTree(root.right);
        node.right = invertTree(root.left);
        return node;
    }
}
