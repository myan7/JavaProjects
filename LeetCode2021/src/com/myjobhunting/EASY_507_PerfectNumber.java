package com.myjobhunting;

// https://leetcode.com/problems/perfect-number/

/*
A perfect number is a positive integer that is equal to the sum of its positive divisors,
excluding the number itself.
A divisor of an integer x is an integer that can divide x evenly.
Given an integer n, return true if n is a perfect number, otherwise return false.

Example 1:
Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.

Example 2:
Input: num = 7
Output: false

Constraints:
1 <= num <= 108
 */
public class EASY_507_PerfectNumber {

    /*
    Runtime: 1978 ms, faster than 16.60% of Java online submissions for Perfect Number.
    Memory Usage: 41.5 MB, less than 10.68% of Java online submissions for Perfect Number.
     */
    public boolean checkPerfectNumber(int num) {
        return num == getSum(num);
    }
    private int getSum(int num)
    {
        int sum = 0;
        for(int i = num/2; i > 0;i--)
        {
            if(num%i==0)
                sum+=i;
            if(sum > num)
                return -1;
        }
        return sum;
    }
}
