package com.myjobhunting;

import com.sun.source.tree.Tree;

public class Main {

    public static void main(String[] args) {
        /* testing code starts here */

        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(5);
        TreeNode left = new TreeNode(2,left1,left2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1,left,right);

        EASY_104_MaximumDepthofBinaryTree solution = new EASY_104_MaximumDepthofBinaryTree();
        System.out.println(solution.maxDepth(root));

        /*EASY_094_BinaryTreeInorderTraversal inorder = new EASY_094_BinaryTreeInorderTraversal();
        System.out.println(inorder.inorderTraversal(root));

        EASY_094_BinaryTreePreorderTraversal preorder = new EASY_094_BinaryTreePreorderTraversal();
        System.out.println(preorder.preorderTraversal(root));

        EASY_094_BinaryTreePostorderTraversal postorder = new EASY_094_BinaryTreePostorderTraversal();
        System.out.println(postorder.postorderTraversal(root));*/



        /*int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        EASY_088_MergeSortedArray solution = new EASY_088_MergeSortedArray();
        solution.merge(nums1,m,nums2,n);
        for( int val : nums1)
            System.out.print(val + ", ");*/


        /*ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        EASY_083_RemoveDuplicatesfromSortedList solution = new EASY_083_RemoveDuplicatesfromSortedList();
        head = solution.deleteDuplicates(head);
        while(head != null)
        {
            System.out.print(head.val + ",");
            head = head.next;
        }*/



        /*int numofStairs = 1;
        EASY_070_ClimbingStairs solution = new EASY_070_ClimbingStairs();
        System.out.println(solution.climbStairs(numofStairs));*/

        /*int  x = 9;
        EASY_069_Sqrt_x solution = new EASY_069_Sqrt_x();
        System.out.println(solution.mySqrt(x));*/

        /* 60 plus one */
        /*int[] digits = {9,9,9};
        EASY_066_PlusOne ans = new EASY_066_PlusOne();
        System.out.print("[");
        for (int val : ans.plusOne(digits))
            System.out.print( val + ", ");
        System.out.println("]");*/

        /* 58 Length of Last Word*/
        //String s = "Hello World"; //5
        //String s = "   fly me   to   the moon  "; //4
        //String s = "luffy is still joyboy"; //6
        /*String s = "a";
        EASY_058_LengthofLastWord ans = new EASY_058_LengthofLastWord();
        System.out.println(ans.lengthOfLastWord(s));*/

        /* 28 implement strStr()
        String haystack = "Hello"; String needle = "ll";
        EASY_028_Implement_strStr solution = new EASY_028_Implement_strStr();
        System.out.println(solution.strStr(haystack,needle));
        System.out.println(solution.strStr2(haystack,needle));
        String test = "abc";
        System.out.println(test.substring(1,3));*/

        /* 20 Valid Parentheses
        String s = "([)]";
        System.out.println(new EASY_020_ValidParentheses().isValid2(s));*/

        /* 014 longest common prefix
        //String[] strs = new String[]{"abc", "abcd", "abcs", "abe","abd"};
        //String[] strs = {"flower","flow","flight"};
        //String[] strs = {"flower","flower","flower","flower"};
        //String[] strs = {"dog","racecar","car"};
        //String[] strs = {"reflower","flow","flight"};
        String[] strs = {"cir","car"};
        String solution = new EASY_014_LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println("common string is " + solution);*/

        /* 013 roman to int
        // String romanVal = "III";
        String romanVal = "MCMXCIV";
        int solution = new EASY_013_RomantoInteger().romanToInt(romanVal);
        System.out.println(solution);*/

        /* 009 Palindrome number
        //int val = 121;
        //int val = -121;
        //int val = 10;
        int val = 1234567899;
        EASY_009_PalindromeNumber solution = new EASY_009_PalindromeNumber();
        System.out.println(solution.isPalindrome3(val));*/

        /* 001 two sum
        int[] arr = new int[]{3,2,0,4,5};
        int target = 6;
        EASY_001_TwoSum solution = new EASY_001_TwoSum();
        int[] ans = solution.twoSum(arr,target);
        System.out.println("The answer to easy 001 two sum is ["+ ans[0]+", "+ ans[1]+ "]." );*/

    }
}
