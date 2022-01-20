package com.myjobhunting;
//https://leetcode.com/problems/binary-search/

public class EASY_704_BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid-1;
            else
                return mid;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m = l + (r-l) /2;
        while (l <= r) {
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] == target) {
                return m;
            } else {
                r = m - 1;
            }
            m = l +(l- r) / 2;
        }
        return -1;
    }
}
