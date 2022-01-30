package com.myjobhunting;

import com.practice.Learning_DP;
import com.sun.source.tree.Tree;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /* testing code starts here */

        /*
        EASY_263 Ugly number
         */
        EASY_263_UglyNumber solution = new EASY_263_UglyNumber();

        /*
        EASY 231 power of two

        int a = 5;

        while(a > 0 && a%2 == 0)
        {
            System.out.println(a);
            a >>= 1;
        }
        System.out.println(a);
*/
        /*
        EASY 217 contains duplicate

        int[] a = {1,2,3,4,5,2,2};
        EASY_217_ContainsDuplicate solution = new EASY_217_ContainsDuplicate();
        System.out.println(solution.containsDuplicate2(a));
*/

        /*
        Medium 3 longest string without repeating char

        MEDIUM_3_LongestSubstringWithoutRepeatingCharacters solution = new MEDIUM_3_LongestSubstringWithoutRepeatingCharacters();
        String test = "bbbbbb";
        int ans = solution.lengthOfLongestSubstring(test);
        */

        /*
        Amazon_OA_Demo ans = new Amazon_OA_Demo();
        int[] states = {1,0,0,0,0,1,0,0};
        List<Integer> res = ans.cellCompete(states,2);
        System.out.println(res);
        */

        /*
        ListNode node4 = new ListNode(-4);
        ListNode node3 = new ListNode(0,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head  = new ListNode(3,node2);
        node4.next = node2;

        EASY_141_LinkedListCycle ans = new EASY_141_LinkedListCycle();
        System.out.println(ans.hasCycle(head));
        */

        /*
        TreeNode ll2 = null;
        TreeNode lr2 = null;
        TreeNode rl2 = new TreeNode(15);
        TreeNode rr2 = new TreeNode(7);
        TreeNode l1 = new TreeNode(9,ll2,lr2);
        TreeNode r1 = new TreeNode(20,rl2,rr2);
        TreeNode root = new TreeNode(3,l1,r1);
        EASY_111_MinimumDepthofBinaryTree sol = new EASY_111_MinimumDepthofBinaryTree();
        System.out.println(sol.minDepth2(root));
        */
        /*EASY_110_BalancedBinaryTree solution = new EASY_110_BalancedBinaryTree();
        System.out.println(solution.isBalanced(root));*/

        /*TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(5);
        TreeNode left = new TreeNode(2,left1,left2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1,left,right);

        EASY_104_MaximumDepthofBinaryTree solution = new EASY_104_MaximumDepthofBinaryTree();
        System.out.println(solution.maxDepth2(root));
        */
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
