package com.myjobhunting;

// https://leetcode.com/problems/move-zeroes/


public class EASY_283_MoveZeroes {
    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    Memory Usage: 55.4 MB, less than 7.44% of Java online submissions for Move Zeroes.
    */
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

    // constraint is without making a copy, this is invalid answer
    public void moveZeroes1(int[] nums) {
        int left = 0, right = nums.length-1;
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (num == 0)
                temp[right--] = 0;
            if (num != 0)
                temp[left++] = num;
        }
        /*
        for(int i = 0 ; i < nums.length; i++)
            nums[i] = temp[i];
        */
        System.arraycopy(temp, 0, nums, 0, nums.length);

    }
}
