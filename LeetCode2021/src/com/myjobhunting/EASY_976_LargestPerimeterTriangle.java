package com.myjobhunting;

// https://leetcode.com/problems/largest-perimeter-triangle/

import java.util.Arrays;

/*
Given an integer array, nums,
return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
If it is impossible to form any triangle of a non-zero area, return 0.


Example 1:
Input: nums = [2,1,2]
Output: 5

Example 2:
Input: nums = [1,2,1]
Output: 0

Constraints:
3 <= nums.length <= 10^4
1 <= nums[i] <= 10^6

 */
public class EASY_976_LargestPerimeterTriangle {

    /*
    Runtime: 7 ms, faster than 91.16% of Java online submissions for Largest Perimeter Triangle.
    Memory Usage: 42.3 MB, less than 88.05% of Java online submissions for Largest Perimeter Triangle.
    Time Complexity: O(NlogN), where N is the length of nums.
    Space Complexity: O(1).
     */
    public int largestPerimeter(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        Arrays.sort(nums);
        while(i >= 2)
        {
            if(nums[i-1] + nums[i-2] > nums[i])
                return nums[i-1] + nums[i-2] + nums[i];
            i--;
        }
        return 0;
    }

    /*
    Runtime: 9 ms, faster than 80.57% of Java online submissions for Largest Perimeter Triangle.
    Memory Usage: 55.1 MB, less than 5.61% of Java online submissions for Largest Perimeter Triangle.
     */
    public int largestPerimeter1(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; --i)
            if (nums[i] + nums[i+1] > nums[i+2])
                return nums[i] + nums[i+1] + nums[i+2];
        return 0;
    }
}
