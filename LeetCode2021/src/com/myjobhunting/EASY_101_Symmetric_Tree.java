package com.myjobhunting;

/* https://leetcode.com/problems/symmetric-tree/ */
public class EASY_101_Symmetric_Tree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null || node1.val != node2.val)
            return false;
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    /* beats 89.41% in memory 36.9M */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;
        else
            return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode p, TreeNode q)
    {
        /* both are null */
        if(p == null && q == null)
            return true;
        /* both are not null */
        if(p != null && q != null )
            if(p.val == q.val)
                return isMirror(p.left,q.right) && isMirror(p.right,q.left);
        return false;
    }
}
