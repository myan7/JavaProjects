package com.myjobhunting;

//
/*
An integer array is called arithmetic
if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic sub-arrays of nums.

A sub-array is a contiguous subsequence of the array.

Example 1:
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

Example 2:
Input: nums = [1]
Output: 0

Constraints:
1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
 */

public class MEDIUM_413_ArithmeticSlices {

    // dynamic programming
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Arithmetic Slices.
    Memory Usage: 42.4 MB, less than 11.43% of Java online submissions for Arithmetic Slices.
    similar to climb stairs.
    if there are 3 numbers are arithmetic slice, then if there is another number meet the condition
    that means 123, 234, 1234 will be all valid slices
    like if climb 1 step and climb 2 steps.
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int count = 0;
        for(int i = 2; i < len ; i++ )
        {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
            {
                dp[i] = dp[i-1] + 1;
                count += dp[i];
            }
        }
        return count;
    }

    // brute force
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Arithmetic Slices.
    Memory Usage: 41.8 MB, less than 32.16% of Java online submissions for Arithmetic Slices.
     */
    public int numberOfArithmeticSlices0(int[] nums) {
        int count = 0;
        for (int s = 0; s < nums.length - 2; s++) {
            int d = nums[s + 1] - nums[s];
            for (int e = s + 2; e < nums.length; e++) {
                if (nums[e] - nums[e - 1] == d)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}
