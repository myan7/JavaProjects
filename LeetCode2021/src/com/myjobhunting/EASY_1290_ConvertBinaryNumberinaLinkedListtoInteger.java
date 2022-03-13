package com.myjobhunting;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

/*
Given head which is a reference node to a singly-linked list.
The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

Example 1:
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:
Input: head = [0]
Output: 0

Constraints:
The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
 */
public class EASY_1290_ConvertBinaryNumberinaLinkedListtoInteger {
    /*
    bit manipulation
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
    Memory Usage: 41.9 MB, less than 26.88% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     */
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while(head != null)
        {
            ans <<= 1;
            ans += head.val;
            head = head.next;
        }
        return ans;
    }

    // or
    public int getDecimalValue_Math(ListNode head) {
        int ans = 0;
        while(head != null)
        {
            ans = ans*2 + head.val;
            head = head.next;
        }
        return ans;
    }
}
