package com.myjobhunting;

// https://leetcode.com/problems/longest-valid-parentheses/

import java.util.Stack;

/*
Given a string containing just the characters '(' and ')',
find the length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0

Constraints:
0 <= s.length <= 3 * 10^4
s[i] is '(', or ')'.
 */
public class HARD_032_LongestValidParentheses {


    /*
    Runtime: 6 ms, faster than 54.51% of Java online submissions for Longest Valid Parentheses.
    Memory Usage: 42.5 MB, less than 75.98% of Java online submissions for Longest Valid Parentheses.
    https://www.cnblogs.com/grandyang/p/4424731.html
    这道求最长有效括号比之前那道 Valid Parentheses 难度要大一些，
    这里还是借助栈来求解，需要定义个 start 变量来记录合法括号串的起始位置，遍历字符串，
    如果遇到左括号，则将当前下标压入栈，
    如果遇到右括号，
        如果当前栈为空，则将下一个坐标位置记录到 start，
        如果栈不为空，则将栈顶元素取出，
            此时若栈为空，则更新结果和 i - start + 1 中的较大值，否则更新结果和 i - st.top() 中的较大值
     */
    public int longestValidParentheses2(String s) {
        int res = 0, start = 0, n = s.length();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else if (s.charAt(i) == ')') {
                if (st.empty())
                    start = i + 1;
                else {
                    st.pop();
                    res = st.empty() ? Math.max(res, i - start + 1) : Math.max(res, i - st.peek());
                }
            }
        }
        return res;
    }

    /*
    Runtime: 5 ms, faster than 59.50% of Java online submissions for Longest Valid Parentheses.
    Memory Usage: 42.6 MB, less than 73.34% of Java online submissions for Longest Valid Parentheses.
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            if(curr == '(')
                stack.push(i);
            else
            {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Valid Parentheses.
    Memory Usage: 40.8 MB, less than 98.95% of Java online submissions for Longest Valid Parentheses.
     */
    public int longestValidParentheses0(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
