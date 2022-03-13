package com.myjobhunting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
You are given an integer array nums and an integer k.
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
1 <= nums.length <= 105
1 <= nums[i], k <= 109
 */
public class MEDIUM_2195_AppendKIntegersWithMinimalSum {
/*
I think the idea is to find how many unique numbers are missing in the given array.
and from my understanding, what this solution does is
to find out how many unique numbers are missing, and then form a unique array without duplicate,
use n(n+1)/2 to calculate the sum of the unique array,
and then deduct the sum of the given array without duplicates. because the deduction will get rid of those duplicates.

for example,
given array = [1,3,4,5,5,5]; k = 2
[2,6] are the smallest k missing positive numbers
the unique array with the smallest positive missing 2 numbers are [1,2,3,4,5,6],
the target array with duplicates will be [1,2,3,4,5,5,5,6]
you can see the 2, and 6 are the missing numbers, when deduction happens, the duplicates [5,5] after the first appearance of 5 exist in both array;
given array [1,3,4,5,5,5], and the target array (with duplicates) [1,2,3,4,5,5,5,6]
so what the question asked is the same as [1,2,3,4,5,6] - [1,3,4,5]

another example
given array [5,5,6], k = 3
target array [1,2,3,5,5,6];
[1,2,3] are the smallest k missing positive numbers
what the question asked is actually [1,2,3,5,6] - [5,6],
and the answer is the sum of [1,2,3]

so we only need to keep track of the unique number of both arrays.
and k is going to be incremented if missing number is after nums[i] after sorted.
so we need to keep checking if num <= k.
 */

    /* this solution is genius.... even though it is slower than the intuitive way.
    Runtime: 84 ms, faster than 50.00% of Java online submissions for Append K Integers With Minimal Sum.
    Memory Usage: 100.5 MB, less than 50.00% of Java online submissions for Append K Integers With Minimal Sum.
    explanation:
    we use k to denote the last number we append to the array, that means, after append, from 1 to k (include) are in the array
    there may contain duplicate numbers in the array, use set to remove duplicate numbers
     */
    public long minimalKSum1(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        long sum = 0;

        for (int num: nums) {
            if (!set.contains(num) && num <= k) {
                k++;
                sum += num;
            }
            set.add(num);
        }

        long res = (long)(1 + k) * k / 2 - sum;
        return res;
    }

    /*
    Sort the input;
    Starting from 1 as the lower bound of the missing range, then based on current num and k,
    determine current missing upper bound hi;
    Compute the subtotal in [lo, hi] and add it to ans.

    This is similar to finding the k missing minimum positives in the given array.
    Instead of adding all the required numbers one by one we can add all the numbers in a range using AP.
    To simplify the process first we will be sorting the numbers in increasing order.
    Iterate over all the elements in array and check how many numbers are missing between 2 elements and add all of them (or remaining k numbers) to the sum.
    Example: nums = [1, 4, 10, 25, 25], k = 5
    There are 2 numbers missing between 1 and 4, so we will be adding 5 (2 + 3) to the sum. next there are 5 numbers missing from the array so we will be adding only 3 numbers (5, 6, and 7) as only 3 numbers are required after adding (2 and 3) previously.
    Once we have found k missing minimum positives, we can break from the loop and return the sum.

    Runtime: 40 ms, faster than 50.00% of Java online submissions for Append K Integers With Minimal Sum.
    Memory Usage: 76.9 MB, less than 50.00% of Java online submissions for Append K Integers With Minimal Sum.
     */
    public long minimalKSum0(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0, lo = 1;
        for (int num : nums) {
            if (num > lo) {
                long hi = Math.min(num - 1, lo + k - 1);
                int cnt = (int)(hi - lo + 1);
                ans += (lo + hi) * cnt / 2;
                k -= cnt;
                if (k == 0) {
                    return ans;
                }
            }
            lo = num + 1;
        }
        if (k > 0) {
            ans += (lo + lo + k - 1) * k / 2;
        }
        return ans;
    }
}
