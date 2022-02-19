package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-target-indices-after-sorting-array/
/*
You are given a 0-indexed integer array nums and a target element target.
A target index is an index i such that nums[i] == target.
Return a list of the target indices of nums after sorting nums in non-decreasing order.
If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

Example 1:
Input: nums = [1,2,5,2,3], target = 2
Output: [1,2]
Explanation: After sorting, nums is [1,2,2,3,5].
The indices where nums[i] == 2 are 1 and 2.

Example 2:
Input: nums = [1,2,5,2,3], target = 3
Output: [3]
Explanation: After sorting, nums is [1,2,2,3,5].
The index where nums[i] == 3 is 3.

Example 3:
Input: nums = [1,2,5,2,3], target = 5
Output: [4]
Explanation: After sorting, nums is [1,2,2,3,5].
The index where nums[i] == 5 is 4.

Constraints:
1 <= nums.length <= 100
1 <= nums[i], target <= 100
 */
public class EASY_2089_FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        int[] map = new int[101];
        int[] dp = new int[101];
        for(int i : nums)
        {
            map[i]++;
            dp[i]++;
        }
        for(int i = 1; i < 101; i++)
            dp[i] += dp[i-1];

        List<Integer> ans = new ArrayList<>();
        int count = map[target];
        int startIndex = dp[target-1];
        while(count > 0)
        {
            ans.add(startIndex);
            startIndex++;
            count--;
        }
        return ans;
    }
}
