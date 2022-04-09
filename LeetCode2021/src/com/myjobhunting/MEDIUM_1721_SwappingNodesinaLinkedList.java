package com.myjobhunting;

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

/*
You are given the head of a linked list, and an integer k.

Return the head of the linked list
after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).



Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 10^5
0 <= Node.val <= 100
 */
public class MEDIUM_1721_SwappingNodesinaLinkedList {
    /*
    Runtime: 2 ms, faster than 100.00% of Java online submissions for Swapping Nodes in a Linked List.
    Memory Usage: 56.3 MB, less than 98.53% of Java online submissions for Swapping Nodes in a Linked List.
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head, right = head;
        ListNode curr = head;
        for(int i = 1; i < k; i++)
        {
            curr = curr.next;
        }
        left = curr;

        while(curr.next != null)
        {
            curr = curr.next;
            right = right.next;
        }

        int val = left.val;
        left.val = right.val;
        right.val = val;
        return head;
    }
}
