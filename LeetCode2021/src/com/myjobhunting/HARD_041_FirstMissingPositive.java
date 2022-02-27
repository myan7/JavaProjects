package com.myjobhunting;

// https://leetcode.com/problems/first-missing-positive/
/*
Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
//  the auxiliary space size, doesn't depend on the length of input array.

Example 1:
Input: nums = [1,2,0]
Output: 3

Example 2:
Input: nums = [3,4,-1,1]
Output: 2

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1

Constraints:
1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
 */

public class HARD_041_FirstMissingPositive {

    // negative marking with preprocessing see LC-287
    public int firstMissingPositive(int[] nums) {
        // default the ans to the max possible val, assuming all the number 1~n are there.
        int ans = nums.length+1;

        // check if 1 is in the array, if not, return 1;
        int flag = 0;
        for(int i: nums)
        {
            if(i == 1 )
            {
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            return 1;

        // replace all non positive values with 1
        // replace all positive values that greater than nums.length with 1 as well
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = 1;
        }

        // use index as a hash key, and flip the sign to indicate visited
        // for example if nums[2] = 5, then flip the nums[5] to indicate 5 exists
        // this is called negative marking, refer to
        for(int i = 0; i< nums.length; i++)
        {
            int index = Math.abs(nums[i]);
            if(index == nums.length)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[index] = -Math.abs(nums[index]);
        }

        // if there is one value in the updated array is positive, than the index is the answer.
        // remember to start with 1 and check 0 afterward, because there could be more number
        // for example [1,2,3,20,21,22]
        // if you check 0 in the for loop, it will return the length
        for(int i = 1; i< nums.length; i++)
        {
            if(nums[i] > 0)
                return i;
        }

        if(nums[0] > 0)
            return nums.length;

        // if all the values in the updated array are all negative, then return ans;
        return ans;

    }



    // 3 ms, faster 87.47%  but Time: O(n) and Space: O(n), which the question request constant space complexity
    public int firstMissingPositive0(int[] nums) {
        int[] map = new int[nums.length+1];
        int ans = nums.length+1;
        for(int num : nums)
        {
            if(num > 0 && num <= nums.length)
                map[num]++;
        }
        for(int i = 1; i < map.length; i++)
        {
            if(map[i] == 0)
                return i;
        }
        return ans;
    }
}
