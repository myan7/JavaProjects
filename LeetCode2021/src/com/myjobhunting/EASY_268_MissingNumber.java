package com.myjobhunting;

//https://leetcode.com/problems/missing-number/

public class EASY_268_MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len*(len+1)/2;
        for(int i : nums)
        {
            sum -= i;
        }
        return sum;
    }
    // n^n = 0, and n^0 = n
    public int missingNumber1(int[] nums)
    {
        int missing = 0, i;
        for(i = 0;i < nums.length; i++)
        {
            missing = missing^i^nums[i];
        }
        missing = missing^i;
        return missing;
    }
}
