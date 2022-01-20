package com.myjobhunting;

// https://leetcode.com/problems/linked-list-cycle/
public class EASY_141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode walker = head;
        ListNode runner = head;
        while(runner != null && runner.next != null)
        {
            walker = walker.next;
            runner = runner.next.next;
            if (runner == walker)
                return true;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head)
    {
        for(ListNode slow = head, fast = head; fast != null; slow = slow.next, fast = fast.next)
        {
            fast = fast.next;
            if(fast == null)
                break;
            else if(slow == fast)
                return true;
        }
        return false;
    }

    // what is this???? shitty code
    public boolean hasCycle2(ListNode head) {
        ListNode p = head,pre = head;
        while(p != null && p.next != null){
            if (p.next == head) return true;
            p = p.next;
            pre.next = head;
            pre = p;
        }
        return false;
    }
}
