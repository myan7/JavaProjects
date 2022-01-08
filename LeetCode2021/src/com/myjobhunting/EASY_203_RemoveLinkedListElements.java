package com.myjobhunting;
//https://leetcode.com/problems/remove-linked-list-elements/

public class EASY_203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //sentinel node
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode curr = sentinel;
        ListNode prev = sentinel;
        ListNode next = null;
        while (curr != null )
        {
            if(curr.val != val)
            {
                prev = curr;
                curr = curr.next;
            }
            else
            {
                next = curr.next;
                prev.next = next;
                curr = curr.next;
            }
        }

        return sentinel.next;
    }
    public ListNode removeElements0(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val == val){
                if(prev == null) head = head.next;
                else prev.next = curr.next;
            }else prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null)
        {
            if(curr.val == val)
            {
                if(prev == null)
                {
                    head = head.next;
                }else
                    prev.next = curr.next;
            }
            else
                prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if(head == null){
            return head;
        }
        return removeElement(head, val);
    }
    public ListNode removeElement(ListNode head, int val){
        if(head.next!= null){
            head.next = removeElement(head.next, val);
        }
        if(head.val == val ){
            return head.next;
        }
        return head;
    }
}
