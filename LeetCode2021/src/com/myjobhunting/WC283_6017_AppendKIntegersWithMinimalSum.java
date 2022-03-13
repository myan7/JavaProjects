package com.myjobhunting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
You are given an integer array, nums, and an integer, k.
Append k unique positive integers that do not appear in nums to nums such that the resulting total sum is minimum.

Return the sum of the k integers appended to nums.

Example 1:
Input: nums = [1,4,25,10,25], k = 2
Output: 5
Explanation: The two unique positive integers that do not appear in nums which we append are 2 and 3.
The resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the minimum.
The sum of the two integers appended is 2 + 3 = 5, so we return 5.
Example 2:

Input: nums = [5,6], k = 6
Output: 25
Explanation: The six unique positive integers that do not appear in nums which we append are 1, 2, 3, 4, 7, and 8.
The resulting sum of nums is 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36, which is the minimum.
The sum of the six integers appended is 1 + 2 + 3 + 4 + 7 + 8 = 25, so we return 25.

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^9
 */
public class WC283_6017_AppendKIntegersWithMinimalSum {


    /*
    Runtime: 41 ms, faster than 49.39% of Java online submissions for Append K Integers With Minimal Sum.
    Memory Usage: 56.7 MB, less than 93.16% of Java online submissions for Append K Integers With Minimal Sum.
     */
    public long minimalKSum20220312(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for(int num: nums)
        {
            if(!set.contains(num) && num <= k)
            {
                k++;
                sum += num;
            }
            set.add(num);
        }
        return (long)k*(k+1)/2 - sum;
    }
    /*

     */
    public long minimalKSum(int[] nums, int k) {
        long res = 0;
        int n = nums.length, min = 1;
        Arrays.sort(nums);
        for (int i = 0; i < n; ++i) {
            if (min < nums[i]) {
                int l = Math.min(nums[i] - min, k);
                res += l * (long) (min + min + l - 1) / 2;
                k -= l;
            }
            min = nums[i] + 1;
        }
        if (0 != k) res += k * (long) (min + min + k - 1) / 2;
        return res;
    }

    public long minimalKSum1(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int index = 0;
        long val = 1;
        while(k > 0)
        {
            if(index < nums.length && val == nums[index])
            {
                val++;
                index++;
                continue;
            }
            sum += val++;
            k--;
        }
        return sum;
    }
    /*
    	Memory Limit Exceeded
     */
    public long minimalKSum0(int[] nums, int k) {
        Arrays.sort(nums);
        long[] missing  = new long[k+1];
        int index = 0, startVal = 1;
        for(int i = 0 ; i < nums.length ; i++)
        {
            while(index < k && startVal < nums[i])
                missing[++index] = startVal++;
            if(startVal == nums[i])
                startVal++;
        }
        while(index < k)
            missing[++index] = startVal++;

        long sum = 0;
        for(long i :missing)
            sum += i;
        return sum;
    }

    public static void main(String[] args)
    {
        int[] test1 = {5,6};
        int k  =6;
        int[] test2 = {53,41,90,33,84,26,50,32,63,47,66,43,29,88,71,28,83};
        k = 76;
        int[] test3 = {96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84};
        k = 35;

        WC283_6017_AppendKIntegersWithMinimalSum so = new WC283_6017_AppendKIntegersWithMinimalSum();
        long ans = so.minimalKSum1(test3, k);
        System.out.println(ans);
    }
}
