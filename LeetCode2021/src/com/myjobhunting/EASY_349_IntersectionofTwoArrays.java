package com.myjobhunting;
//https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EASY_349_IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        //Add all elements to set from array 1
        for (int k : nums1) set.add(k);
        for (int k : nums2) {
            // If present in array 2 then add to res and remove from set
            if (set.contains(k)) {
                res.add(k);
                set.remove(k);
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }

    public int[] intersection0(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        Set<Integer> pool = new HashSet<>();
        for (int j : nums1) {
            freq[j]++;
        }
        for(int i = 0; i < nums2.length; )
        {
            if(freq[nums2[i]] == 0)
            {
                i++;
            }
            else
            {
                while(i < nums2.length && freq[nums2[i]] > 0 )
                {
                    pool.add(nums2[i]);
                    i++;
                }
            }
        }
        int[] ans = new int[pool.size()];
        int index = 0;
        for(Integer i: pool)
        {
            ans[index++] = i;
        }
        return ans;
    }
}
