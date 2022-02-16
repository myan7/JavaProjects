package com.myjobhunting;
// https://leetcode.com/problems/shuffle-the-array/

public class EASY_1470_ShuffletheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] output = new int[nums.length];
        int j = 0;
        for(int i = 0; i < n; i++){
            {
                output[j++] = nums[i];
                output[j++] = nums[i+n];
            }
        }
        return output;
    }

    public int[] shuffle0(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length ; i++)
        {
            ans[i] = nums[index++];
            i++;
        }
        for(int i = 1; i < nums.length;i++)
        {
            ans[i] = nums[index++];
            i++;
        }
        return ans;
    }
}
