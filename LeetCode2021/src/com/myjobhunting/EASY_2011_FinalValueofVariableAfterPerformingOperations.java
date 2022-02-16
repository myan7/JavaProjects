package com.myjobhunting;
// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

/*
There is a programming language with only four operations and one variable X:

++X and X++ increments the value of the variable X by 1.
--X and X-- decrements the value of the variable X by 1.
Initially, the value of X is 0.

Given an array of strings operations containing a list of operations,
return the final value of X after performing all the operations.

 */
public class EASY_2011_FinalValueofVariableAfterPerformingOperations {

    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for(String str : operations){
            val += (str.indexOf('+') != -1) ? 1 : -1;
        }
        return val;
    }

    public int finalValueAfterOperations1(String[] operations) {
        int ans = 0;
        for(String str: operations)
        {
            if(str.charAt(1) == '+')
                ans++;
            else
                ans--;
        }
        return ans;
    }

    public int finalValueAfterOperations0(String[] operations) {
        int ans = 0;
        for(String str: operations)
        {
            if(str.equals("++X") || str.equals("X++"))
                ans++;
            else
                ans--;
        }
        return ans;
    }
}
