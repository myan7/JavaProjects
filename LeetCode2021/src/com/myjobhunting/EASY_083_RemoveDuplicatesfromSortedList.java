package com.myjobhunting;

public class EASY_083_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head== null)
            return null;
        ListNode currNode = head;

        while (currNode != null)
        {
            ListNode prevNode = currNode;
            while( currNode.next != null && currNode.next.val == currNode.val )
            {
                currNode = currNode.next;
            }
            currNode = currNode.next;
            prevNode.next = currNode;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null)
            return null;
        ListNode temp = head;
        while(temp.next!=null){
            if (temp.next.val != temp.val) temp = temp.next;
            else temp.next = temp.next.next;
        }
        return head;
    }
}
