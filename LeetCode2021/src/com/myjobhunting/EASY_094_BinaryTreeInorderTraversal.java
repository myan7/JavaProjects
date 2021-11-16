package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

// Inorder traversal left - subtree
// Inorder (Left, Root, Right)
/*      Algorithm Inorder(tree)
        1. Traverse the left subtree, i.e., call Inorder(left-subtree)
        2. Visit the root.
        3. Traverse the right subtree, i.e., call Inorder(right-subtree)
        for example   1
                    2   3
                  4   5
        Inorder traversal will display the tree as [4 2 5 1 3]
*/

public class EASY_094_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        inorderTraversalhelper(root,ans);
        return ans;
    }
    public void inorderTraversalhelper(TreeNode root, List<Integer> ans)
    {
        if (root == null) {
            return;
        }
        inorderTraversalhelper(root.left, ans);
        ans.add(root.val);
        inorderTraversalhelper(root.right,ans);
    }
}

