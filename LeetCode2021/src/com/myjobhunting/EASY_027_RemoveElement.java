package com.myjobhunting;

public class EASY_027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public int removeElement3(int[] nums, int val) {
        int index = 0;
        for(int e: nums)
        {
            if(e != val)
                nums[index++] = e;
        }
        return index;
    }
}
