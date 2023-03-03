package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/max-consecutive-ones-ii/

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.

Example 1:
Input: nums = [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the maximum number of consecutive 1s.
After flipping, the maximum number of consecutive 1s is 4.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 4

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
 */
public class MEDIUM_487_MaxConsecutiveOnes_II {


    /*
    Runtime: 4 ms, faster than 42.56% of Java online submissions for Max Consecutive Ones II.
    Memory Usage: 57 MB, less than 36.41% of Java online submissions for Max Consecutive Ones II.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, zero = 0, k = 1; // flip at most k zero
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0)
                zero++;
            while (zero > k)
            {
                if (nums[l] == 0)
                    zero--;
                l++;
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }

    /*
    Runtime: 3 ms, faster than 79.23% of Java online submissions for Max Consecutive Ones II.
    Memory Usage: 58 MB, less than 7.16% of Java online submissions for Max Consecutive Ones II.
     */
    public int findMaxConsecutiveOnes0(int[] nums) {
        int len = nums.length;
        List<Integer> zeroes = new ArrayList<>();
        for(int i = 0; i < len;i++)
        {
            if(nums[i] == 0)
                zeroes.add(i);
        }
        if(zeroes.size() <= 1)
            return len;
        int max = zeroes.get(1);
        for(int i = 2;i < zeroes.size(); i++)
        {
            max = Math.max(zeroes.get(i)-zeroes.get(i-2)-1, max);
        }
        return max > len-zeroes.get(zeroes.size()-2)-1?max:len-zeroes.get(zeroes.size()-2)-1;
    }
}
