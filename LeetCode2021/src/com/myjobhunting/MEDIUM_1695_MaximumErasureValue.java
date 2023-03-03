package com.myjobhunting;
// https://leetcode.com/problems/maximum-erasure-value/

import java.util.HashSet;
import java.util.Set;

/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
 */
public class MEDIUM_1695_MaximumErasureValue {

    /*
    Runtime: 69 ms, faster than 73.68% of Java online submissions for Maximum Erasure Value.
    Memory Usage: 58.1 MB, less than 81.80% of Java online submissions for Maximum Erasure Value.
     */
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE, sum =0;
        Set<Integer> set = new HashSet<>();
        while(right < nums.length)
        {
            if(!set.contains(nums[right]))
            {
                set.add(nums[right]);
                sum += nums[right++];
            }
            else
            {
                while(!set.isEmpty()&& set.contains(nums[right]))
                {
                    set.remove(nums[left]);
                    sum -= nums[left++];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
