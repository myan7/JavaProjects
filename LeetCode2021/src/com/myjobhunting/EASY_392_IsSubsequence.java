package com.myjobhunting;

// https://leetcode.com/problems/is-subsequence/

/*
Given two strings s and t,
return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string
that is formed from the original string
by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class EASY_392_IsSubsequence {

    // initial solution
    /*
    Runtime: 1 ms, faster than 88.36% of Java online submissions for Is Subsequence.
    Memory Usage: 42.4 MB, less than 12.34% of Java online submissions for Is Subsequence.
    Time O(T), lenT, Space O(1)
     */
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if(lenS > lenT) return false;
        if(lenS == 0) return true;
        int si = 0, ti = 0;
        while(si < lenS && ti < lenT)
        {
            if(s.charAt(si) == t.charAt(ti))
            {
                si++;
                ti++;
            }
            else
                ti++;
            if(si == lenS)
                return true;
        }
        return false;
    }
}
