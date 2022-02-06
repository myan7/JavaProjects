package com.myjobhunting;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/*
According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined
between two nodes p and q as the lowest node in T
that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class EASY_235_LowestCommonAncestorofaBinarySearchTree {



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /*
        Traverse tree from root.
        If both p and q are > root.val check on right subtree  (all values to the right of node are greater than that)
        If both p and q are < root.val check on left subtree   (all values to the left of node are less than that)
        else return root
        */
        if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }

    // this will fail, because BST is not necessarily balanced
    // as long as the max diffs of leaf nodes is 1.
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        int count = 0;
        if(root.val == p.val || root.val == q.val)
            count++;
        if(root.left.val == p.val || root.left.val == q.val)
            count++;
        if(root.right.val == p.val || root.right.val == q.val)
            count++;

        if(count == 2)
            return root;
        else
        {
            if(root.val > p.val && root.val >q.val)
                return lowestCommonAncestor(root.left,p,q);
            else
                return lowestCommonAncestor(root.right,p,q);
        }
    }

}
