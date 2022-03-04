package com.myjobhunting;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/
/*
Given an array of n integers nums,
a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Example 1:
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.

Example 2:
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

Constraints:
n == nums.length
1 <= n <= 2 * 10^5
-10^9 <= nums[i] <= 10^9
 */
public class MEDIUM_456_132Pattern {

    public boolean find132pattern(int[] nums)
    { // [3,5,0,3,4] true;  [42,43,6,12,3,4,6,11,20]
        int len = nums.length;
        int left = 0, right = len-1;
        while(left < right)
        {
            if(nums[left] > nums[right])
            {
                left++;
            }
            else
            {
                for(int i = left+1; i < right-1; i++)
                {
                    if(nums[i] > nums[left] && nums[i] > nums[right])
                        return true;
                }
                right--;
            }
        }
        return false;
    }

    /*
    Runtime: 15 ms, faster than 73.17% of Java online submissions for 132 Pattern.
    Memory Usage: 61.2 MB, less than 89.05% of Java online submissions for 132 Pattern.
     */
    public boolean find132pattern3(int[] nums) {
        int len = nums.length;
        if(len < 3) return false;

        int[] min = new int[len];
        min[0] = nums[0];
        // keep the min array to track at index i, what is the min on the left.
        for(int i = 1; i < len ; i++)
        {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        // from the right to the left, check if current element is larger than the min on the left
        for(int i = len -1 ; i >= 0; i--)
        {
            if(nums[i] > min[i] )
            {
                while(!stack.isEmpty() && nums[stack.peek()] <= min[i] )
                    stack.pop();
                if(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                    return true;
                stack.push(i);
            }
        }
        return false;
    }

    /*
    LeetCode Solution
    Runtime: 21 ms, faster than 56.75% of Java online submissions for 132 Pattern.
    Memory Usage: 66.4 MB, less than 47.08% of Java online submissions for 132 Pattern.
     */
    public boolean find132pattern2(int[] nums) {
        int len = nums.length;
        if(len < 3) return false;

        int[] min = new int[len];
        min[0] = nums[0];
        for(int i = 1; i < len ; i++)
            min[i] = Math.min(min[i-1], nums[i]);

        Stack<Integer> stack = new Stack<>();

        for(int i = len -1 ; i >= 0; i--)
        {
            if(nums[i] > min[i])
            {
                while(!stack.isEmpty() && stack.peek() <= min[i])
                    stack.pop();
                if(!stack.isEmpty() && stack.peek() < nums[i])
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }


    /*
    O(N^2)
    Time Limit Exceeded 101 / 102 test cases passed.
     */
    public boolean find132pattern1(int[] nums)
    {
        int len = nums.length;
        int leftMin = nums[0];
        for(int j= 1; j < len-1; j++)
        {
            for(int k = j+1; k < len; k++ )
            {
                if(leftMin < nums[k] && nums[k] < nums[j])
                    return true;
            }
            leftMin = Math.min(nums[j], leftMin);
        }
        return false;
    }

    // Naive solution:
    /* O(N^3)
    just use 3 for loops, but given the numbers will be 10^9 and n will be 2*10^5
    this will not be acceptable
    Time Limit Exceeded 94 / 102 test cases passed.
     */
    public boolean find132pattern0(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len-2; i++)
        {
            for(int j = i+1; j < len-1 ; j++)
            {
                for(int k = j + 1; k < len ; k++)
                {
                    if(nums[i] < nums[k] && nums[k] < nums[j])
                        return true;
                }
            }
        }
        return false;
    }
}
