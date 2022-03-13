package com.myjobhunting;
//https://leetcode.com/problems/merge-sorted-array/

import java.util.Arrays;

public class EASY_088_MergeSortedArray {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
    Memory Usage: 43.3 MB, less than 10.68% of Java online submissions for Merge Sorted Array.
    corner case, m == 0
                 [0],0 , [1],1
     */
    public void merge_20220307(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1, idx2 = n-1;
        for(int i = m+n-1; i >= 0; i-- )
        {
            if(idx1 >= 0 && idx2 >= 0)
            {
                if(nums1[idx1] > nums2[idx2])
                {
                    nums1[i] = nums1[idx1--];
                }
                else
                {
                    nums1[i] = nums2[idx2--];
                }
            }
            else if(idx1 < 0)
            {
                nums1[i] = nums2[idx2--];
            }
        }
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

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for( int i = m, j = 0; i < m+n && j < n ; i++, j++)
            nums1[i] = nums2[j];
        Arrays.sort(nums1);
    }
}
