package com.myjobhunting;

import java.util.Stack;

public class EASY_020_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0 || s.length() == 1)
            return false;
        else
        {
            for (char c: s.toCharArray())
            {
                if(c == '(')
                    stack.push(')');
                else if ( c == '[')
                    stack.push(']');
                else if ( c == '{')
                    stack.push('}');
                else if(stack.isEmpty() || stack.pop() != c)
                    return false;
            }

            return stack.isEmpty();
        }
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if(!stack.isEmpty())
            {
                if (c == ')' && stack.pop() == '(')
                {}
                else if (c == ']' && stack.pop() == '[')
                {}
                else if (c == '}' && stack.pop() == '{')
                {}
                else
                    return false;
            }
            else
                return false;
        }
        return stack.isEmpty();
    }
}
