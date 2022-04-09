package com.myjobhunting;
// https://leetcode.com/problems/minimize-product-sum-of-two-arrays/

import java.util.Arrays;

/*
The product sum of two equal-length arrays a and b is equal to the sum of a[i] * b[i] for all 0 <= i < a.length (0-indexed).

For example, if a = [1,2,3,4] and b = [5,2,3,1], the product sum would be 1*5 + 2*2 + 3*3 + 4*1 = 22.
Given two arrays nums1 and nums2 of length n,
return the minimum product sum if you are allowed to rearrange the order of the elements in nums1.

Example 1:
Input: nums1 = [5,3,4,2], nums2 = [4,2,2,5]
Output: 40
Explanation: We can rearrange nums1 to become [3,5,4,2]. The product sum of [3,5,4,2] and [4,2,2,5] is 3*4 + 5*2 + 4*2 + 2*5 = 40.


Example 2:
Input: nums1 = [2,1,4,5,7], nums2 = [3,2,4,8,6]
Output: 65
Explanation: We can rearrange nums1 to become [5,7,4,1,2]. The product sum of [5,7,4,1,2] and [3,2,4,8,6] is 5*3 + 7*2 + 4*4 + 1*8 + 2*6 = 65.

Constraints:

n == nums1.length == nums2.length
1 <= n <= 10^5
1 <= nums1[i], nums2[i] <= 100
 */
public class MEDIUM_1874_MinimizeProductSumofTwoArrays {


    /* LC calls this counting sort
    Main goal of this problem is to use max from nums2 * min from nums1 and sum all the pairs.
    my original solution 20220409 is from the algorithm of bucket sort.
    index of the 101 array indicates the element,
    and the value is the frequency of that element in the corresponding nums* array
    use 2 pointers, one goes from the min, the other goes from the max.
     */
    /*
    Runtime: 6 ms, faster than 94.27% of Java online submissions for Minimize Product Sum of Two Arrays.
    Memory Usage: 92.6 MB, less than 78.63% of Java online submissions for Minimize Product Sum of Two Arrays.
    Time complexity: O(n+k)
     */
    public int minProductSum20220409(int[] nums1, int[] nums2) {
        int[] nums2Bucket = new int[101];
        for(int num : nums2)
            nums2Bucket[num]++;

        int[] nums1Bucket = new int[101];
        for(int num : nums1)
            nums1Bucket[num]++;

        int i = 1, j = 100, prod = 0;
        while(i < 101 && j >= 0)
        {
            while(i < 101 && nums2Bucket[i] == 0)
                i++;
            while(j >= 0 && nums1Bucket[j] == 0)
                j--;
            if(i == 101 || j < 0)
                return prod;
            prod += i*j;
            nums2Bucket[i]--;
            nums1Bucket[j]--;
        }
        return prod;
    }


    /*
    Runtime: 20 ms, faster than 82.44% of Java online submissions for Minimize Product Sum of Two Arrays.
    Memory Usage: 51.4 MB, less than 90.84% of Java online submissions for Minimize Product Sum of Two Arrays.
    Time complexity: O(n⋅logn)
    Space complexity: O(n)
     */
    public int minProductSum1(int[] nums1, int[] nums2) {
        // Sort nums1 and nums2 in ascending order.
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Initialize sum as 0.
        int ans = 0;
        int n = nums2.length;

        // Iterate over two sorted arrays and calculate the
        // cumulative product sum.
        for (int i = 0; i < n; ++i) {
            // Since we also sort nums2 in ascending order,
            // we need to iterate over nums2 in reverse order.
            ans += nums1[i] * nums2[n - 1 - i];
        }

        return ans;
    }
}
