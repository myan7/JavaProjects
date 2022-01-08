package com.myjobhunting;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

public class EASY_167_TwoSum_II_InputArrayIsSorted {

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

    public int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];
        int leftover = 0;
        int i = 0;
        int j = numbers.length-1;
        while(i < j)
        {
            leftover = target - numbers[i];
            // unique value
            if(numbers[j] > leftover)
            {
                j--;
            }
            else if(numbers[j] < leftover)
            {
                i++;
            }
            else
            {
                ans = new int[]{i + 1, j + 1};
                return ans;
            }
        }
        return ans;
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
