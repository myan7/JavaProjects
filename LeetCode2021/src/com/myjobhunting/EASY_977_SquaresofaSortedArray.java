package com.myjobhunting;

//https://leetcode.com/problems/squares-of-a-sorted-array/
// two pointers

import java.util.Arrays;

public class EASY_977_SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int cur = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[j]) >= Math.abs(nums[i])) {
                ans[cur--] = nums[j] * nums[j];
                j--;
            } else {
                ans[cur--] = nums[i] * nums[i];
                i++;
            }
        }
        return ans;
    }

    public int[] sortedSquares3(int[] nums) {
        int left = 0, right = nums.length-1;
        int[] ans = new int[nums.length];
        int index = right; // starting from the most right, save the larger one.
        while( left <= right)
        {
            if(nums[left] * nums[left] > nums[right]*nums[right])
            {
                ans[index] = nums[left]*nums[left];
                left++;
                index--;
            }
            else
            {
                ans[index] = nums[right]*nums[right];
                right--;
                index--;
            }
        }
        return ans;
    }

    public int[] sortedSquares1(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, //i is left pointer of array (starts at 0)
            j = nums.length-1; //j is right pointer of array (starts at end of nums)
        while(i <= j){ //while the two pointers have not crossed
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                res[j-i] = nums[i]*nums[i];
                i++; //move i closer to j since the element at nums[i] was greater
            }
            else {
                res[j-i] = nums[j]*nums[j];
                j--; //move j closer to i
            }
        }
        return res;
    }

    public int[] sortedSquares2(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++)
        {
            arr[i] = Math.abs(nums[i]);
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length; i++)
        {
            arr[i] = arr[i]* arr[i];
        }
        return arr;
    }




}
