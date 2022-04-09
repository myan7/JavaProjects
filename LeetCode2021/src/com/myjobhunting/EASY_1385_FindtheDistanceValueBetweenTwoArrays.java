package com.myjobhunting;
// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/*
Given two integer arrays arr1 and arr2, and the integer d,
return the distance value between the two arrays.
The distance value is defined as the number of elements arr1[i]
such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.

Example 1:

Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
Output: 2
Explanation:
For arr1[0]=4 we have:
|4-10|=6 > d=2
|4-9|=5 > d=2
|4-1|=3 > d=2
|4-8|=4 > d=2
For arr1[1]=5 we have:
|5-10|=5 > d=2
|5-9|=4 > d=2
|5-1|=4 > d=2
|5-8|=3 > d=2
For arr1[2]=8 we have:
|8-10|=2 <= d=2
|8-9|=1 <= d=2
|8-1|=7 > d=2
|8-8|=0 <= d=2
Example 2:

Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
Output: 2
Example 3:

Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
Output: 1


Constraints:

1 <= arr1.length, arr2.length <= 500
-1000 <= arr1[i], arr2[j] <= 1000
0 <= d <= 100
 */
public class EASY_1385_FindtheDistanceValueBetweenTwoArrays {

    /*
    Runtime: 3 ms, faster than 97.62% of Java online submissions for Find the Distance Value Between Two Arrays.
    Memory Usage: 41 MB, less than 100.00% of Java online submissions for Find the Distance Value Between Two Arrays.
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0, dist = 0;
        for(int i = 0; i < arr1.length; i++)
        {
            count = 0;
            for(int j = 0; j < arr2.length; j++)
            {
                if(Math.abs(arr1[i]- arr2[j]) > d)
                    count++;
                else
                    break;
            }
            if(count == arr2.length)
                dist++;
        }
        return dist;
    }

    /*
    Runtime: 12 ms, faster than 20.14% of Java online submissions for Find the Distance Value Between Two Arrays.
    Memory Usage: 47.8 MB, less than 5.17% of Java online submissions for Find the Distance Value Between Two Arrays.
     */
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int count = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int number: arr2) {
            tree.add(number);
        }
        for (int i=0; i<arr1.length; i++) {
            int leftValue = arr1[i] - d;
            int rightValue = arr1[i] + d;
            Set<Integer> set = tree.subSet(leftValue, rightValue+1);
            if (set.isEmpty())
                count += 1;
        }
        return count;
    }

    /*
    Runtime: 5 ms, faster than 67.55% of Java online submissions for Find the Distance Value Between Two Arrays.
    Memory Usage: 44.6 MB, less than 56.78% of Java online submissions for Find the Distance Value Between Two Arrays.
     */
    public int findTheDistanceValue3(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int val : arr1)
        {
            int closest = findClosestValtoTarget(arr2,val);
            if(Math.abs(val - closest) > d)
                count++;
        }
        return count;
    }
    private int findClosestValtoTarget(int[] sortedArr, int target)
    {
        int left = 0, right = sortedArr.length -1;
        int ans = Integer.MAX_VALUE;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(sortedArr[mid] == target)
                return target;
            else if(sortedArr[mid] > target)
                right = mid-1;
            else
                left = mid+1;
            ans = Math.abs(sortedArr[mid] - target) < Math.abs(ans-target) ? sortedArr[mid] : ans;
        }
        return ans;
    }
}
