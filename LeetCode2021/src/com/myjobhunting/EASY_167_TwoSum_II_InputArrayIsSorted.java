package com.myjobhunting;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

import java.util.HashMap;
import java.util.Map;

public class EASY_167_TwoSum_II_InputArrayIsSorted {

    // two pointers
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int low = 0;
        int high = numbers.length-1;

        while(low<high)
        {
            int sum = numbers[low]+numbers[high];
            if(sum>target)
            {
                high--;
            }
            else if(target>sum)
            {
                low++;
            }
            else
            {
                ans[0] = low+1;
                ans[1] = high+1;
                break;
            }
        }
        return ans;
    }
    // 1ms 41.8 MB
    public int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length -1, diff = 0;
        while(left < right) // limitation sorted
        {
            diff = target - numbers[left];
            if(diff > numbers[right])
                left++;
            else if(diff < numbers[right])
                right--;
            else
                return new int[]{left+1, right+1};
        }
        return ans;
    }

    // hashmap 1ms 42.8 MB
    public int[] twoSum3(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();  // limitation unique values.
        for( int i = 0; i < numbers.length ; i++)
        {
            int diff = target-numbers[i];

            if(map.containsKey(diff))
            {
                return new int[]{Math.min(i+1, map.get(diff)+1), Math.max(i+1, map.get(diff)+1)};
            }
            map.put(numbers[i],i);
        }
        return null;
    }

    // 200 ms
    public int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        int leftover = 0;
        for(int i = 0; i< numbers.length ;i++)
        {
            int j =  numbers.length-1;
            leftover = target - numbers[i];
            while(numbers[j] > leftover )
            {
                j--;
            }
            if(numbers[j] == leftover)
            {
                ans = new int[]{i + 1, j + 1};
                return ans;
            }
        }
        return ans;
    }


}
