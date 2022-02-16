package com.myjobhunting;
// https://leetcode.com/problems/add-two-numbers/

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in REVERSE order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input:  l1 = [9,9,9,9,9,9,9],
        l2 = [9,9,9,9]
Output:      [8,9,9,9,0,0,0,1]
 */

public class MEDIUM_002_AddTwoNumbers {


    public ListNode addTwoNumbers00(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode sentinel = curr;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            // if l1 is null but l2 is not null, set val for l1 as 0
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            curr.next = cur;
            curr = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return sentinel.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if l1 is null but l2 is not null, set val for l1 as 0
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        int carry = 0;
        while(l1 != null || l2 != null)
        {
            int x = l1 == null? 0: l1.val;
            int y = l2 == null? 0: l2.val;
            int sum  = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(l1 != null ) l1 = l1.next;
            if(l2 != null ) l2 = l2.next;
        }
        if(carry == 1)
            curr.next = new ListNode(1);
        return sentinel.next;
    }

    // 2 ms, beats 13.48% memory usage
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        ListNode carry = new ListNode(0);
        while(l1 != null || l2 != null)
        {
            if( l1 != null && l2 != null)
            {
                l1.val = l1.val + l2.val + carry.val;
                if(l1.val > 9 )
                {
                    l1.val = l1.val%10;
                    carry.val = 1;
                }
                else
                {
                    carry.val = 0;
                }
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 == null)
            {
                curr.next = l2;
                l2.val = l2.val + carry.val;
                if(l2.val > 9)
                {
                    l2.val %= 10;
                    carry.val = 1;
                }
                else
                {
                    carry.val = 0;
                }
                curr = curr.next;
                l2 = l2.next;
            }
            else if(l2 == null)
            {
                curr.next = l1;
                l1.val = l1.val + carry.val;
                if(l1.val > 9)
                {
                    l1.val %= 10;
                    carry.val = 1;
                }
                else
                {
                    carry.val = 0;
                }
                curr = curr.next;
                l1 = l1.next;
            }

        }
        if (carry.val == 1)
            curr.next = carry;
        return sentinel.next;
    }

    // 3 ms
    // O(n) time complexity, O(n) space complexity
    // memory usage only beats 19.42%
    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        ListNode carry = new ListNode();
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        carry.val  = 0;
        while(l1 != null || l2 != null)
        {
            ListNode ln = new ListNode();
            ln.val = 0;
            if(l1 != null)
            {
                ln.val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                ln.val += l2.val;
                l2 = l2.next;
            }
            if(carry.val == 1)
            {
                ln.val += carry.val;
            }
            if(ln.val > 9)
            {
                carry.val = 1;
                ln.val = ln.val%10;
            }
            else
            {
                carry.val = 0;
            }
            curr.next = ln;
            curr = curr.next;
        }
        if(carry.val == 1)
            curr.next = carry;

        return sentinel.next;
    }


}
