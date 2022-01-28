package com.myjobhunting;

public class MEDIUM_19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode curr = sentinel;
        ListNode window = sentinel.next;
        int step = 0;
        while( step < n && window != null)
        {
            window = window.next;
            step++;
        }
        while(window != null)
        {
            window = window.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return sentinel.next;
    }

    public ListNode removeNthFromEnd0(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        int length = getLength(head);
        int pos = length - n;
        // keep pos -1, and its next, pos + 1
        if(pos == 0)
            head = head.next;
        else
        {
            int count = 0;
            ListNode curr = head;
            while(count < pos-1) // find the one before target
            {
                curr = curr.next;
                count++;
            }
            curr.next = curr.next.next;
        }
        return head;
    }
    private int getLength(ListNode head)
    {
        int length = 0;
        ListNode curr = head;
        while(curr != null)
        {
            length++;
            curr = curr.next;
        }
        return length;
    }
}
