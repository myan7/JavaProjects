package com.myjobhunting;
//https://leetcode.com/problems/intersection-of-two-arrays-ii/

import java.util.ArrayList;
import java.util.List;

public class EASY_350_IntersectionofTwoArrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums1Freq = new int[1001];
        int[] nums2Freq = new int[1001];
        for(int i: nums1)
            nums1Freq[i]++;
        for(int i : nums2)
            nums2Freq[i]++;
        int len1 = nums1.length, index1 = 0;
        int len2 = nums2.length, index2 = 0;
        List<Integer> common = new ArrayList<>();
        while(index1 < len1 && index2 < len2)
        {
            // if element in nums2 not in nums1, move on
            while( index2 < len2 && nums1Freq[nums2[index2]] == 0 )
                index2++;
            // if element in nums1 not in nums2, move on
            while( index1 < len1 && nums2Freq[nums1[index1]] == 0 )
                index1++;
            if(index1 < len1 && index2 < len2)
            {
                common.add(nums1[index1]);
                nums1Freq[nums2[index2]]--;
                nums2Freq[nums1[index1]]--;
                index1++;
                index2++;
            }


        }
        int[] ans = new int[common.size()];
        int index = 0;
        for(int i : common)
            ans[index++] = i;
        return ans;
    }
}
