package com.myjobhunting;

// https://leetcode.com/problems/longest-repeating-substring/

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, return the length of the longest repeating substrings.
If no repeating substring exists, return 0.

Example 1:
Input: s = "abcd"
Output: 0
Explanation: There is no repeating substring.

Example 2:
Input: s = "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.

Example 3:
Input: s = "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.

Constraints:
1 <= s.length <= 2000
s consists of lowercase English letters.
 */
public class MEDIUM_1062_L_LongestRepeatingSubstring {

    /*
    Runtime: 11 ms, faster than 74.81% of Java online submissions for Longest Repeating Substring.
    Memory Usage: 47.8 MB, less than 61.46% of Java online submissions for Longest Repeating Substring.
     */
    /*
    Time complexity : O(NlogN) in the average case and O(N^2) in the worst case.
    One needs O((N−L)L) for one duplicate check,
    and one does up to O(logN) checks.
    Together that results in O(NlogN) in the average case and in O(N^2) in the worst case of L close to N/2.
    Space complexity : O(N) to keep the hashset.
    */
    public int longestRepeatingSubstring(String s) {
        int left = 1, right = s.length();
        while(left <= right)
        {
            int mid = left+ (right-left)/2;
            if(isValid(s,mid))
                left = mid+1;
            else
                right = mid-1;
        }
        return left-1;
    }

    private boolean isValid(String s, int midPoint)
    {
        Set<String> seen = new HashSet<>();
        for(int start = 0; start < s.length() - midPoint+1; start++)
        {
            int end = start + midPoint;
            String sub = s.substring(start,end);
            if(seen.contains(sub))
                return true;
            seen.add(sub);
        }
        return false;
    }
}
