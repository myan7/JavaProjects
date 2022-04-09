package com.myjobhunting;
// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

/*
Given an integer array nums and an integer k,
return the k most frequent elements. You may return the answer in any order.


Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class MEDIUM_347_TopKFrequentElements {

    /*
    Runtime: 11 ms, faster than 85.75% of Java online submissions for Top K Frequent Elements.
    Memory Usage: 44.7 MB, less than 90.64% of Java online submissions for Top K Frequent Elements.
     */
    public int[] topKFrequent0(int[] nums, int k) {
        int[][] score = new int[nums.length][2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            int curr = nums[i];
            if(!map.containsKey(curr))
            {
                map.put(curr, i);
                score[map.get(curr)][0] = i;
            }
            score[map.get(curr)][1]++;
        }
        Arrays.sort(score,(a, b) -> b[1] - a[1]);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++)
        {
            ans[i] = nums[score[i][0]];
        }
        return ans;
    }

    /* Bucket sort O(N)
    Runtime: 12 ms, faster than 81.89% of Java online submissions for Top K Frequent Elements.
    Memory Usage: 50.8 MB, less than 29.21% of Java online submissions for Top K Frequent Elements.
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num,0)+1);

        // worst case is one element appears n times.
        // also, 2 elements can appear the same amount of times.
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int key: map.keySet())
        {
            int freq = map.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int index = 0;
        for(int i = bucket.length-1; i >= 0 && index < k; i--)
        {
            int freq = i;
            if(bucket[freq] != null)
            {
                for(Integer val : bucket[freq])
                    ans[index++] = val;
            }
        }
        return ans;
    }

    /*
    Runtime: 11 ms, faster than 85.75% of Java online submissions for Top K Frequent Elements.
    Memory Usage: 44.6 MB, less than 93.18% of Java online submissions for Top K Frequent Elements.
     */
    public int[] topKFrequent_LC1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // keep the heap to be a min heap
        PriorityQueue<Integer> score = new PriorityQueue<>(
                Comparator.comparingInt(map::get));
        /* same as
        PriorityQueue<Integer> score = new PriorityQueue<>(
            (a,b) -> map.get(a) - map.get(b));
         */

        for(int val : map.keySet())
        {
            score.offer(val);
            if(score.size() > k)
                score.poll(); // remove the head, which is the smallest.
        }
        int[] ans = new int[k];
        for(int i = k-1; i>= 0 ; i--)
            ans[i] = score.poll();

        return ans;
    }


}
