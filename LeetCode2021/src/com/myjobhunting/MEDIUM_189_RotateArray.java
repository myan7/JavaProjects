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
        int count = 0;
        int[] temp = new int[nums.length];
        // copy the array to temp
        for(int i = 0; i < nums.length; i++)
        {
            temp[i] = nums[i];
        }
        while(count < k )
        {
            for(int i = 0; i < nums.length; i++)
            {
                temp[i] = nums[i];
            }
            int t = nums[nums.length-1];
            for(int i = 1; i < nums.length; i++)
                nums[i] = temp[i-1];
            nums[0] = t;
            count++;
        }
    }

}
