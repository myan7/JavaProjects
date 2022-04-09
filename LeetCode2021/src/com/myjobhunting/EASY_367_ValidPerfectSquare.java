package com.myjobhunting;

// https://leetcode.com/problems/valid-perfect-square/
/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

Example 1:
Input: num = 16
Output: true

Example 2:
Input: num = 14
Output: false

Constraints:
1 <= num <= 2^31 - 1
 */
public class EASY_367_ValidPerfectSquare {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
    Memory Usage: 41.1 MB, less than 27.09% of Java online submissions for Valid Perfect Square.
     */
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num/2;
        while(left <= right)
        {
            long mid = left + (right - left)/2;
            if(mid * mid == num)
                return true;
            else if(mid * mid < num)
                left = mid+1;
            else
                right = mid -1;
        }
        return left == 1;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
    Memory Usage: 40.2 MB, less than 78.81% of Java online submissions for Valid Perfect Square.
     */
    public boolean isPerfectSquare20220403(int num) {
        if(num == 1)
            return true;
        int left = 0, right = num/2;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(mid == (double)num/mid )
                return true;
            if(mid == 0)
                return false;
            else if( mid < num/mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if(num < 2)
            return true;
        int left = 2, right = num/2;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(mid == (double)num/mid )
                return true;
            else if( mid < num/mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public boolean isPerfectSquare3(int num) {
        if (num < 2) return true;

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
