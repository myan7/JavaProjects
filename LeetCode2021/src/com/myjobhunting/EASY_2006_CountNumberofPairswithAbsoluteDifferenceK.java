package com.myjobhunting;
// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
/*
Given an integer array nums and an integer k,
return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:
x if x >= 0.
-x if x < 0.

Example 1:
Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]

Example 2:
Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.

Example 3:
Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
- [3,2,1,5,4] [3,1]
- [3,2,1,5,4] [2,5]
- [3,2,1,5,4] [1,4]


Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99
 */
public class EASY_2006_CountNumberofPairswithAbsoluteDifferenceK {
    // naive solution 11 ms O(n^2) faster than 30.81%
    public int countKDifference0(int[] nums, int k) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                if(Math.abs(nums[i] - nums[j]) == k)
                    cnt++;
            }
        }
        return cnt;
    }

    // map solution 1 ms 98.33%
    public int countKDifference1(int[] nums, int k) {
        int cnt = 0;
        int[] map = new int[101];
        for(int i : nums)
            map[i]++;
        for(int i = 0; i < 101-k ;i++)
        {
            cnt += map[i]*map[i+k];
        }
        return cnt;
    }
}
