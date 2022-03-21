package com.myjobhunting;
// https://leetcode.com/problems/validate-stack-sequences/

import java.util.Stack;

/*
Given two integer arrays pushed and popped each with distinct values,
return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.



Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.


Constraints:

1 <= pushed.length <= 1000
0 <= pushed[i] <= 1000
All the elements of pushed are unique.
popped.length == pushed.length
popped is a permutation of pushed.
 */
public class MEDIUM_946_ValidateStackSequences {

    /*
    Runtime: 3 ms, faster than 83.38% of Java online submissions for Validate Stack Sequences.
    Memory Usage: 41.8 MB, less than 90.37% of Java online submissions for Validate Stack Sequences.
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len1 = pushed.length, len2 = popped.length;
        if(len1 != len2) return false;
        Stack<Integer> stack = new Stack<>();
        int curr1 = 0,curr2 = 0;
        while(curr1 < len1)
        {
            stack.push(pushed[curr1++]);
            while(!stack.isEmpty() && stack.peek() == popped[curr2])
            {
                stack.pop();
                curr2++;
            }
        }
        return stack.isEmpty();
    }
}
