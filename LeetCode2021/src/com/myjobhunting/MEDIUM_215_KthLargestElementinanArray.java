package com.myjobhunting;
// https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 104
-10^4 <= nums[i] <= 10^4
 */
public class MEDIUM_215_KthLargestElementinanArray {

    /*public int findKthLargest_quickSelect(int[] nums, int k) {

    }*/

    /*
    Runtime: 6 ms, faster than 57.93% of Java online submissions for Kth Largest Element in an Array.
    Memory Usage: 45.7 MB, less than 7.46% of Java online submissions for Kth Largest Element in an Array.
    Time complexity : O(Nlogk).
    Space complexity : O(k) to store the heap elements.
     */
    public int findKthLargest_heap(int[] nums, int k) {
        // init heap, the smallest element first
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a-b);

        // keep k largest elements in the heap
        for(int num : nums)
        {
            heap.add(num);
            if(heap.size()> k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
