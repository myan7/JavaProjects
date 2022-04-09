package com.myjobhunting;
//https://leetcode.com/problems/intersection-of-two-arrays-ii/

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EASY_350_IntersectionofTwoArrays_II {


    /*
    Runtime: 2 ms, faster than 95.81% of Java online submissions for Intersection of Two Arrays II.
    Memory Usage: 42.2 MB, less than 91.71% of Java online submissions for Intersection of Two Arrays II.
     */
    public int[] intersect20220406(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] == nums2[j])
            {
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j])
                j++;
            else
                i++;
        }
        int[] res = new int[ans.size()];
        for(int idx = 0; idx < ans.size(); idx++)
            res[idx] = ans.get(idx);
        return res;
    }

    /*
    Runtime: 3 ms, faster than 82.11% of Java online submissions for Intersection of Two Arrays II.
    Memory Usage: 44.1 MB, less than 31.58% of Java online submissions for Intersection of Two Arrays II.
     */
    public int[] intersect20220318_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0,index = 0;
        while(i < nums1.length && j < nums2.length && index < Math.min(nums1.length, nums2.length))
        {
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else
            {
                nums1[index++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }

    /*
    Runtime: 4 ms, faster than 65.38% of Java online submissions for Intersection of Two Arrays II.
    Memory Usage: 44.3 MB, less than 20.98% of Java online submissions for Intersection of Two Arrays II.
     */
    public int[] intersect_20220318(int[] nums1, int[] nums2) {
        int[] map1 = new int[1001];
        int[] map2 = new int[1001];
        for(int i : nums1)
            map1[i]++;
        for(int i : nums2)
            map2[i]++;
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i< 1001; i++)
        {
            int times = Math.min(map1[i], map2[i]);
            while(times > 0)
            {
                tmp.add(i);
                times--;
            }
        }
        int index = 0;
        int[] ans = new int[tmp.size()];
        for(Integer i : tmp)
            ans[index++] = i;
        return ans;
    }

    /*
    Runtime: 1 ms, faster than 99.49% of Java online submissions for Intersection of Two Arrays II.
    Memory Usage: 43.7 MB, less than 51.05% of Java online submissions for Intersection of Two Arrays II.
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] numbers = new int[1001];
        ArrayList<Integer> List = new ArrayList<>();
        for (int num : nums1) {
            numbers[num]++;
        }
        for (int num : nums2) {
            if (numbers[num] > 0) {
                List.add(num);
                numbers[num]--;
            }
        }
        int[] ansArr = new int[List.size()];
        for (int i = 0; i < List.size(); i++) {
            ansArr[i] = List.get(i);
        }
        return ansArr;
    }

    public int[] intersect0(int[] nums1, int[] nums2) {
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
