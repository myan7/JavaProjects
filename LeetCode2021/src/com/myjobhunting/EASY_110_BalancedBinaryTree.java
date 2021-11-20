package com.myjobhunting;




//[1,2,2,3,3,null,null,4,4]
//[3,9,20,null,null,15,7]
/* https://leetcode.com/problems/balanced-binary-tree/ */
public class EASY_110_BalancedBinaryTree {
    int left = 1;
    int right = 1;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        maxDepthLeft(root,left);
        maxDepthRight(root,right);
        return Math.abs(left -right) == 1;
    }

    private void maxDepthLeft(TreeNode node,int currDepth)
    {
        if(node == null)
            return ;
        maxDepthLeft(node.left,currDepth+1);
    }

    private void maxDepthRight(TreeNode node,int currDepth)
    {
        if(node == null)
            return;
        maxDepthLeft(node.right,currDepth+1);
    }
}
