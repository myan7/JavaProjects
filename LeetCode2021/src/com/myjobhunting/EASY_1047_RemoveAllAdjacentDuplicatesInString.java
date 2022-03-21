package com.myjobhunting;
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

import java.util.Stack;

/*
You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:

1 <= s.length <= 10^5
s consists of lowercase English letters.
 */
public class EASY_1047_RemoveAllAdjacentDuplicatesInString {

    /*
    Runtime: 8 ms, faster than 93.94% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 48.2 MB, less than 75.30% of Java online submissions for Remove All Adjacent Duplicates In String.
     */
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }

    /*
    Runtime: 11 ms, faster than 86.43% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 42.7 MB, less than 91.55% of Java online submissions for Remove All Adjacent Duplicates In String.
     */
    public String removeDuplicates2(String s) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< s.length(); i++)
        {
            char curr = s.charAt(i);
            int size = sb.length();
            if(size > 0 && sb.charAt(size-1) == curr)
            {
                sb.deleteCharAt(size-1);
            }
            else if(size == 0 || sb.charAt(size-1) != curr)
            {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    /*
    Runtime: 15 ms, faster than 77.94% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 49 MB, less than 66.27% of Java online submissions for Remove All Adjacent Duplicates In String.
     */
    public String removeDuplicates1(String s) {

        StringBuilder sb = new StringBuilder();
        int index = -1;
        for(int i = 0; i< s.length(); i++)
        {
            char curr = s.charAt(i);
            if(index >= 0 && sb.charAt(index) == curr)
            {
                sb.deleteCharAt(index);
                index--;
            }
            else if(index == -1 || sb.charAt(index) != curr)
            {
                sb.append(curr);
                index++;
            }
        }
        return sb.toString();
    }

    /*
    Runtime: 149 ms, faster than 17.13% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 56.8 MB, less than 21.86% of Java online submissions for Remove All Adjacent Duplicates In String.
     */
    public String removeDuplicates0(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
            ans.insert(0,stack.pop());
        return ans.toString();
    }
}
