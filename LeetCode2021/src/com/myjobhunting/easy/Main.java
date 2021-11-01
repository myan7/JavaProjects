package com.myjobhunting.easy;

public class Main {

    public static void main(String[] args) {
        /* testing code starts here */

        /* 014 longest common prefix */
        //String[] strs = new String[]{"abc", "abcd", "abcs", "abe","abd"};
        //String[] strs = {"flower","flow","flight"};
        //String[] strs = {"flower","flower","flower","flower"};
        //String[] strs = {"dog","racecar","car"};
        //String[] strs = {"reflower","flow","flight"};
        String[] strs = {"cir","car"};

        String solution = new EASY_014_LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println("common string is " + solution);

        /* 013 roman to int
        // String romanVal = "III";
        String romanVal = "MCMXCIV";
        int solution = new EASY_013_RomantoInteger().romanToInt(romanVal);
        System.out.println(solution);
        */

        /* 009 Palindrome number
        //int val = 121;
        //int val = -121;
        //int val = 10;
        int val = 1234567899;
        EASY_009_PalindromeNumber solution = new EASY_009_PalindromeNumber();
        System.out.println(solution.isPalindrome3(val));
        */

        /* 001 two sum
        int[] arr = new int[]{3,2,0,4,5};
        int target = 6;

        EASY_001_TwoSum solution = new EASY_001_TwoSum();
        int[] ans = solution.twoSum(arr,target);

        System.out.println("The answer to easy 001 two sum is ["+ ans[0]+", "+ ans[1]+ "]." );
        */

    }
}
