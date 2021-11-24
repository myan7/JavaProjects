package com.myjobhunting;

public class EASY_111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)    return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return ( left == 0 || right == 0) ? left+right+1 : Math.min(left, right)+1;
    }

    public int minDepth2(TreeNode root) {
        if(root == null)    return 0;
        int[] res = {Integer.MAX_VALUE};
        helper2(root,1,res);
        return res[0];
    }
    public void helper2(TreeNode n, int currDepth, int[] res)
    {
        if(n.left == null && n.right == null)
            res[0] = Math.min(currDepth, res[0]);
        if(n.left != null )
            helper2(n.left, currDepth+1, res);
        if(n.right!= null)
            helper2(n.right,currDepth+1, res);
    }

// method 3 O(n) DFS
    public int minDepth3(TreeNode root) {
        //base case
        // if there is no node
        if(root == null)
            return 0;
        // if it is a leaf node
        if(root.left == null && root.right == null)
            return 1;

        // if left subtree is empty
        if(root.left == null)
            return 1+minDepth3(root.right);
        // if right subtree is empty
        if(root.right == null)
            return 1+ minDepth3(root.left);

        // if both subtrees are not empty
        return 1+ Math.min(minDepth3(root.left),minDepth3(root.right));
    }

    public int minDepth4(TreeNode root) {
        //base case
        // if there is no node
        if(root == null)
            return 0;
        // if it is a leaf node
        if(root.left == null && root.right == null)
            return 1;

        // if left subtree is empty
        if(root.left == null)
            return 1+minDepth3(root.right);
        // if right subtree is empty
        if(root.right == null)
            return 1+ minDepth3(root.left);

        // if both subtrees are not empty
        return 1+ Math.min(minDepth3(root.left),minDepth3(root.right));
    }
}
