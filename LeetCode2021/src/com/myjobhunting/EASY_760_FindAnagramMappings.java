package com.myjobhunting;
// https://leetcode.com/problems/find-anagram-mappings/
/*
You are given two integer arrays nums1 and nums2
where nums2 is an anagram of nums1. Both arrays may contain duplicates.

Return an index mapping array mapping from nums1 to nums2
where mapping[i] = j means the ith element in nums1 appears in nums2 at index j.
If there are multiple answers, return any of them.

An array a is an anagram of an array b means
b is made by randomizing the order of the elements in a.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EASY_760_FindAnagramMappings {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        // Both arrays may contain duplicates.
        for(int i = 0; i < nums2.length; i++)
        {
            map.put(nums2[i],i);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < ans.length ; i++)
        {
            if(map.containsKey(nums1[i]))
            {
                ans[i] = map.get(nums1[i]);
            }
        }
        return ans;
    }

    public int[] anagramMappings0(int[] nums1, int[] nums2) {
        // Both arrays may contain duplicates.
        Map<Integer, List<Integer>> map = new HashMap<>();
        // turns out that map will not accept the same k-v pair.

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]))
                map.get(nums2[i]).add(i);
            else
            {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(nums2[i],tmp);
            }
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < ans.length ; i++)
        {
            if(map.containsKey(nums1[i]) && map.get(nums1[i]).size()!=0)
            {
                ans[i] = map.get(nums1[i]).remove(0);
            }
        }
        return ans;
    }
}
