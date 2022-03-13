package com.myjobhunting;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

/*
Given the head of a sorted linked list,
delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.
Return the linked list sorted as well.


Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]


Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

 */
public class MEDIUM_082_RemoveDuplicatesfromSortedList_II {

    /*
    Runtime: 1 ms, faster than 77.24% of Java online submissions for Remove Duplicates from Sorted List II.
    Memory Usage: 44.4 MB, less than 5.32% of Java online submissions for Remove Duplicates from Sorted List II.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        while (head!= null )
        {
            // check if the next node has the same value as current node
            if(head.next != null && head.val == head.next.val)
            {
                // move till the end of the duplicate
                while(head.next != null && head.val == head.next.val)
                    head = head.next;
                // skip the duplicate
                prev.next = head.next;
            }
            else
            {
                prev = prev.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }

    //
    public ListNode removeDuplicates(ListNode head) {
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        curr.next = head;
        ListNode prev = sentinel;
        while (curr!= null && curr.next != null )
        {
            if(curr.val == curr.next.val)
            {
                curr = curr.next;
            }
            else
            {
                prev.next = curr.next;
                prev = curr.next;
                curr = prev.next;
            }

        }
        return sentinel.next;
    }

    /*
    Recursive
     */
    public ListNode removeDuplicates(ListNode root,int previous){
        if(root==null)
            return null;
        else if((root.next!=null && root.val==root.next.val)||(root.val==previous))
            return removeDuplicates(root.next,root.val);
        root.next=removeDuplicates(root.next,root.val);
        return root;
    }
    public ListNode deleteDuplicatesR(ListNode head) {
        return removeDuplicates(head,-101);
    }
}
