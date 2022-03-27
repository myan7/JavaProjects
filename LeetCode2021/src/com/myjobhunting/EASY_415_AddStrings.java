package com.myjobhunting;

// https://leetcode.com/problems/add-strings/

/*
Given two non-negative integers, num1 and num2 represented as string,
return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
You must also not convert the inputs to integers directly.

Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:
Input: num1 = "0", num2 = "0"
Output: "0"

Constraints:
1 <= num1.length, num2.length <= 10^4
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.

 */
public class EASY_415_AddStrings {

    /*
    Runtime: 4 ms, faster than 52.79% of Java online submissions for Add Strings.
    Memory Usage: 43.9 MB, less than 30.06% of Java online submissions for Add Strings.
     */
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        int len1 = num1.length(), len2 = num2.length();
        int index1 = len1-1;
        int index2 = len2-1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while(index1 >=0 || index2 >= 0)
        {
            int x = index1 >= 0? c1[index1--]-'0': 0;
            int y = index2 >= 0? c2[index2--]-'0': 0;
            int sum = x+y+carry;
            int curr = sum%10;
            carry = sum/10;

            ans.insert(0,(char)(curr+'0'));
        }
        if(carry == 1)
            return ans.insert(0,'1').toString();
        else
            return ans.toString();
    }

}
