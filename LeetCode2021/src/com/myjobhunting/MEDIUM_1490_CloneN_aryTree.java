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
    public NaryNode_1490 cloneTree1(NaryNode_1490 root) {

        // base case:
        if(root == null)
            return root;

        // First, copy the node itself.
        NaryNode_1490 nodeCopy = new NaryNode_1490(root.val);

        // Then, recursively clone the sub-trees.
        for (NaryNode_1490 child : root.children) {
            nodeCopy.children.add(cloneTree1(child));
        }
        return nodeCopy;
    }

    // Approach 2: DFS with Iteration
    // Runtime: 9 ms, faster than 10.85% of Java online submissions
    public NaryNode_1490 cloneTree2(NaryNode_1490 root) {
        if(root == null)
            return root;

        NaryNode_1490 newRoot = new NaryNode_1490(root.val);

        // Here we used the ArrayDeque instead of the Queue class,
        // which is a more efficient implementation of queue data structure.
        Deque<NaryNode_1490[]> stack = new ArrayDeque<>();

        // Starting point to kick off the DFS visits.
        stack.addLast(new NaryNode_1490[]{root,newRoot});

        while(!stack.isEmpty())
        {
            NaryNode_1490[] nodePair = stack.pop();
            NaryNode_1490 oldNode = nodePair[0];
            NaryNode_1490 newNode = nodePair[1];
            for(NaryNode_1490 childNode: oldNode.children)
            {
                NaryNode_1490 newChildNode = new NaryNode_1490(childNode.val);
                // Make a copy for each child node.
                newNode.children.add(newChildNode);
                // Schedule a visit to copy the child nodes of each child node.
                stack.push(new NaryNode_1490[]{childNode,newChildNode});
            }
        }
        return newRoot;
    }

    static class NaryNode_1490 {
        public int val;
        public List<NaryNode_1490> children;
    
    
        public NaryNode_1490() {
            children = new ArrayList<NaryNode_1490>();
        }
    
        public NaryNode_1490(int _val) {
            val = _val;
            children = new ArrayList<NaryNode_1490>();
        }
    
        public NaryNode_1490(int _val, ArrayList<NaryNode_1490> _children) {
            val = _val;
            children = _children;
        }
    }
}
