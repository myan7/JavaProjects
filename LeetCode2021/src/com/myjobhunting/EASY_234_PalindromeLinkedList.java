package com.myjobhunting;
// https://leetcode.com/problems/palindrome-linked-list/

public class EASY_234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        // first find out the middle node;
        ListNode slow = head, fast = head,prev = null, next = null;
        while(fast!=null && fast.next!=null)
        {
            next = slow.next;
            fast = fast.next.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if(fast!=null) // which means fast.next.next = null, which means the total number of nodes is odd
        {
            slow = slow.next;
        }
        while(slow!=null)
        {
            if(prev.val == slow.val)
            {
                prev = prev.next;
                slow = slow.next;
            }
            else
                return false;
        }
        return true;
    }

    // I don't need to worry about the list has even number of nodes or odd number of nodes
    public boolean isPalindrome0(ListNode head) {
        // the idea is to find the middle node first
        // reverse the right half
        // compare the two half

        ListNode walker = head;
        ListNode runner = head;
        while(runner != null && runner.next != null)
        {
            walker = walker.next;
            runner = runner.next.next;
        }
        // middle node will be walker.
        // reverse the right half;
        ListNode rightHalf = reverse(walker);
        while(head != null && rightHalf != null)
        {
            if(head.val != rightHalf.val)
                return false;
            head = head.next;
            rightHalf = rightHalf.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node)
    {
        ListNode curr = node;
        ListNode left = null;
        ListNode right = null;
        while(curr != null)
        {
            right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }
        return left;
    }
}
