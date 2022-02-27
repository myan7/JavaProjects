package com.myjobhunting;

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

/*
You are given two strings of the same length s and t.
In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:
Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

Example 2:
Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.

Example 3:
Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams.

Constraints:
1 <= s.length <= 5 * 104
s.length == t.length
s and t consist of lowercase English letters only.
 */
public class MEDIUM_1347_MinimumNumberofStepstoMakeTwoStringsAnagram {


    // Runtime: 9 ms, faster than 97.33% of Java online submissions
    public int minSteps1(String s, String t) {
        int n = s.length(), ans = 0;
        int[] map = new int[26];
        for(int i = 0; i < n; i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for(int i : map)
            if(i > 0)
                ans += i;
        return ans;
    }

    // Runtime: 15 ms, faster than 63.97% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
    public int minSteps0(String s, String t) {
        int[] sa = new int[26];
        int[] ta = new int[26];

        int min = 0;
        for (int i = 0; i< s.length(); i++)
        {
            sa[s.charAt(i) - 'a']++;
            ta[t.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < 26; i++)
        {
            if(sa[i] != ta[i])
            {
                min += Math.abs(sa[i] - ta[i]);
            }
        }
        return min/2;
    }
}
