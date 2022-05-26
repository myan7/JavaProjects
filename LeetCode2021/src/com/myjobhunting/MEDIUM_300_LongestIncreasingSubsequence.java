package com.myjobhunting;

// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Arrays;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 10^4


Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class MEDIUM_300_LongestIncreasingSubsequence {


    /* DP
    Runtime: 54 ms, faster than 66.59% of Java online submissions for Longest Increasing Subsequence.
    Memory Usage: 41.6 MB, less than 92.87% of Java online submissions for Longest Increasing Subsequence.
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            dp[i] = 1;
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j] +1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
