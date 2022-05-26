package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/submissions/

/*
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor.
The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.

Notice that by initializing the pointer to a non-existent smallest number,
the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.



Example 1:


Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False


Constraints:

The number of nodes in the tree is in the range [1, 105].
0 <= Node.val <= 106
At most 105 calls will be made to hasNext, and next.

Follow up:

Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?

 */
public class MEDIUM_173_BinarySearchTreeIterator {

    /*
    Runtime: 14 ms, faster than 85.69% of Java online submissions for Binary Search Tree Iterator.
    Memory Usage: 46 MB, less than 92.04% of Java online submissions for Binary Search Tree Iterator.
     */
    class BSTIterator {
        List<Integer> tree = new ArrayList<>();
        int index = 0;

        public BSTIterator(TreeNode root) {
            inOrder(root, tree);
        }

        public int next() {
            return tree.get(index++);
        }

        public boolean hasNext() {
            return index < tree.size();
        }

        private void inOrder(TreeNode root, List<Integer> tree)
        {
            if(root == null) return;
            inOrder(root.left, tree);
            tree.add(root.val);
            inOrder(root.right, tree);
        }
    }

    /*
    Runtime: 30 ms, faster than 18.71% of Java online submissions for Binary Search Tree Iterator.
    Memory Usage: 51.3 MB, less than 69.64% of Java online submissions for Binary Search Tree Iterator.
    Time complexity : The time complexity for this approach is very interesting to analyze. Let's look at the complexities for both the functions in the class:
        hasNext is the easier of the lot since all we do in this is to return true if there are any elements left in the stack.
        Otherwise, we return false. So clearly, this is an O(1) operation every time.
        Let's look at the more complicated function now to see if we satisfy all the requirements in the problem statement

        next involves two major operations.
        One is where we pop an element from the stack which becomes the next smallest element to return.
        This is a O(1) operation.
        However, we then make a call to our helper function _inorder_left which iterates over a bunch of nodes.
        This is clearly a linear time operation i.e. O(N) in the worst case. This is true.

    However, the important thing to note here is that we only make such a call for nodes which have a right child.
    Otherwise, we simply return.
    Also, even if we end up calling the helper function, it won't always process N nodes.
    They will be much lesser. Only if we have a skewed tree would there be N nodes for the root.
    But that is the only node for which we would call the helper function.

    Thus, the amortized (average) time complexity for this function would still be O(1) which is what the question asks for.
    We don't need to have a solution which gives constant time operations for every call.
    We need that complexity on average and that is what we get.

    Space complexity: The space complexity is O(N) (N is the number of nodes in the tree),
    which is occupied by our custom stack for simulating the inorder traversal.
    Again, we satisfy the space requirements as well as specified in the problem statement.
     */
    class BSTIterator_LC {
        Stack<TreeNode> stack;

        public BSTIterator_LC(TreeNode root) {

            // Stack for the recursion simulation
            this.stack = new Stack<TreeNode>();

            // Remember that the algorithm starts with a call to the helper function
            // with the root node as the input
            this.leftmostInorder(root);
        }

        private void leftmostInorder(TreeNode root) {

            // For a given node, add all the elements in the leftmost branch of the tree
            // under it to the stack.
            while (root != null) {
                this.stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            // Node at the top of the stack is the next smallest element
            TreeNode topmostNode = this.stack.pop();

            // Need to maintain the invariant. If the node has a right child, call the
            // helper function for the right child
            if (topmostNode.right != null) {
                this.leftmostInorder(topmostNode.right);
            }

            return topmostNode.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return this.stack.size() > 0;
        }
    }
}
