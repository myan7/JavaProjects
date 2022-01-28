package com.myjobhunting;

// https://leetcode.com/problems/rotate-array/


public class MEDIUM_189_RotateArray {

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        /*
        this is for ([-1,2],5)
         */
        int[] temp = new int[nums.length];
        int j =0;
// 		first copy the second half of nums to the first half of temp
//		when i<k nums[i] --> temp[i+k]
        for(int i = 0;i<k;i++)
        {
            temp[i]=nums[nums.length-k+i];
        }
        for(int i = k;i<nums.length;i++)
        {
            temp[i] = nums[j++];
        }
        for (int i =0;i < nums.length;i++) {
            nums[i] = temp[i];
        }
    }

    // time limit exceed
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        // what if k is larger than nums.length
        k = k%len;

        int index = 0;
        // you know the input, and the output, copy the moving parts separately
        // part 1 (k - len)
        for( int i = k; i < len; i++ )
        {
            temp[i] = nums[index++];
        }
        // part 2 0 - (k -1)
        for( int i = 0; i < k; i++ )
        {
            temp[i] = nums[index++];
        }
        // copy everything to nums
        for(int i = 0; i < len; i++)
        {
            nums[i] = temp[i];
        }
    }

}
