package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

        /*sameTree(tree1, tree2)
        1. If both trees are empty then return 1.
        2. Else If both trees are non -empty
                (a) Check data of the root nodes (tree1->data ==  tree2->data)
        (b) Check left subtrees recursively  i.e., call sameTree(
                tree1->left_subtree, tree2->left_subtree)
        (c) Check right subtrees recursively  i.e., call sameTree(
                tree1->right_subtree, tree2->right_subtree)
        (d) If a,b and c are true then return 1.
        3  Else return 0 (one is empty and other is not)*/

public class EASY_100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*1. both empty */
        if(p == null && q == null)
            return true;
        /* 2. both non-empty -> compare them */
        else if (p != null && q != null)
        {
            return ((p.val == q.val) && (isSameTree(p.left,q.left)) && (isSameTree(p.right, q.right)));
        }
        /* 3. one empty, one not -> false */
        return false;
    }

    public boolean isSameTree2(TreeNode p, TreeNode q)
    {
        if(p==null && q== null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
        {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else
            return false;
    }

    public boolean isSameTree3(TreeNode p, TreeNode q) {
        // return inorderTraversal(p).equals(inorderTraversal(q));
        // wrong answer for [1 null 1] and [1 1]
        // to determine if 2 tree are equal, you have to check

        if(p == null && q == null)
            return true;
        if ((p == null && q != null)|| (p != null && q == null) )
            return false;

        boolean a=false, b=false, c=false;
        if(p.val == q.val)
            a = true;
        if(isSameTree(p.left,q.left))
            b = true;
        if (isSameTree(p.right, q.right))
            c = true;
        return (a && b && c);
    }

    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        inorderTraversalHelper(root,ans);
        return ans;
    }

    public void inorderTraversalHelper(TreeNode root, List<Integer> ans)
    {
        if(root == null)
            return;
        inorderTraversalHelper(root.left,ans);
        ans.add(root.val);
        inorderTraversalHelper(root.right,ans);
    }
}
