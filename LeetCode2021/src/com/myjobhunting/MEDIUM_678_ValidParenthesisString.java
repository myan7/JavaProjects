package com.myjobhunting;
// https://leetcode.com/problems/valid-parenthesis-string/
/*
also check LC 2116 https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(*)"
Output: true

Example 3:
Input: s = "(*))"
Output: true

Constraints:
1 <= s.length <= 100
s[i] is '(', ')' or '*'.
 */
public class MEDIUM_678_ValidParenthesisString {

    /*
    Runtime: 1 ms, faster than 54.56% of Java online submissions for Valid Parenthesis String.
    Memory Usage: 41.7 MB, less than 55.27% of Java online submissions for Valid Parenthesis String.
     */
    public boolean checkValidString(String s) {
        int balance = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(' || c == '*')
                balance++;
            else
                balance--;
            if(balance < 0)
                return false;
        }

        balance = 0;
        for(int i = s.length()-1; i >= 0; i--)
        {
            char curr = s.charAt(i);
            if(curr == ')' || curr == '*')
                balance++;
            else
                balance--;
            if(balance < 0)
                return false;
        }
        return true;
    }
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Parenthesis String.
    Memory Usage: 42.7 MB, less than 6.90% of Java online submissions for Valid Parenthesis String.

Let lo, hi respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.

If we encounter a left bracket (c == '('), then lo++, otherwise we could write a right bracket, so lo--.
If we encounter what can be a left bracket (c != ')'), then hi++, otherwise we must write a right bracket, so hi--.
If hi < 0, then the current prefix can't be made valid no matter what our choices are.
Also, we can never have less than 0 open left brackets.
At the end, we should check that we can have exactly 0 open left brackets.
     */
    public boolean checkValidString_LC(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0); //  this is for "(*)"
        }
        return lo == 0;
    }
}
