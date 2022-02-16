package com.myjobhunting;
// https://leetcode.com/problems/concatenation-of-array/

/*
Given an integer array nums of length n,
you want to create an array ans of length 2n
where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

 */

public class EASY_1929_ConcatenationofArray {
    // faster. beats 72.5% memory usage
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2*len];
        for(int i = 0 ; i < len; i++)
        {
                ans[i] = nums[i];
                ans[i+len] = nums[i];
        }
        return ans;
    }

    // 1ms, beats
    public int[] getConcatenation0(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2*len];
        for(int i = 0 ; i < 2*len; i++)
        {
            if( i < len)
                ans[i] = nums[i];
            else
                ans[i] = nums[i-len];
        }
        return ans;
    }
}
