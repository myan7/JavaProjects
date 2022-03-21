package com.myjobhunting;

// https://leetcode.com/problems/partition-labels/

import java.util.ArrayList;
import java.util.List;

/*
You are given a string s.
We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.

Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: s = "eccbbbbdec"
Output: [10]

Constraints:
1 <= s.length <= 500
s consists of lowercase English letters.
 */
public class MEDIUM_763_PartitionLabels {

    /* Greedy
    Runtime: 4 ms, faster than 84.90% of Java online submissions for Partition Labels.
    Memory Usage: 42.8 MB, less than 44.15% of Java online submissions for Partition Labels.
    Time Complexity: O(N), where N is the length of S.
    Space Complexity: O(1) to keep data structure last of not more than 26 characters.
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] letters = new int[26];
        int len = s.length();
        // get the last index for each char.
        for(int i = 0 ; i < len; i++)
            letters[s.charAt(i)-'a'] = i;

        int j = 0, anchor = 0;
        for(int i = 0; i < len; i++)
        {
            j = Math.max(j, letters[s.charAt(i)-'a']); // get the last index of curr char
            // if curr index is the last index of the char in this string, j.
            // which means all the char before this char, will never show up in the later part of the string.,
            if(i == j)
            {
                ans.add(i-anchor+1);
                anchor = i+1; // anchor is to track the stopping point from the previous sub string.
            }
        }
        return ans;
    }
}
