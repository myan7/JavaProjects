package com.myjobhunting;

// https://leetcode.com/problems/linked-list-cycle-ii/


public class MEDIUM_142_LinkedListCycle_II {
    // T: O(n), S: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // find intersection.
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }

        // if there is no cycle
        if(fast == null || fast.next == null)
            return null;

        // if there is cycle, find the entrance.
        slow = head;
        while( slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
