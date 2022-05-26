package com.myjobhunting;
// https://leetcode.com/problems/increasing-order-search-tree/

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree,
rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
and every node has no left child and only one right child.

Example 1:
Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Example 2:
Input: root = [5,1,7]
Output: [1,null,5,null,7]

Constraints:
The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000
 */
public class EASY_897_IncreasingOrderSearchTree {



    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
    Memory Usage: 42.2 MB, less than 15.49% of Java online submissions for Increasing Order Search Tree.
    Time Complexity: O(N), where N is the number of nodes in the given tree.
    Space Complexity: O(N).

     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> tmp = new ArrayList<>();
        inOrder(root,tmp);
        TreeNode sentinel = new TreeNode();
        TreeNode curr = sentinel;
        for(Integer val : tmp)
        {
            curr.right = new TreeNode(val);
            curr = curr.right;
        }
        return sentinel.right;
    }
    private void inOrder(TreeNode root, List<Integer> list)
    {
        if (root == null)
            return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    /*
    Traversal with Relinking
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
    Memory Usage: 40.2 MB, less than 80.49% of Java online submissions for Increasing Order Search Tree.

    Time Complexity: O(N), where N is the number of nodes in the given tree.
    Space Complexity: O(H) in additional space complexity,
    where H is the height of the given tree, and the size of the implicit call stack in our in-order traversal.

    We can perform the same in-order traversal as in Approach 1. During the traversal,
    we'll construct the answer on the fly,
    reusing the nodes of the given tree by cutting their left child and adjoining them to the answer.
     */

    TreeNode cur;
    public TreeNode increasingBST_LC(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}
