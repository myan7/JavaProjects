package com.myjobhunting;
// https://leetcode.com/problems/count-the-number-of-consistent-strings/
/*
You are given a string, allowed, consisting of distinct characters and an array of strings words.
A string is consistent if all characters in the string appear in the string, allowed.

Return the number of consistent strings in the array, words.

Example 1:
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

Example 3:
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.

Constraints:
1 <= words.length <= 104
1 <= allowed.length <= 26
1 <= words[i].length <= 10
The characters in allowed are distinct.
words[i] and allowed contain only lowercase English letters.
 */
public class EASY_1684_CounttheNumberofConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedChar = new int[26];
        for(char c: allowed.toCharArray())
            allowedChar[c-'a']++;

        int count = 0;
        for(String word: words)
        {
            if(isConsitent(word,allowedChar))
                count++;
        }
        return count;
    }
    private boolean isConsitent(String word, int[] allowedChar)
    {
        for(char c: word.toCharArray())
        {
            if(allowedChar[c-'a'] == 0)
                return false;
        }
        return true;
    }

    public int countConsistentStrings1(String allowed, String[] words) {
        int count = words.length;
        int[] arr = new int[26];
        for(char ch : allowed.toCharArray()) {
            arr[ch - 'a']++;
        }

        for(String word : words) {
            for(char ch : word.toCharArray()) {
                if(arr[ch - 'a'] == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
