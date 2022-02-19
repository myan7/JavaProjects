package com.myjobhunting;
// https://leetcode.com/problems/maximum-product-difference-between-two-pairs/

/*
The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
Given an integer array, nums, choose four distinct indices w, x, y, and z
such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.

Return the maximum such product difference.

Example 1:
Input: nums = [5,6,2,7,4]
Output: 34
Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
The product difference is (6 * 7) - (2 * 4) = 34.

Example 2:
Input: nums = [4,2,5,9,7,4,8]
Output: 64
Explanation: We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
The product difference is (9 * 8) - (2 * 4) = 64.

Constraints:
4 <= nums.length <= 104
1 <= nums[i] <= 104
 */

import java.util.Arrays;

public class EASY_1913_MaximumProductDifferenceBetweenTwoPairs {



    // 4ms
    public int maxProductDifference(int[] nums) {
        int[] min = new int[2], max = new int[2];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for(int i : nums)
        {
            if( i < min[0] )
            {
                min[1] = min[0];
                min[0] = i;
            }
            else if(i < min[1])
                min[1] = i;

            if(i > max[1])
            {
                max[0] = max[1];
                max[1] = i;
            }
            else if( i > max[0])
                max[0] = i;
        }
        return max[0]*max[1] - min[0]*min[1];
    }

    // 1ms
    public int maxProductDifference1(int[] nums) {
        int largeOne = Integer.MIN_VALUE,
            largeTwo = Integer.MIN_VALUE,
            smallOne = Integer.MAX_VALUE,
            smallTwo = Integer.MAX_VALUE;

        for (int n : nums) {
            if (largeOne < n) {
                largeTwo = largeOne;
                largeOne = n;
            } else if (largeTwo < n) {
                largeTwo = n;
            }

            if (smallOne > n) {
                smallTwo = smallOne;
                smallOne = n;
            } else if (smallTwo > n) {
                smallTwo = n;
            }
        }
        return largeOne * largeTwo - smallOne * smallTwo;
    }

    // 4ms
    public int maxProductDifference0(int[] nums) {
        int[] min = new int[2], max = new int[2];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int num : nums) {
            if (min[0] > num || min[1] > num) {
                if (num < min[0]) {
                    int temp = min[0];
                    min[0] = num;
                    min[1] = temp;
                } else if (num < min[1] && num >= min[0]) {
                    min[1] = num;
                }
            }

            if (max[0] < num || max[1] < num) {
                if (num > max[1]) {
                    int temp = max[1];
                    max[1] = num;
                    max[0] = temp;
                } else if (num > max[0] && num <= max[1]) {
                    max[0] = num;
                }

            }
        }
        return max[0]*max[1] - min[0]*min[1];
    }
}
