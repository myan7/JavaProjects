package com.myjobhunting;
// https://leetcode.com/problems/clone-n-ary-tree/

/*
Given a root of an N-ary tree,
return a deep copy (clone) of the tree.

Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.

class Node {
    public int val;
    public List<Node> children;
}
Nary-Tree input serialization is represented in their level order traversal,
each group of children is separated by the null value (See examples).
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MEDIUM_1490_CloneN_aryTree {
    class NaryNode {
        public int val;
        public List<NaryNode> children;


        public NaryNode() {
            children = new ArrayList<NaryNode>();
        }

        public NaryNode(int _val) {
            val = _val;
            children = new ArrayList<NaryNode>();
        }

        public NaryNode(int _val,ArrayList<NaryNode> _children) {
            val = _val;
            children = _children;
        }
    }
/*
The problem asks us to make a clone of a tree.
The task is not as intuitive as making a copy of an object.
By default, when we create a new object by copying another object,
we simply copy the primitive values within the object. This is called shallow copy.

The problem with the shallow copy is that if the object contains references or pointers to other objects,
the newly-copied object will point to the same objects rather than making another copies of these referred objects.
In contrast to the shallow copy,
the deep copy refers to the scenario that we make substantial copies of these referred objects.
For the tree data structure, the referred objects are the child nodes inside a node.
In order to make a deep copy of a node,
not only we need to make a copy of the node value itself, but also we need to make substantial copies of its child nodes.

To solve the problem,
the overall idea is that we traverse the nodes one by one and for each node we make a deep copy of it.

When it comes to the traversal of tree,
one cannot overlook the technique of DFS (Depth-First Search) and BFS (Breadth-First Search).
Indeed, in this article, we will cover three approaches namely recursion, DFS and BFS.

As one will see later, there is a fine line between the approach using recursion and the approach using DFS.
Some of you might consider the recursion approach the same as the DFS.
Indeed, one can consider our recursion approach as DFS that is implemented in the form of recursion,
as opposed to the DFS in the form of iteration.

Despite the stark contrast between the ideas of DFS and BFS approaches,
their implementations can be quite similar. In fact, as we will discover later, they are almost identical.
 */

    // Approach 1: Recursion Runtime: 0 ms, faster than 100.00% of Java online submissions
    // basic idea:
    // To clone a tree, we can first clone the root node, then we can clone each subtree recursively under the root node.
    // Let M be the number of nodes in the input tree.
    // Time Complexity: O(M)
    // We traverse each node in the tree once and only once.
    // Space Complexity: O(M)
    public NaryNode cloneTree1(NaryNode root) {

        // base case:
        if(root == null)
            return root;

        // First, copy the node itself.
        NaryNode nodeCopy = new NaryNode(root.val);

        // Then, recursively clone the sub-trees.
        for (NaryNode child : root.children) {
            nodeCopy.children.add(cloneTree1(child));
        }
        return nodeCopy;
    }

    // Approach 2: DFS with Iteration
    // Runtime: 9 ms, faster than 10.85% of Java online submissions
    public NaryNode cloneTree2(NaryNode root) {
        if(root == null)
            return root;

        NaryNode newRoot = new NaryNode(root.val);

        // Here we used the ArrayDeque instead of the Queue class,
        // which is a more efficient implementation of queue data structure.
        Deque<NaryNode[]> stack = new ArrayDeque<>();

        // Starting point to kick off the DFS visits.
        stack.addLast(new NaryNode[]{root,newRoot});

        while(!stack.isEmpty())
        {
            NaryNode[] nodePair = stack.pop();
            NaryNode oldNode = nodePair[0];
            NaryNode newNode = nodePair[1];
            for(NaryNode childNode: oldNode.children)
            {
                NaryNode newChildNode = new NaryNode(childNode.val);
                // Make a copy for each child node.
                newNode.children.add(newChildNode);
                // Schedule a visit to copy the child nodes of each child node.
                stack.push(new NaryNode[]{childNode,newChildNode});
            }
        }
        return newRoot;
    }

}
