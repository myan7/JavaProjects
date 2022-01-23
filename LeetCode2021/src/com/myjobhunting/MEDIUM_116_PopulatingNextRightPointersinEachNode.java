package com.myjobhunting;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

public class MEDIUM_116_PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        // this problem is to find the next right node on the same level
        // find a parent node, point the next of the left child to its right child
        // if it is the rightmost child, i.e. there is no right subtree.

        // if root is null
        if(root == null)
            return null;
        //start with the first level
        Node curr = root;

        //if curr is not a leaf node, it can keep going.
        while(curr.left != null)
        {
            // keep tracking of the first node of the next level
            Node nextLevel = curr.left;

            //for each node on the current level, populate the next pointer of the next level
            while(curr != null)
            {
                curr.left.next = curr.right;
                if(curr.next == null)
                    curr.right.next = null;
                else
                    curr.right.next = curr.next.left;
                // move the curr node to it's next on the same level
                curr = curr.next;
            }
            curr = nextLevel;
        }
        return root;
    }


    public Node connect2(Node root){
        return helper(root,null);
    }
    Node helper(Node root,Node next) {
        if(root!=null){
            root.next=next;
            helper(root.left,root.right);
            if(next!=null){
                helper(root.right,next.left);
            }else{
                helper(root.right,null);
            }
        }
        return root;
    }

    public Node connect3(Node root) {
        if (root == null)
            return null;
        Node head = root;
        while( head != null )
        {
            Node cur = head;
            while( cur != null )
            {
                if (cur.left != null)
                {
                    cur.left.next = cur.right;
                    if ( cur.next != null )
                        cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            head = head.left;
        }
        return root;
    }
}
