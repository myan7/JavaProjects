package com.myjobhunting;
// https://leetcode.com/problems/swap-nodes-in-pairs/

public class MEDIUM_024_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)   return head;
        int tmp = head.next.val;
        head.next.val = head.val;
        head.val = tmp;
        head.next.next = swapPairs(head.next.next);
        return head;
    }
}
