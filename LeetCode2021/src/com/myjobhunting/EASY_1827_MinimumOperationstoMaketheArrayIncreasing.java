package com.myjobhunting;
// https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

/*
You are given an integer array nums (0-indexed).
In one operation, you can choose an element of the array and increment it by 1.

For example,
if nums = [1,2,3], you can choose to increment nums[1] to make nums = [1,3,3].
Return the minimum number of operations needed to make nums strictly increasing.

An array nums is strictly increasing if nums[i] < nums[i+1] for all 0 <= i < nums.length - 1.
An array of length 1 is trivially strictly increasing.

 */
public class EASY_1827_MinimumOperationstoMaketheArrayIncreasing {
    public int minOperations(int[] nums) {
        int steps = 0, prev = 0;
        for(int num: nums)
        {
            if(num > prev)
                prev = num;
            else
                steps += ++prev-num;
        }
        return steps;
    }

    public int minOperations0(int[] nums) {
        int steps = 0;
        int curr  = nums[0];
        if(nums.length == 1)
            return 0;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > curr)
            {
                curr = nums[i];
            }
            else
            {
                steps += Math.abs(nums[i]-curr)+1;
                curr = curr+1;
            }
        }
        return steps;
    }
}
