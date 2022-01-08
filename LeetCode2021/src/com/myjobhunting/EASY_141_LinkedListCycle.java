package com.myjobhunting;

// https://leetcode.com/problems/linked-list-cycle/
public class EASY_141_LinkedListCycle {
    public boolean hasCycle(ListNode head)
    {
        if(head == null) {
            return false;
        }
        else
        {
            ListNode walker = head;
            ListNode runner = head;
            while(runner.next != null && runner.next.next != null)
            {
                walker = walker.next;
                runner = runner.next.next;
                if(walker == runner) return true;
            }
        }
        return false;
    }

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
