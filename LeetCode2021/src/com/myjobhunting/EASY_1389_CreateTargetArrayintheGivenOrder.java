package com.myjobhunting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/create-target-array-in-the-given-order/
/*
Given two arrays of integers nums and index.
Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

Example 1:
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]

Example 2:
Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
Explanation:
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]

Example 3:
Input: nums = [1], index = [0]
Output: [1]

Constraints:
1 <= nums.length, index.length <= 100
nums.length == index.length
0 <= nums[i] <= 100
0 <= index[i] <= i
 */
public class EASY_1389_CreateTargetArrayintheGivenOrder {
    // 1ms
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> tmp = new ArrayList<>();
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            tmp.add(index[i],nums[i]);
        }
        for(int i = 0; i < nums.length; i++)
        {
            ans[i] = tmp.get(i);
        }
        return ans;
    }

    // 0ms
    public int[] createTargetArray1(int[] nums, int[] index) {
        int[] target = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            helper(target, nums[i], index[i]);
        }
        return target;
    }
    // helper function shifts all the items after the insertion position to the end of the array.
    // after shifting, assign the val to the insert position.
    private void helper(int[] target, int value, int index) {
        if (target.length - 1 - index >= 0)
            System.arraycopy(target, index, target, index + 1, target.length - 1 - index);
        /* manual array copy
        for (int i = target.length - 1; i > index; i--) {
            target[i] = target[i - 1];
        }
        */
        target[index] = value;
    }
}
