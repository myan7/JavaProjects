package com.myjobhunting;

// https://leetcode.com/problems/delete-node-in-a-linked-list/

/*
Write a function to delete a node in a singly-linked list.
You will NOT be given access to the head of the list,
instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.
 */
public class EASY_237_DeleteNodeinaLinkedList {
    public void deleteNode0(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
