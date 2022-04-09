package com.myjobhunting;
// https://leetcode.com/problems/subarray-product-less-than-k/

/*
Given an array of integers nums and an integer k,
return the number of contiguous subarrays
where the product of all the elements in the subarray is strictly less than k.

Example 1:
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Example 2:
Input: nums = [1,2,3], k = 0
Output: 0

Constraints:

1 <= nums.length <= 3 * 10^4
1 <= nums[i] <= 1000
0 <= k <= 10^6
 */
public class MEDIUM_713_SubarrayProductLessThanK {

    /* sliding window
    Runtime: 6 ms, faster than 85.58% of Java online submissions for Subarray Product Less Than K.
    Memory Usage: 72.9 MB, less than 12.58% of Java online submissions for Subarray Product Less Than K.
     */
    public int numSubarrayProductLessThanK_LC(int[] nums, int k) {
        if(k <= 1) return 0;
        int prod = 1;
        int count = 0;
        int left = 0, right = 0;
        while(right < nums.length)
        {
            prod *= nums[right];
            while(prod >= k)
            {
                prod /= nums[left++];
            }
            count += right - left +1;
            right++;
        }
        return count;
    }

    /*
    Runtime: 1061 ms, faster than 9.08% of Java online submissions for Subarray Product Less Than K.
    Memory Usage: 67.2 MB, less than 74.73% of Java online submissions for Subarray Product Less Than K.
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int prod = 1;
            for(int j = i; j < nums.length; j++)
            {
                prod *= nums[j];
                if(prod < k)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}
