package com.myjobhunting;
//https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EASY_349_IntersectionofTwoArrays {

    /*
    Runtime: 5 ms, faster than 46.84% of Java online submissions for Intersection of Two Arrays.
    Memory Usage: 44.2 MB, less than 19.78% of Java online submissions for Intersection of Two Arrays.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        //Add all elements to set from array 1
        for (int k : nums1) set.add(k);
        for (int k : nums2) {
            // If present in array 2 then add to res and remove from set
            if (set.contains(k)) {
                res.add(k);
                set.remove(k); // to avoid duplicates
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
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
    /*
    Runtime: 3 ms, faster than 81.46% of Java online submissions for Intersection of Two Arrays.
    Memory Usage: 43.5 MB, less than 47.13% of Java online submissions for Intersection of Two Arrays.
     */
    public int[] intersection0(int[] nums1, int[] nums2) {
        List<Integer> tmp = new ArrayList<>();
        int[] map1 = new int[1001];
        int[] map2 = new int[1001];
        for(int i : nums1)
            map1[i]++;
        for(int i : nums2)
            map2[i]++;
        for(int i = 0; i < 1001 ; i++)
        {
            if(map1[i] > 0 && map2[i]> 0)
                tmp.add(i);
        }
        int[] ans = new int[tmp.size()];
        for(int i = 0 ; i < tmp.size(); i++)
        {
            ans[i] = tmp.get(i);
        }
        return ans;
    }
}
