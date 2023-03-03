package com.myjobhunting;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]

Constraints:
n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime?
You may assume the returned list does not count as extra space.


 */
public class EASY_448_FindAllNumbersDisappearedinanArray {

    /*
    Runtime: 8 ms, faster than 65.80% of Java online submissions for Find All Numbers Disappeared in an Array.
    Memory Usage: 68.7 MB, less than 26.38% of Java online submissions for Find All Numbers Disappeared in an Array.
    O(N)
    O(1)
    negative masking
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++ )
        {
            int newIndex = Math.abs(nums[i])-1;
            if(nums[newIndex] > 0)
                nums[newIndex] *= -1;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i<= nums.length;i++)
        {
            if(nums[i-1] > 0)
                ans.add(i);
        }
        return ans;
    }
}
