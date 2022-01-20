package com.myjobhunting;
//https://leetcode.com/problems/merge-sorted-array/

import java.util.Arrays;

public class EASY_088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for( int i = m, j = 0; i < m+n && j < n ; i++, j++)
            nums1[i] = nums2[j];
        Arrays.sort(nums1);
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n)
    {
        int index = m+n-1; // this is for merged nums1.
        int i = m-1; // this is for nums1
        int j = n-1; // this is for nums2
        while(i>=0 && j>=0)
        {
            if(nums1[i]>nums2[j])
            {
                nums1[index--] = nums1[i--];
            }else
            {
                nums1[index--]=nums2[j--];
            }
        }
        while(j>=0)
        {
            nums1[index--] = nums2[j--];
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n)
    {
        while(n > 0)
            nums1[m+n-1] = (m == 0 || nums1[m-1] < nums2[n-1]) ? nums2[--n] : nums1[--m];
    }
}
