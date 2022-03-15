package com.myjobhunting;
// https://leetcode.com/problems/palindrome-permutation/

/*
Given a string s, return true if a permutation of the string could form a palindrome.

Example 1:
Input: s = "code"
Output: false

Example 2:
Input: s = "aab"
Output: true

Example 3:
Input: s = "carerac"
Output: true

Constraints:
1 <= s.length <= 5000
s consists of only lowercase English letters.
 */
public class EASY_266_L_PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    public boolean canPermutePalindrome1(String s) {
        int len = s.length();
        int[] letters = new int[26];
        for(char c: s.toCharArray())
            letters[c-'a']++;

        int count = 0;
        for(int freq: letters)
            if( freq%2 != 0)
                count++;
        return count <= 1;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Palindrome Permutation.
    Memory Usage: 42.2 MB, less than 13.44% of Java online submissions for Palindrome Permutation.
     */
    public boolean canPermutePalindrome0(String s) {
        int len = s.length();
        int[] letters = new int[26];
        for(char c: s.toCharArray())
            letters[c-'a']++;

        if(len%2 == 0 )
        {
            for(int freq: letters)
                if( freq%2 != 0)
                    return false;
        }
        else
        {
            int count = 0;
            for(int freq: letters)
                if( freq%2 != 0)
                    count++;
            return count == 1;
        }
        return true;
    }
}
