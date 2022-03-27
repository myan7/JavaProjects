package com.myjobhunting;
// https://leetcode.com/problems/consecutive-characters/

import java.util.Stack;

/*
The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.

Example 1:
Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

Example 2:
Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

Constraints:
1 <= s.length <= 500
s consists of only lowercase English letters.
 */
public class EASY_1446_ConsecutiveCharacters {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Consecutive Characters.
    Memory Usage: 41 MB, less than 79.38% of Java online submissions for Consecutive Characters.
     */
    public int maxPower(String s) {
        int max = 1, count = 1;
        for(int i = 1; i < s.length();)
        {
            char prev = s.charAt(i-1);
            if(prev == s.charAt(i))
            {
                while(i< s.length() && s.charAt(i) == prev)
                {
                    count++;
                    max = Math.max(max,count);
                    i++;
                }
            }
            else
            {
                count = 1;
                i++;
            }
        }
        return max;
    }
    /*
    Runtime: 9 ms, faster than 5.19% of Java online submissions for Consecutive Characters.
    Memory Usage: 43.9 MB, less than 5.44% of Java online submissions for Consecutive Characters.
     */
    public int maxPower0(String s) {
        int max = 1, count = 1;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(!stack.isEmpty() && c == stack.peek())
            {
                count++;
                max = Math.max(max,count);
            }
            else
            {
                stack.push(c);
                count = 1;
            }

        }
        return s.length() == 0? 0: max;
    }
}
