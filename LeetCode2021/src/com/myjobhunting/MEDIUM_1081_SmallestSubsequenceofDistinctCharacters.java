package com.myjobhunting;

// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

import java.util.*;

/*
Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.

Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
 */
public class MEDIUM_1081_SmallestSubsequenceofDistinctCharacters {

    /*
    Runtime: 3 ms, faster than 82.62% of Java online submissions for Smallest Subsequence of Distinct Characters.
    Memory Usage: 42.1 MB, less than 51.03% of Java online submissions for Smallest Subsequence of Distinct Characters.
     */
    public String smallestSubsequence(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26], seen = new int[26];
        for (int i = 0; i < s.length(); ++i)
            last[s.charAt(i) - 'a'] = i;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            if (seen[c]++ > 0) continue;
            while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()])
                seen[stack.pop()] = 0;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack) sb.append((char)('a' + i));
        return sb.toString();
    }
    /*
    Runtime: 15 ms, faster than 5.37% of Java online submissions for Smallest Subsequence of Distinct Characters.
    Memory Usage: 42.5 MB, less than 18.80% of Java online submissions for Smallest Subsequence of Distinct Characters.
     */
    public String smallestSubsequence0(String s) {
        // stack will contain all the letters, in reverse order
        Stack<Character> stack = new Stack<>();

        // set is used to track single occurance in the stack.
        // so the remove and add for set, will appear the same time as stack pop and push.
        // they have to be in sync.
        Set<Character> seen = new HashSet<>();

        // map is used to track the last occurance for each character
        // when looping thru the string, as long as there is another same char in the later part, we can dispose it.
        Map<Character, Integer> lastOccurance = new HashMap<>();

        // get the last occurance for each character first.
        for(int i = 0; i< s.length(); i++)
        {
            lastOccurance.put(s.charAt(i), i);
        }

        for(int i = 0; i< s.length(); i++)
        {
            char curr = s.charAt(i);
            if(!seen.contains(curr))
            {
                // I need to check if there is any more occurance for the top of the stack.
                // if there are more, I can safely pop the stack, and make sure the first char in the stack
                // is the smallest.
                while(!stack.isEmpty() && curr < stack.peek() && lastOccurance.get(stack.peek()) > i)
                    seen.remove(stack.pop());
                seen.add(curr);
                stack.push(curr);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
            ans.insert(0,stack.pop());
        return ans.toString();
    }
}
