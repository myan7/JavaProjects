package com.myjobhunting;
// https://leetcode.com/problems/largest-substring-between-two-equal-characters/

/*
Given a string s, return the length of the longest substring between two equal characters, excluding the two characters.
If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

Example 1:
Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.

Example 2:
Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".

Example 3:
Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.

Constraints:
1 <= s.length <= 300
s contains only lowercase English letters.
 */
public class EASY_1624_LargestSubstringBetweenTwoEqualCharacters {

    /*
    Runtime: 1 ms, faster than 84.62% of Java online submissions for Largest Substring Between Two Equal Characters.
    Memory Usage: 41.8 MB, less than 51.84% of Java online submissions for Largest Substring Between Two Equal Characters.
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] indices = new int[26];
        int maxLen = -1;
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'a';
            if (indices[idx] > 0) {
                maxLen = Math.max(maxLen, i - indices[idx]);
            }else {
                indices[idx] = i + 1;
            }
        }
        return maxLen;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Substring Between Two Equal Characters.
    Memory Usage: 39.8 MB, less than 86.29% of Java online submissions for Largest Substring Between Two Equal Characters.
     */
    public int maxLengthBetweenEqualCharacters0(String s) {
        int max = -1, count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            int lastIndex = s.lastIndexOf(curr);
            if(lastIndex != -1)
            {
                count = lastIndex - i-1;
                max = Math.max(max, count);
            }
            else
            {
                count = 0;
            }
        }
        return max;
    }
}
