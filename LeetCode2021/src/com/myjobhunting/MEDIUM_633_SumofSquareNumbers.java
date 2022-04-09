package com.myjobhunting;
// https://leetcode.com/problems/sum-of-square-numbers/

/*
Given a non-negative integer c,
decide whether there are two integers a and b such that a2 + b2 = c.

Example 1:
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:
Input: c = 3
Output: false

Constraints:
0 <= c <= 2^31 - 1
 */
public class MEDIUM_633_SumofSquareNumbers {

    /*
    Runtime: 1 ms, faster than 99.31% of Java online submissions for Sum of Square Numbers.
    Memory Usage: 41.6 MB, less than 18.90% of Java online submissions for Sum of Square Numbers.
     */
    public boolean judgeSquareSum_LC_Fermat(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

    /*
    Runtime: 423 ms, faster than 5.11% of Java online submissions for Sum of Square Numbers.
    Memory Usage: 41.4 MB, less than 32.45% of Java online submissions for Sum of Square Numbers.
     */
    public boolean judgeSquareSum(int c) {
        for(long left = 0; left*left <= c; left++)
        {
            int leftover = c - (int)(left*left);
            if(binarySearch(0,leftover,leftover))
                return true;
        }
        return false;
    }

    private boolean binarySearch(long left, long right, long target)
    {
        if(left > right)
            return false;
        long mid = left + (right - left)/2;
        if (mid*mid == target)
            return true;
        else if(mid*mid > target)
            return binarySearch(left, mid-1,target);
        return binarySearch(mid+1,right, target);
    }

}
