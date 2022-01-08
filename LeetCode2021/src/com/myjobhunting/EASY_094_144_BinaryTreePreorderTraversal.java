package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

// Preorder (Root, Left, Right)
        /*Algorithm Preorder(tree)
        1. Visit the root.
        2. Traverse the left subtree, i.e., call Preorder(left-subtree)
        3. Traverse the right subtree, i.e., call Preorder(right-subtree)
        for example   1
                    2   3
                  4   5
        Pre order will be display the tree as [1 2 4 5 3]
        */

public class EASY_094_144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        preorderTraversalHelper(root, ans);
        return ans;
    }

    public void preorderTraversalHelper(TreeNode root, List<Integer> ans)
    {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorderTraversalHelper(root.left, ans);
        preorderTraversalHelper(root.right, ans);
    }
}
