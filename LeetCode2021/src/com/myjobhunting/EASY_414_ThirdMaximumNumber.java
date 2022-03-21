package com.myjobhunting;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/third-maximum-number/
/*

related to 215. Kth Largest Element in an Array https://leetcode.com/problems/kth-largest-element-in-an-array/

Given an integer array nums, return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.

Example 1:
Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:
Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Can you find an O(n) solution?
 */
public class EASY_414_ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> sorted = new PriorityQueue<>();
        for(int num : nums)
        {
            if(!sorted.contains(num))
            {
                sorted.offer(num);
                if(sorted.size() > 3)
                {
                    sorted.poll();
                }
            }
        }
        if(sorted.size() == 2 )
            sorted.poll();

        return sorted.poll();
    }

    public int thirdMax0(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> sorted = new PriorityQueue<>();
        for(int num: nums)
        {
            if(!set.contains(num))
            {
                set.add(num);
                sorted.add(num);
                if(set.size() > 3)
                    set.remove(sorted.poll());
            }
        }
        if (sorted.size() < 3) {
            while (sorted.size() > 1) {
                sorted.poll();
            }
        }
        return sorted.peek();
    }

    public int thirdMax1(int[] nums) {
        // Put the input integers into a HashSet.
        Set<Integer> setNums = new HashSet<>();
        for (int num : nums) setNums.add(num);

        // Find the maximum.
        int maximum = Collections.max(setNums);

        // Check whether or not this is a case where we
        // need to return the *maximum*.
        if (setNums.size() < 3) {
            return maximum;
        }

        // Otherwise, continue on to finding the third maximum.
        setNums.remove(maximum);
        int secondMaximum = Collections.max(setNums);
        setNums.remove(secondMaximum);
        return Collections.max(setNums);
    }
}
