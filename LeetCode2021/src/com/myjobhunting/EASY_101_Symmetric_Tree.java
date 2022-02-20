package com.myjobhunting;

import java.util.Stack;

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

    // iteration no recursion
    public boolean isSymmetric1(TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }

        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;

            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }

        return true;
    }
}
