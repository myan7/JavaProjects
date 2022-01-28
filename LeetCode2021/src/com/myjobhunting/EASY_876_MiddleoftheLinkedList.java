package com.myjobhunting;

public class EASY_876_MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while(runner != null && runner.next != null)
        {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }
}
