package com.myjobhunting;
// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

/*
Given an array nums,
return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.
Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

Example 1:
Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

Example 2:
Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.

Example 3:
Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
 */
public class EASY_1752_CheckifArrayIsSortedandRotated {

    public boolean check(int[] nums) {
        int count = 0, len = nums.length;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > nums[(i+1)%len]) // notice this is to connect the end index to the start index.
                count++;
        }
        return count <= 1;
    }

    /* Initial solution:
    Runtime: 1 ms, faster than 27.38% of Java online submissions for Check if Array Is Sorted and Rotated.
    Memory Usage: 41.7 MB, less than 29.38% of Java online submissions for Check if Array Is Sorted and Rotated.
     */
    public boolean check0(int[] nums) {
        int len = nums.length;
        if(len == 1) return true;
        int[] tmp = new int[2*len];
        int max = 0;
        for(int i = 0; i < len ; i++)
        {
            tmp[i] = nums[i];
            tmp[i+len] = nums[i];
            if(nums[i] >= nums[max])
                max = i;
        }
        int count = 0;
        for(int i = 0; i < 2*len-1 ; i++)
        {
            if(tmp[i] <= tmp[i+1])
            {
                count++;
                if(count+1 == len )
                    return true;
            }
            else
                count = 0;
        }
        return false;
    }
}
