package com.myjobhunting;

// https://leetcode.com/problems/next-greater-element-i/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
The next greater element of some element x in an array is
the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length,
find the index j such that nums1[i] == nums2[j]
and determine the next greater element of nums2[j] in nums2.
If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.
length such that ans[i] is the next greater element as described above.

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

Constraints:
1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 10^4
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.

Follow up: Could you find an O(nums1.length + nums2.length) solution?
 */
public class EASY_496_NextGreaterElement_I {

    /*
     Runtime: 3 ms, faster than 86.34% of Java online submissions for Next Greater Element I.
     Memory Usage: 44 MB, less than 45.68% of Java online submissions for Next Greater Element I.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            res[i] = search(nums2, index, nums1[i]);
        }
        return res;
    }
    private int search(int[] nums, int index, int target) {
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > target) {
                return nums[i];
            }
        }
        return -1;
    }

    /*
    Naive solution, initial solution
    Runtime: 2 ms, faster than 98.13% of Java online submissions for Next Greater Element I.
    Memory Usage: 41.9 MB, less than 72.46% of Java online submissions for Next Greater Element I.
     */
    public int[] nextGreaterElement0(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] ans = new int[len];
        for(int i = 0; i < len; i++)
        {
            int j;
            for(j = 0; j < nums2.length; j++)
            {
                if(nums2[j] == nums1[i])
                    break;
            }
            int index = j+1;
            while(index < nums2.length)
            {
                if(nums2[index] > nums1[i])
                    break;
                index++;
            }
            if(index == nums2.length)
                ans[i] = -1;
            else
                ans[i] = nums2[index];
        }
        return ans;
    }

    // the idea is to put the smaller, next larger element into the map
    /*
    Runtime: 7 ms, faster than 31.50% of Java online submissions for Next Greater Element I.
    Memory Usage: 44.7 MB, less than 12.55% of Java online submissions for Next Greater Element I.
     */
    public int[] nextGreaterElement7(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> next_greater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];
        for(int num : nums2)
        {
            /*
            while instead of if is because
            nums1 = [1,3,5,2,4]
            nums2 = [6,5,4,3,2,1,7]
             */
            while(!stack.isEmpty() && stack.peek()< num)
            {
                next_greater.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for(int i = 0; i < nums1.length; i++)
        {
            ans[i] = next_greater.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}
