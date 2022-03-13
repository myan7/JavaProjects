package com.myjobhunting;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /.
Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid.
That means the expression would always evaluate to a result, and there will not be any division by zero operation.

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class MEDIUM_150_EvaluateReversePolishNotation {

    /*  Initial solution
    Runtime: 5 ms, faster than 86.90% of Java online submissions for Evaluate Reverse Polish Notation.
    Memory Usage: 41.9 MB, less than 58.07% of Java online submissions for Evaluate Reverse Polish Notation.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(String s : tokens)
        {
            if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")))
            {
                int tmp = Integer.parseInt(s);
                stack.push(tmp);
            }
            else
            {
                int op2 = stack.pop();
                int op1 = stack.pop();

                switch (s){
                    case "+":
                        ans = op1 + op2;
                        break;
                    case "-":
                        ans = op1 - op2;
                        break;
                    case "*":
                        ans = op1 * op2 ;
                        break;
                    case "/":
                        ans = op1 / op2 ;
                }
                stack.push(ans);
            }
        }
        return stack.pop();
    }
}
