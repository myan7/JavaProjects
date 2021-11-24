package com.myjobhunting;




//[1,2,2,3,3,null,null,4,4] false
//[3,9,20,null,null,15,7]  true
//[1,2,2,3,3,null,null,4,4] false
//[1] true
// [1,null,2,null,3] false
/* https://leetcode.com/problems/balanced-binary-tree/ */
public class EASY_110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }

    public int getHeight(TreeNode node)
    {
        if(node==null){
            return 0;
        }
        int lH=getHeight(node.left);
        if(lH==-1){
            return -1;
        }
        int rH=getHeight(node.right);
        if(rH==-1){
            return -1;
        }
        if(Math.abs(lH-rH) > 1 ){
            return -1;
        }
        return Math.max(lH,rH)+1;
    }

    public boolean isBalanced1(TreeNode tree) {
        if (tree == null) return true;
        return (Math.abs(height(tree.left)-height(tree.right))<2)
                && isBalanced1(tree.left)
                && isBalanced1(tree.right);
    }

    public int height(TreeNode tree){
        if (tree == null) return 0;
        return Math.max(height(tree.left)+1,height(tree.right)+1);
    }

    public boolean isBalanced2(TreeNode root) {

        if(root == null)
            return true;
        int left = maxDepthLeft(root,0);
        int right = maxDepthRight(root,0);
        System.out.println("left is " + left);
        System.out.println("right is " + right);
        return Math.abs(left -right) == 1;
    }

    private int maxDepthLeft(TreeNode node,int currDepth)
    {
        if(node.left == null)
            return currDepth;
        return maxDepthLeft(node.left,currDepth+1);
    }

    private int maxDepthRight(TreeNode node,int currDepth)
    {
        if(node.right == null)
            return currDepth;
        return maxDepthLeft(node.right,currDepth+1);
    }
}
