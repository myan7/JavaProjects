package com.myjobhunting;

// https://leetcode.com/problems/monotonic-array/

/*
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:
Input: nums = [1,2,2,3]
Output: true

Example 2:
Input: nums = [6,5,4,4]
Output: true

Example 3:
Input: nums = [1,3,2]
Output: false

Constraints:
1 <= nums.length <= 10^5
-105 <= nums[i] <= 10^5
 */
public class EASY_896_MonotonicArray {


    /*
    Runtime: 2 ms, faster than 86.36% of Java online submissions for Monotonic Array.
    Memory Usage: 52.7 MB, less than 87.10% of Java online submissions for Monotonic Array.
     */
    public boolean isMonotonic_LC(int[] nums) {
        int store = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            int c = Integer.compare(nums[i], nums[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }
        return true;
    }
    /*
    Runtime: 4 ms, faster than 41.28% of Java online submissions for Monotonic Array.
    Memory Usage: 52.8 MB, less than 83.59% of Java online submissions for Monotonic Array.
     */
    public boolean isMonotonic1(int[] nums) {
        boolean inc = true, dec = true;
        for (int i = 1; i < nums.length; ++i) {
            inc &= nums[i - 1] <= nums[i];
            dec &= nums[i - 1] >= nums[i];
        }
        return inc || dec;
    }

    /*
    Runtime: 3 ms, faster than 62.60% of Java online submissions for Monotonic Array.
    Memory Usage: 53 MB, less than 82.45% of Java online submissions for Monotonic Array.
     */
    public boolean isMonotonic0(int[] nums) {
        if(nums.length == 1)
            return true;
        int ans = 0;
        int len = nums.length;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < nums[i-1])
                ans--;
            else if(nums[i] > nums[i-1])
                ans++;
            else
                len--;
        }
        return Math.abs(ans)+1 == len;
    }
}
