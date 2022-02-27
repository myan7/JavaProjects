package com.myjobhunting;

// https://leetcode.com/problems/reverse-linked-list/

public class EASY_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode left = null;
        while(curr!= null)
        {
            ListNode right = curr.next; // step 1, save the next node, which will be the future curr in the next iteration;
            curr.next = left;           // step 2, cut the original link, pointing new next to its left;
            left = curr;                // step 3, move left to the right by one position for the next iteration;
            curr = right;               // step 4, move curr to the right by one position for the next iteration;
        }
        return left; // at the end, curr becomes null, left will be the new head;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
