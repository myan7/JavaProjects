package com.myjobhunting;
// https://leetcode.com/problems/arranging-coins/

/*
You have n coins and you want to build a staircase with these coins.
The staircase consists of k rows where the ith row has exactly i coins.
The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.

Constraints:
1 <= n <= 231 - 1
 */
public class EASY_441_ArrangingCoins {

    /*
    Runtime: 2 ms, faster than 89.21% of Java online submissions for Arranging Coins.
    Memory Usage: 42.1 MB, less than 15.60% of Java online submissions for Arranging Coins.
     */
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while(left <= right)
        {
            long mid = left + (right - left)/2;
            long sum = mid*(mid+1)/2;
            if(sum <= n)
                left = (int)mid+1;
            else
                right = (int)mid-1;
        }
        return right;
    }
}
