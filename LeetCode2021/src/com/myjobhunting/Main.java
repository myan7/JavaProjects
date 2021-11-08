package com.myjobhunting;

public class Main {

    public static void main(String[] args) {
        /* testing code starts here */
        int[] digits = {9,9,9};
        EASY_066_PlusOne ans = new EASY_066_PlusOne();
        System.out.print("[");
        for (int val : ans.plusOne(digits))
            System.out.print( val + ", ");
        System.out.println("]");



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
        System.out.println(test.substring(1,3));
*/

        /* 20 Valid Parentheses
        String s = "([)]";
        System.out.println(new EASY_020_ValidParentheses().isValid2(s));
*/

        /* 014 longest common prefix
        //String[] strs = new String[]{"abc", "abcd", "abcs", "abe","abd"};
        //String[] strs = {"flower","flow","flight"};
        //String[] strs = {"flower","flower","flower","flower"};
        //String[] strs = {"dog","racecar","car"};
        //String[] strs = {"reflower","flow","flight"};
        String[] strs = {"cir","car"};

        String solution = new EASY_014_LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println("common string is " + solution);
*/

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
