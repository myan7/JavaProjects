package com.myjobhunting;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
//Note that the linked lists must retain their original structure after the function returns.
//so reverse the linkedlist is not an option.

public class EASY_160_Intersection_of_Two_Linked_Lists {
    // method 1 2ms 52.2M
    // if reach to the end of each node, point to the other node and loop thru
    // if lengths of the 2 linkedlists are the same, it will not go to the other node
    // if lengths of the 2 linkedlists are different, then they will meet eventually.
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        if(headA == null || headB == null)
            return null;
        while(currA != currB)
        {
            currA = currA == null? headB: currA.next;
            currB = currB == null? headA: currB.next;
        }
        return currA;
    }

    // method 2 51.9M
    // find the lengths of both linked lists first
    // move the starting point of the longer linkedlist to be the head of the shorter one.
    // then start going to the next.
    // there will be helper functions, like findLen(), moveHead()
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = findLen(headA);
        int lenB = findLen(headB);

        if (lenA - lenB > 0)
        {
            headA = moveHead(headA, lenA-lenB);
        }
        else if(lenA - lenB < 0)
        {
            headB = moveHead(headB,lenB - lenA);
        }
        while(headA!= headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int findLen(ListNode head)
    {
        int len = 0;
        while(head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode moveHead(ListNode head, int steps)
    {
        for(int i = 0; i < steps; i ++)
        {
            head = head.next;
        }
        return head;
    }

}

