package com.myjobhunting;
//https://leetcode.com/problems/find-the-difference/
/*
You are given two strings s and t.
String t is generated by random shuffling string s and then add one more letter at a random position.
Return the letter that was added to t.

Example 1:
Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.

Example 2:
Input: s = "", t = "y"
Output: "y"

Constraints:
0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lowercase English letters.
 */
public class EASY_389_FindtheDifference {

    // bit manipulation
    /*
    Runtime: 2 ms, faster than 76.41% of Java online submissions for Find the Difference.
    Memory Usage: 42 MB, less than 66.55% of Java online submissions for Find the Difference.
     */
    public char findTheDifference1(String s, String t) {
        char ans = 0;
        for(char c : s.toCharArray())
            ans ^= c;
        for(char c : t.toCharArray())
            ans ^= c;
        return ans;
    }

    /*
    Runtime: 1 ms, faster than 99.83% of Java online submissions for Find the Difference.
    Memory Usage: 42.7 MB, less than 12.42% of Java online submissions for Find the Difference.
     */
    public char findTheDifference0(String s, String t) {
        int[] letters = new int[26];
        for(char c : s.toCharArray())
            letters[c-'a']--;
        for(char c : t.toCharArray())
            letters[c-'a']++;
        for(int i = 0; i< letters.length ;i++)
            if(letters[i] > 0)
                return (char)(i+'a');

        return ' ';
    }
}