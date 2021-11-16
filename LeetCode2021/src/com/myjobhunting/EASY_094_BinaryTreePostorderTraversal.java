package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

// Postorder (Left, Right, Root) : 4 5 2 3 1
/*  Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
        for example   1
                    2   3
                  4   5
        Postorder traversal will display the tree as [4 5 2 3 1]
*/

public class EASY_094_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        postorderTraversalHelper(root, ans);
        return ans;
    }

    public void postorderTraversalHelper(TreeNode root,List<Integer> ans) {
        if( root == null ) return;
        postorderTraversalHelper(root.left,ans);
        postorderTraversalHelper(root.right,ans);
        ans.add(root.val);
    }
}
