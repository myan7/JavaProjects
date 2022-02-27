package com.myjobhunting;
// https://leetcode.com/problems/merge-two-sorted-lists/
/*

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]


Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

 */
public class EASY_021_Merg2SortedLists {
    // 0ms for
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        else if(list1.val < list2.val)
        {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        else
        {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }


    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;

        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                curr.next = list1;
                list1 = list1.next;
            }
            else
            {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null)
            curr.next = list1;
        else if(list2 != null )
            curr.next = list2;

        return sentinel.next;
    }

}
