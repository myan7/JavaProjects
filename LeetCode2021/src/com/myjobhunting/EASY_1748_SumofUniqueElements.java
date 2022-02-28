package com.myjobhunting;
// https://leetcode.com/problems/sum-of-unique-elements/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array nums.
The unique elements of an array are the elements that appear exactly once in the array.
Return the sum of all the unique elements of nums.

Example 1:
Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.

Example 2:
Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.

Example 3:
Input: nums = [1,2,3,4,5]
Output: 15
Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
 */

public class EASY_1748_SumofUniqueElements {

    // after reading the constraints, second solution
    // Runtime: 0 ms, faster than 100.00% of Java online submissions
    public int sumOfUnique00(int[] nums) {
        // 1 <= nums[i] <= 100
        // 1 <= nums.length <= 100
        int[] map = new int[101];
        for(int i : nums)
            map[i]++;
        int sum = 0;
        for(int i = 0 ; i < 101; i++)
        {
            if(map[i] == 1)
                sum += i;
        }
        return sum;
    }

    // initial solution Runtime: 1 ms, faster than 81.28% of Java online submissions
    public int sumOfUnique0(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0, sum = 0, len = nums.length, flag = 0;
        while(right < len)
        {
            if(right != left && nums[right] == nums[left])
            {
                if(flag == 0 )
                {
                    sum -= nums[left];
                    flag = 1;
                }
                right++;
            }
            else
            {
                sum += nums[right];
                flag = 0;
                left = right;
                right++;
            }
        }
        return sum;
    }

    // Runtime: 2 ms, faster than 54.44% of Java online submissions
    public int sumOfUnique1(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 1) res += num;
            else if (map.get(num) == 2) res -= num;
        }
        return res;
    }


}
