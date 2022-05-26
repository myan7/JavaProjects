package com.myjobhunting;

// https://leetcode.com/problems/sort-array-by-parity/
/*
Given an integer array nums,
move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EASY_905_SortArrayByParity {

    // Runtime: 1 ms, faster than 97.13% of Java online submissions
    public int[] sortArrayByParity0_v2(int[] nums)
    {
        int left = 0 , right = nums.length-1;
        while(left < right)
        {
            if(nums[left]%2 != 0)
            {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
            else
                left++;
        }
        return nums;
    }

    // LeetCode solution
    // 2 pointers, in place O(N) O(1)
    //Runtime: 1 ms, faster than 97.13% of Java online submissions
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 > nums[j] % 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            if (nums[i] % 2 == 0) i++;
            if (nums[j] % 2 == 1) j--;
        }
        return nums;
    }

    // initial solution // two pointers
    /*
    Runtime: 1 ms, faster than 96.61% of Java online submissions for Sort Array By Parity.
    Memory Usage: 42.8 MB, less than 97.59% of Java online submissions for Sort Array By Parity.
     */
    public int[] sortArrayByParity0(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right)
        {
            if(nums[left] %2 == 0)
            {
                left++;
                continue;
            }
            if(nums[right] %2 != 0)
            {
                right--;
                continue;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return nums;
    }

    // LeetCode solution
    // 2 passes O(N) O(N)
    // Runtime: 1 ms, faster than 97.13% of Java online submissions
    public int[] sortArrayByParity1(int[] nums) {
        int[] ans = new int[nums.length];
        int t = 0;

        for (int num : nums)
            if (num % 2 == 0)
                ans[t++] = num;

        for (int num : nums)
            if (num % 2 == 1)
                ans[t++] = num;

        return ans;
    }

    // LeetCode solution
    // Runtime: 10 ms, faster than 6.77% of Java online submissions
    public int[] sortArrayByParity2(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        for(int i = 0; i < nums.length ; i++)
            tmp[i] = nums[i];

        Arrays.sort(tmp, (a,b) -> b%2 -a%2);
        /*
         or  Arrays.sort(tmp, (a, b) -> Integer.compare(a%2, b%2));
         */
        for(int i = 0; i < nums.length ; i++)
            nums[i] = tmp[i];
        return nums;

        /* Alternative:
        return Arrays.stream(nums)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }

    /*
    Runtime: 4 ms, faster than 9.85% of Java online submissions for Sort Array By Parity.
    Memory Usage: 49.8 MB, less than 6.02% of Java online submissions for Sort Array By Parity.
     */
    public int[] sortArrayByParity20220501(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int num: nums)
        {
            if(num%2==0)
                even.add(num);
            else
                odd.add(num);
        }
        List<Integer> all = new ArrayList<>();
        all.addAll(even);
        all.addAll(odd);
        int[] ans = new int[all.size()];
        int i = 0;
        for(Integer val : all)
            ans[i++] = val;
        return ans;
    }
}
