package com.myjobhunting;
// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

/*
Given the array of integers, nums,
you will choose two different indices i and j of that array.
Return the maximum value of (nums[i]-1)*(nums[j]-1).

Example 1:
Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0),
you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.

Example 2:
Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0),
you will get the maximum value of (5-1)*(5-1) = 16.

Example 3:
Input: nums = [3,7]
Output: 12

Constraints:
2 <= nums.length <= 500
1 <= nums[i] <= 10^3

 */
public class EASY_1464_MaximumProductofTwoElementsinanArray {

    public int maxProduct(int[] nums) {
        // this is to get the 2 max numbers in the array
        int max1 = Integer.MIN_VALUE, max2 = max1;
        for(int num : nums)
        {
            if(num > max1)
            {
                max2 = max1;
                max1 = num;
            }
            else if(num > max2)
                max2 = num;
        }
        return (max1-1)* (max2-1);
    }

    public int maxProduct0(int[] nums) {
        // this is to get the 2 max numbers in the array
        // 2 nums, max1 and max2
        int max1 = -1, max2 = -1;
        for(int i = 0; i < nums.length; i++)
        {
            if(max1 == -1 || nums[i] > nums[max1])
            {
                max2 = max1;
                max1 = i;
            }
            else if(max2 == -1 || nums[i] > nums[max2])
            {
                max2 = i;
            }
        }
        return (nums[max1]-1)* (nums[max2]-1);
    }
}
