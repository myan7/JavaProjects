package com.myjobhunting;

import java.util.Stack;

// https://leetcode.com/problems/score-of-parentheses/
/*
Given a balanced parentheses string s, return the score of the string.
The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

Example 1:
Input: s = "()"
Output: 1

Example 2:
Input: s = "(())"
Output: 2

Example 3:
Input: s = "()()"
Output: 2

Constraints:
2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string.
 */
public class MEDIUM_856_ScoreofParentheses {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Score of Parentheses.
    Memory Usage: 41.9 MB, less than 48.47% of Java online submissions for Score of Parentheses.

    2 * (1+2 * (1) ) = 2 * 1 + 2 * 2 * 1
    the bal is actually the multiply, count the number of left parentheses before the right,
    of course the latest added one needs to be removed. then the number will be the multiply.
    also, when looping through a closing parenthesis, check the previous one, if it is the opening parenthesis,
    then add the multiply to the sum.
     */
    public int scoreOfParentheses(String s) {
        int ans = 0, bal = 0;
        for(int i = 0; i < s.length() ; i++)
        {
            char curr = s.charAt(i);
            if(curr == '(')
                bal++;
            else
            {
                char prev = s.charAt(i-1);
                bal--;
                if(prev == '(')
                    ans = ans + (1<<bal);
            }
        }
        return ans;
    }

    /*
    Runtime: 1 ms, faster than 68.54% of Java online submissions for Score of Parentheses.
    Memory Usage: 42.6 MB, less than 7.07% of Java online submissions for Score of Parentheses.
     */
    public int scoreOfParentheses1(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur); // keep tracking current score for current char
                cur = 0;
            } else {  // when seeing a closing parenthesis, get the sum.
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }

    /*
    Divide and conquer
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Score of Parentheses.
    Memory Usage: 42.4 MB, less than 12.45% of Java online submissions for Score of Parentheses.
     */
    public int scoreOfParentheses2(String s) {
        return F(s, 0, s.length());
    }
    private int F(String s, int i, int j) {
        //Score of balanced string s[i:j]
        int ans = 0, bal = 0;

        // Split string into primitives
        for (int k = i; k < j; ++k) {
            bal += s.charAt(k) == '(' ? 1 : -1;
            if (bal == 0) {
                if (k - i == 1) ans++;
                else ans += 2 * F(s, i+1, k);
                i = k+1;
            }
        }
        return ans;
    }
}
