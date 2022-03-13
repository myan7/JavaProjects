package com.myjobhunting;

// https://leetcode.com/problems/create-binary-tree-from-descriptions/

import java.util.*;

/*
You are given a 2D integer array descriptions
where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values.
Furthermore,
If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

Example 1:
Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.

Example 2:
Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.


Constraints:
1 <= descriptions.length <= 104
descriptions[i].length == 3
1 <= parenti, childi <= 105
0 <= isLefti <= 1
The binary tree described by descriptions is valid.
 */
public class MEDIUM_2196_CreateBinaryTreeFromDescriptions {

    /*
    Runtime: 65 ms, faster than 97.18% of Java online submissions for Create Binary Tree From Descriptions.
    Memory Usage: 52.7 MB, less than 88.46% of Java online submissions for Create Binary Tree From Descriptions.
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] arr : descriptions) {
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            children.add(child);
            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
            if (isLeft == 1) {
                node.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.left);
            } else {
                node.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.right);
            }
            map.put(parent, node);
        }

        int root = -1;
        for (int [] arr: descriptions) {
            if (!children.contains(arr[0])) {
                root = arr[0];
                break;
            }
        }
        return map.getOrDefault(root, null);
    }

    public TreeNode createBinaryTree1(int[][] descriptions) {
        Set<Integer> children = new HashSet<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for(int i = 0; i < descriptions.length; i++) {
            int nodeVal = descriptions[i][0], childNodeVal = descriptions[i][1], left = descriptions[i][2];
            children.add(childNodeVal);
            TreeNode node = nodeMap.getOrDefault(nodeVal, new TreeNode(nodeVal));
            if (left == 1)
            {
                node.left = nodeMap.getOrDefault(childNodeVal, new TreeNode(childNodeVal));
                nodeMap.put(childNodeVal, node.left);
            }
            else
            {
                node.right = nodeMap.getOrDefault(childNodeVal,new TreeNode(childNodeVal));
                nodeMap.put(childNodeVal,node.right);
            }
            nodeMap.put(nodeVal,node);
        }
        int root = 0;
        for(int[] val :descriptions )
        {
            if(!children.contains(val[0]))
            {
                root = val[0];
                return nodeMap.get(root);
            }
        }
        return null;
    }
    /*
    Runtime: 134 ms, faster than 58.62% of Java online submissions for Create Binary Tree From Descriptions.
    Memory Usage: 119.4 MB, less than 51.16% of Java online submissions for Create Binary Tree From Descriptions.
     */
    public TreeNode createBinaryTree0(int[][] descriptions) {
        Set<Integer> children = new HashSet<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for(int i = 0; i < descriptions.length; i++)
        {
            Integer nodeVal = descriptions[i][0];
            Integer childNodeVal = descriptions[i][1];
            int left = descriptions[i][2];
            children.add(childNodeVal);

            if(!nodeMap.containsKey(nodeVal))
            {
                TreeNode node = new TreeNode(nodeVal);
                // if new child node
                if(!nodeMap.containsKey(childNodeVal))
                {
                    TreeNode childNode = new TreeNode(childNodeVal);
                    if(left == 1)
                        node.left = childNode;
                    else
                        node.right = childNode;
                    nodeMap.put(childNodeVal,childNode);
                }
                else // if not new child
                {
                    if(left == 1)
                        node.left = nodeMap.get(childNodeVal);
                    else
                        node.right = nodeMap.get(childNodeVal);
                }
                nodeMap.put(nodeVal,node);
            }
            else
            {
                if(!nodeMap.containsKey(childNodeVal))
                {
                    TreeNode childNode = new TreeNode(childNodeVal);
                    if(left == 1)
                        nodeMap.get(nodeVal).left = childNode;
                    else
                        nodeMap.get(nodeVal).right = childNode;
                    nodeMap.put(childNodeVal,childNode);
                }
                else
                if(left == 1)
                    nodeMap.get(nodeVal).left = nodeMap.get(childNodeVal);
                else
                    nodeMap.get(nodeVal).right = nodeMap.get(childNodeVal);
            }

            nodeMap.put(nodeVal, nodeMap.get(nodeVal));
            nodeMap.put(childNodeVal,nodeMap.get(childNodeVal));
        }
        int root = 0;
        for(int[] val :descriptions )
        {
            if(!children.contains(val[0]))
            {
                root = val[0];
                return nodeMap.get(root);
            }
        }
        return null;
    }
}
