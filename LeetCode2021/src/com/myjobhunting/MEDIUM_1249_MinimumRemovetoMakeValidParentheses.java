package com.myjobhunting;

import java.util.Arrays;
import java.util.Stack;

public class MEDIUM_1249_MinimumRemovetoMakeValidParentheses {

    /*
    Runtime: 39 ms, faster than 41.97% of Java online submissions for Minimum Remove to Make Valid Parentheses.
    Memory Usage: 42.9 MB, less than 88.11% of Java online submissions for Minimum Remove to Make Valid Parentheses.
    */
    public String minRemoveToMakeValid0(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< s.length(); i++)
        {
            char curr = s.charAt(i);
            if(!Character.isLetter(curr))
            {
                if(!stack.isEmpty())
                {
                    int index = stack.peek();
                    if(s.charAt(index) == '(' && s.charAt(i) == ')')
                        stack.pop();
                    else
                        stack.push(i);
                }
                else
                    stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        int prev = 0;
        for(Integer curr:stack)
        {
            sb.append(s,prev,curr);
            prev = curr+1;
        }
        return sb.append(s.substring(prev)).toString();
    }

    /*
    Runtime: 36 ms, faster than 46.77% of Java online submissions for Minimum Remove to Make Valid Parentheses.
    Memory Usage: 42.7 MB, less than 91.87% of Java online submissions for Minimum Remove to Make Valid Parentheses.
     */
    public String minRemoveToMakeValid(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            sb.append(curr);
            if(!Character.isLetter(curr))
            {
                if(curr == '(')
                    stack.push(i);
                else
                {
                    if (!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                        stack.pop();
                    else
                        stack.push(i);
                }
            }
        }

        while(!stack.isEmpty())
        {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }

}
