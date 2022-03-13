package com.myjobhunting;
// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

/*
Given an integer number n, return the difference between the product of its digits and the sum of its digits.

Example 1:
Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15

Example 2:
Input: n = 4421
Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21

Constraints:
1 <= n <= 10^5

 */
public class EASY_1281_SubtracttheProductandSumofDigitsofanInteger {

    /*
    Runtime: 1 ms, faster than 19.05% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
    Memory Usage: 41.1 MB, less than 21.27% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
     */
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while(n > 0)
        {
            int digit = n%10;
            prod *= digit;
            sum += digit;
            n /= 10;
        }
        return prod - sum;
    }
}
