package com.myjobhunting;
// https://leetcode.com/problems/remove-outermost-parentheses/

import java.util.HashMap;
import java.util.Map;

/*
A valid parentheses string is either empty "", "(" + A + ")", or A + B,
where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty,
and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

Example 1:
Input: s = "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Example 2:
Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

Example 3:
Input: s = "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".

Constraints:
1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.
 */
public class EASY_1021_RemoveOutermostParentheses {

    /*
    Runtime: 4 ms, faster than 74.58% of Java online submissions for Remove Outermost Parentheses.
    Memory Usage: 42.9 MB, less than 41.22% of Java online submissions for Remove Outermost Parentheses.

    input = "()()()" correct output is "", even though it is primitive,
     */
    public String removeOuterParentheses(String s)
    {
        //instead of using a map to track the level, we can use an int
        StringBuilder sb = new StringBuilder();
        int lvl = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                lvl++;
            if (lvl > 1)
                sb.append(s.charAt(i));
            if (s.charAt(i) == ')')
                lvl--;
        }
        return sb.toString();
    }

    /*
    Runtime: 13 ms, faster than 27.43% of Java online submissions for Remove Outermost Parentheses.
    Memory Usage: 46.9 MB, less than 18.86% of Java online submissions for Remove Outermost Parentheses.
     */
    public String removeOuterParentheses0(String s) {
        // map is to keep track of the level of the pair, if 0, means the outermost, which when appending to the stringbuilder
        // will be skipped.
        Map<Integer, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        int lvl = 0;
        for(int i = 0; i< s.length();i++)
        {
            char curr = s.charAt(i);
            if(curr == '(')
                map.put(i,lvl++);
            else
                map.put(i,--lvl);
        }
        for(int i = 0; i < s.length(); i++)
        {
            if(map.get(i) == 0)
                continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
