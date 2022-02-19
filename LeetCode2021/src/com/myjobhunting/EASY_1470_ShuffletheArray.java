package com.myjobhunting;
// https://leetcode.com/problems/shuffle-the-array/

public class EASY_1470_ShuffletheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int index = 0;
        for(int i = 0; i < n; i++)
        {
            ans[index++] = nums[i];
            ans[index++] = nums[i+n];
        }
        return ans;
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

    public int[] shuffle1(int[] nums, int n) {
        int j=n;
        int k=0;
        int[] a=new int[2*n];
        for(int i=0;i<n;i++)
        {
            a[k++]=nums[i];
            a[k++]=nums[j++];
        }
        return a;
    }

}
