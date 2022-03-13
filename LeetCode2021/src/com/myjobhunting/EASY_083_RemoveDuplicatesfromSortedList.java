package com.myjobhunting;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

/*
Given the head of a sorted linked list,
delete all duplicates such that each element appears only once.
Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */

public class EASY_083_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head== null)
            return null;
        ListNode currNode = head;

        while (currNode != null)
        {
            ListNode prevNode = currNode;
            while( currNode.next != null && currNode.next.val == currNode.val )
            {
                currNode = currNode.next;
            }
            currNode = currNode.next;
            prevNode.next = currNode;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null)
            return null;
        ListNode temp = head;
        while(temp.next!=null){
            if (temp.next.val != temp.val) temp = temp.next;
            else temp.next = temp.next.next;
        }
        return head;
    }

    public ListNode deleteDuplicates0(ListNode head) {
        if(head == null)
            return null;
        ListNode sentinel = new ListNode();
        ListNode curr = head;
        sentinel.next = head;
        while (curr.next!= null )
        {
            if(curr.next != null && curr.val != curr.next.val )
                curr = curr.next;
            else
                curr.next = curr.next.next;
        }
        return sentinel.next;
    }
}
