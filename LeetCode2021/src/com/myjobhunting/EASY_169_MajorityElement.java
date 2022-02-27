package com.myjobhunting;

// https://leetcode.com/problems/majority-element/
/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EASY_169_MajorityElement {

    // 1 ms  Approach 6: Boyer-Moore Voting Algorithm
    public int majorityElement0(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    //2ms Approach 6: Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 1,majority = nums[0];
        for( int i = 1; i <nums.length; i++ )
        {
            if(count == 0 || majority == nums[i]){
                majority = nums[i];
                count++;
            }
            else
                count--;
        }
        return majority;
    }

    //3ms trick answer
    public int majorityElement1(int[] nums) {
        int ans =0;
        Arrays.sort(nums);
        ans = nums[nums.length/2];
        return ans;
    }

    // 10ms updated map solution
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int x : nums) {
            int count = counter.getOrDefault(x, 0) + 1;
            if (count > nums.length / 2) {
                return x;
            } else {
                counter.put(x, count);
            }
        }
        return -1; // invalid input
    }
    // 14 ms /naive solution
    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
        {
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        int maj = 0;
        int ans = 0;
        for(int k: map.keySet())
        {
            if(map.get(k) > maj)
            {
                maj = map.get(k);
                ans = k;
            }

        }
        return ans;
    }

    // divide and conquer
    public int majorityElement4(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
