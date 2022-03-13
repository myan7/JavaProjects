package com.myjobhunting;
// https://leetcode.com/problems/rotate-list/
/*
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9
 */
public class MEDIUM_061RotateList {

    // better solution
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode sentinel =new ListNode();
        sentinel.next=head;
        ListNode oldTail=sentinel,newTail=sentinel;

        int len;
        for (len=0;oldTail.next!=null;len++)//Get the total length
            oldTail=oldTail.next;

        for (int i=len-k%len;i>0;i--) //Get the i-n%i th node
            newTail=newTail.next;

        //Do the rotation
        oldTail.next = sentinel.next; // first link the head to the old tail
        sentinel.next=newTail.next; // save the break point to sentinel.next;
        newTail.next=null; // cut the break point.

        return sentinel.next;
    }

    /* Naive solution.
    Runtime: 1 ms, faster than 75.83% of Java online submissions for Rotate List.
    Memory Usage: 43.9 MB, less than 7.14% of Java online submissions for Rotate List.
     */
    public ListNode rotateRight0(ListNode head, int k) {
        // I can find the length of the list.
        int len = getLength(head);
        if(len <= 1) return head;
        k %= len;
        if ( k == 0) return head;
        int count = 0;
        ListNode curr = head;
        while(count < len-k-1){
            curr=curr.next;
            count++;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        curr = newHead;
        if (curr.next != null) {
            while (curr.next != null) {
                curr = curr.next;
            }
        }
        curr.next = head;
        return newHead;
    }
    private int getLength(ListNode head)
    {
        int len = 0;
        while(head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
}
