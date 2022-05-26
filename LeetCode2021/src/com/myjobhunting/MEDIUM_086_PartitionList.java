package com.myjobhunting;
// https://leetcode.com/problems/partition-list/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the head of a linked list and a value x,
partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]

Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
 */
public class MEDIUM_086_PartitionList {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
    Memory Usage: 41.8 MB, less than 81.58% of Java online submissions for Partition List.
    T: O(N), S: O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode sentinel_left = new ListNode();
        ListNode left = sentinel_left;
        ListNode sentinel_right = new ListNode();
        ListNode right = sentinel_right;

        while(head != null)
        {
            if(head.val < x)
            {
                left.next = head;
                left = left.next;
            }
            else
            {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null; // avoid cycle
        left.next = sentinel_right.next;
        return sentinel_left.next;
    }

    /*
    Runtime: 1 ms, faster than 56.99% of Java online submissions for Partition List.
    Memory Usage: 41.9 MB, less than 77.99% of Java online submissions for Partition List.
     */
    public ListNode partition0(ListNode head, int x) {
        List<Integer> left = new ArrayList<>();
        ListNode curr = head;
        List<Integer> right = new ArrayList<>();
        while(curr != null)
        {
            if(curr.val < x)
                left.add(curr.val);
            else
                right.add(curr.val);
            curr = curr.next;
        }

        curr = head;
        int index = 0;
        while(index < left.size())
        {
            curr.val = left.get(index++);
            curr = curr.next;
        }
        index = 0;
        while(index < right.size())
        {
            curr.val = right.get(index++);
            curr = curr.next;
        }
        return head;
    }
}
