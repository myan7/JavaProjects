package com.myjobhunting;
// https://leetcode.com/problems/bitwise-and-of-numbers-range/

/*
Given two integers left and right that represent the range [left, right],
return the bitwise AND of all numbers in this range, inclusive.

Example 1:
Input: left = 5, right = 7
Output: 4

Example 2:
Input: left = 0, right = 0
Output: 0

Example 3:
Input: left = 1, right = 2147483647
Output: 0

Constraints:
0 <= left <= right <= 2^31 - 1
 */
public class MEDIUM_201_BitwiseANDofNumbersRange {
    /*
    Runtime: 9 ms, faster than 53.76% of Java online submissions for Bitwise AND of Numbers Range.
    Memory Usage: 44 MB, less than 42.48% of Java online submissions for Bitwise AND of Numbers Range.
     */
    public int rangeBitwiseAnd(int left, int right) {
        int a = 0;
        while(left != right) {
            left >>= 1;
            right >>= 1;
            a++;
        }
        return left<<a;
    }
}
