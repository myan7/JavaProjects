package com.practice;

import com.myjobhunting.Node;

public class RecursiveTest {

    public static void main(String[] args)
    {
        // how to reverse a string using recursive call
        String st = "123456789";
        System.out.println(reverseString_rec(st));

        // how to reverse a string using recursive call
        String st1 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(st1);
        String st2 = reverseString_rec2(st1);
        System.out.println(st2);

        // how to reverse an array in recursive way.
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        print(arr);
        reverseArray_rec(arr);
        print(arr);

        // how to reverse a list node
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        print(node1);
        Node ans = reverseNode(node1);
        print(ans);
        Node ans2 = reverNode_rec(ans);
        print(ans2);
        Node ans3 = swapPairs(ans2);
        print(ans3);
    }

    /*
    reverse a String recursively 1     O(N) space complexity.
     */
    public static String reverseString_rec(String s)
    {
        //base case:
        if(s.length() == 0)
            return s;
        // general case leave the first char, reverse the rest, append the first char to the reversed substring
        return reverseString_rec(s.substring(1)) + s.charAt(0);
    }

    /*
    reverse a string recursively 2 if char array, O(1) space.
     */
    public static String reverseString_rec2(String s)
    {
        char[] chArr = s.toCharArray();
        helper(chArr,0,s.length()-1);
        return String.valueOf(chArr);
    }
    public static void helper(char[] s, int left, int right)
    {
        if(left >= right)
            return;
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        helper(s, left+1, right-1);
    }

    /*
    reverse an array. using 2 pointers.
     */
    public static void reverseArray_rec(int[] arr)
    {
        helper(arr, 0,arr.length-1);
    }
    public static void helper(int[] arr, int left, int right)
    {
        if(left >= right)
            return;
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        helper(arr,left+1, right-1);
    }

    public static Node reverseNode(Node node)
    {
        Node left = null;
        Node curr = node;

        while(curr != null)
        {
            Node right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }
        return left;
    }

    public static Node reverNode_rec(Node node)
    {
        if(node == null || node.next == null)
            return node;
        Node next = reverNode_rec(node.next);
        node.next.next = node;
        node.next = null;
        return next;
    }

    public static Node swapPairs(Node node)
    {
        if(node == null || node.next == null)
            return node;
        Node nextNode = node.next.next;
        Node next = node.next;
        next.next = node;
        node.next = swapPairs(nextNode);
        return next;
    }










    // common functions
    public static void print(int[] arr)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int a: arr)
        {
            sb.append(a).append(',');
        }
        System.out.println(sb.substring(0,sb.length()-1) + "]");
    }

    public static void print(Node node)
    {
        StringBuilder sb = new StringBuilder();
        while(node != null)
        {
            sb.append(node.val).append(" ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }
}
