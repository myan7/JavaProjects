package com.myjobhunting;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9
 */
public class MEDIUM_1679_MaxNumberofK_SumPairs {

    /*
    Runtime: 21 ms, faster than 87.77% of Java online submissions for Max Number of K-Sum Pairs.
    Memory Usage: 71.7 MB, less than 49.90% of Java online submissions for Max Number of K-Sum Pairs.
     */
    public int maxOperations(int[] nums, int k) {
        int count = 0, left = 0, right = nums.length-1;
        if(k == 1) return 0;
        Arrays.sort(nums);
        while(left < right)
        {
            if(nums[left] + nums[right] == k)
            {
                left++;
                right--;
                count++;
            }
            else if(nums[left] + nums[right] < k )
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return count;
    }

    /*
    Runtime: 38 ms, faster than 49.51% of Java online submissions for Max Number of K-Sum Pairs.
    Memory Usage: 55.5 MB, less than 79.42% of Java online submissions for Max Number of K-Sum Pairs.
     */
    public int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int curr = nums[i];
            int complement = k - curr;
            if(map.getOrDefault(complement, 0) > 0)
            {
                // remove complement from the map
                map.put(complement, map.get(complement)-1);
                count++;
            }
            else
            {
                map.put(curr, map.getOrDefault(curr,0)+1);
            }
        }
        return count;
    }
}
