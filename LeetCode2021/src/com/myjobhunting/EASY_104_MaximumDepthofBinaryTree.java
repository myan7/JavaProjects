package com.myjobhunting;


/* https://leetcode.com/problems/maximum-depth-of-binary-tree/ */

public class EASY_104_MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }

    private int depth;
    public int maxDepth2(TreeNode root)
    {
        int depth = 0;
        helper(root, 1);
        return depth;
    }

    public void helper(TreeNode root, int currDepth)
    {
        if(root == null)
            return;

        if(currDepth > depth)
        {
            depth = currDepth;
        }

        helper(root.left, currDepth+1);
        //System.out.println("after left "+currDepth);
        helper(root.right, currDepth+1);
        //System.out.println("after right "+currDepth);
    }

    public int maxDepth3(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        int[] res = new int[1];
        helper3(root,depth,res);
        return res[0];
    }

    public void helper3(TreeNode n, int depth, int[] res)
    {
        if(n.left == null && n.right == null)
            res[0] = Math.max(depth,res[0]);
        if(n.left != null)
        {
            helper3(n.left,depth+1,res);
        }
        if(n.right != null )
        {
            helper3(n.right,depth+1,res);
        }
    }

}
