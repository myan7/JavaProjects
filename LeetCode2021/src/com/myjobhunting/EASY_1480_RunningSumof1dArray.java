package com.myjobhunting;

// https://leetcode.com/problems/running-sum-of-1d-array/

public class EASY_1480_RunningSumof1dArray {
    public int[] runningSum(int[] nums) {

        if(nums.length <= 1)
            return nums;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            dp[i] = nums[i] + dp[i-1];
        }
        return dp;
    }

    public int[] runningSum1(int[] nums)
    {
        for(int i = 1; i < nums.length; i++)
        {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
