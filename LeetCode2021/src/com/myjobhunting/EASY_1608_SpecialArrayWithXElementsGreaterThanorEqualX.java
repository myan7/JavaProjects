package com.myjobhunting;

// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

import java.util.Arrays;

/*
You are given an array nums of non-negative integers.
nums is considered special
if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special,otherwise, return -1.
It can be proven that if nums is special, the value for x is unique.



Example 1:
Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.

Example 2:
Input: nums = [0,0]
Output: -1
Explanation: No numbers fit the criteria for x.
If x = 0, there should be 0 numbers >= x, but there are 2.
If x = 1, there should be 1 number >= x, but there are 0.
If x = 2, there should be 2 numbers >= x, but there are 0.
x cannot be greater since there are only 2 numbers in nums.

Example 3:
Input: nums = [0,4,3,0,4]
Output: 3
Explanation: There are 3 values that are greater than or equal to 3.

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */
public class EASY_1608_SpecialArrayWithXElementsGreaterThanorEqualX {

    /*
    Notice there is a sentence saying
    "It can be proven that if nums is special, the value for x is unique."
    how to prove it?
    say we have P and Q, both of which meet the condition.
    there are P numbers in the array whose value >= P,
    and there are Q numbers in the array whose value >= Q
    say if P < Q, then the numbers of elements greater than P should be more than that for Q, and this is a conflict.
     */

    /* O(N) solution, like bucket sort
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
    Memory Usage: 39.7 MB, less than 96.44% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
     */
    public int specialArray(int[] nums) {
        int len = nums.length;
        int[] freq = new int[len+1];
        // get the frequency table for each element;
        for(int val : nums)
            freq[Math.min(val,len)]++;
        // from right to left, keep adding the freq to count.
        int count = 0;
        for(int i = len; i>=0; i--)
        {
            count += freq[i];
            if(count == i)
                return i;
        }
        return -1;
    }


    /* Binary Search
    Runtime: 1 ms, faster than 92.15% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
    Memory Usage: 41.8 MB, less than 54.03% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
     */
    // the min value for special value is 1, and the max value for the special value is nums.length;
    public int specialArray1(int[] nums) {

        int left = 1, right = nums.length;
        while(left <= right)
        {
            int count = 0;
            int mid = left + (right - left)/2;
            for(int val : nums)
            {
                if(val >= mid)
                    count++;
            }
            if(count == mid)
                return mid;
            else if(count > mid)
                left = mid + 1;
            else
                right = mid -1;
        }
        return -1;
    }

    /* binary search 2
    Runtime: 1 ms, faster than 92.15% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
    Memory Usage: 39.8 MB, less than 94.24% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
     */
    public int specialArray2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // binary search to find the first position that
        // nums[i] >= len - i and nums[i - 1] < len - i
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= len - mid) {
                // treat index 0 to avoid IndexOutOfBoundError
                if (mid == 0 || nums[mid - 1] < len - mid) { // correct index
                    return len - mid;
                } else { // not the first position, shrink right bound
                    right = mid - 1;
                }
            } else { // otherwisem, shrink the left bound to increase nums[mid]
                left = mid + 1;
            }
        }
        return -1;
    }

    /* brute force
    Runtime: 2 ms, faster than 63.46% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
    Memory Usage: 42.4 MB, less than 22.93% of Java online submissions for Special Array With X Elements Greater Than or Equal X.
     */
    public int specialArray0(int[] nums) {
        int special = nums.length;

        while(special >= 0)
        {
            int count = 0;
            for(int val : nums)
            {
                if(val >= special)
                    count++;
            }
            if(count == special)
                return special;
            else
                special--;
        }
        return special;
    }


}
