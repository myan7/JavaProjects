package com.myjobhunting;

// https://leetcode.com/problems/move-zeroes/

public class EASY_283_MoveZeroes {
    public void moveZeroes(int[] nums)
    {
        int nonZero = 0;
        for(int i = 0; i < nums.length;i++)
        {
            if(nums[i] != 0)
                nums[nonZero++] = nums[i];
        }
        for(int i = nonZero; i < nums.length; i++)
            nums[i] = 0;
    }

    public void moveZeroes1(int[] nums) {
        int left = 0, right = nums.length-1;
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
                temp[right--] = 0;
            if(nums[i] != 0)
                temp[left++] = nums[i];
        }
        for(int i = 0 ; i < nums.length; i++)
            nums[i] = temp[i];
    }
}
