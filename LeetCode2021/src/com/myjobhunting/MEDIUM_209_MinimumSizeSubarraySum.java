package com.myjobhunting;

// https://leetcode.com/problems/minimum-size-subarray-sum/

/*
Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:

1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
 */
public class MEDIUM_209_MinimumSizeSubarraySum {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Size Subarray Sum.
    Memory Usage: 45.2 MB, less than 24.61% of Java online submissions for Minimum Size Subarray Sum.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(right < nums.length)
        {
            sum+= nums[right];
            while(sum >= target)
            {
                ans = Math.min(ans, right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE? 0 : ans;
    }
}
