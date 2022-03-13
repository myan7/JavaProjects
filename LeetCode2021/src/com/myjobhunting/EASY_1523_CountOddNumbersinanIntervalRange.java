package com.myjobhunting;
// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

/*
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

Example 1:
Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].

Example 2:
Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].

Constraints:

0 <= low <= high <= 10^9
 */
public class EASY_1523_CountOddNumbersinanIntervalRange {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Odd Numbers in an Interval Range.
    Memory Usage: 40.9 MB, less than 43.48% of Java online submissions for Count Odd Numbers in an Interval Range.
     */
    public int countOdds(int low, int high) {

        if(high% 2 != 0 || low%2 != 0)
            return (high - low)/2+1;
        else
            return (high - low)/2;

        /*
        if asking for even number
        if(high% 2 == 0 || low%2 == 0)
            return (high - low)/2+1;
        else
            return (high - low)/2;

         */
    }

    /*
    My idea here is to make both the numbers odd as it would make the problem much easier.
    We increase the low by 1 and decrease the high by 1 if they are not odd. If the nums are odd already, we do not change them.
    Simply return the answer as (high - low)/2 + 1;. As, now we count the low and high inclusive.
    For instance, low = 4, high = 8 is same as low = 5 and high = 7 as the odds are only [5,7].
     */
    public static int countOdds1(int low, int high) {
        if(low%2 == 0)
            low += 1;
        if(high%2 == 0)
            high -= 1;
        return (high - low)/2 + 1;
    }

    /* similation, naive solution
    Time Limit Exceeded
     */
    public int countOdds0(int low, int high) {
        int count = 0;
        while(low <= high)
        {
            if(low%2 != 0 )
                count++;
            low++;
        }
        return count;
    }
}
