package com.myjobhunting;
//

/*
You are given two non-increasing 0-indexed integer arrays nums1 and nums2.

A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length,
is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i.

Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.

An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.

Example 1:
Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
Output: 2
Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
The maximum distance is 2 with pair (2,4).

Example 2:
Input: nums1 = [2,2,2], nums2 = [10,10,1]
Output: 1
Explanation: The valid pairs are (0,0), (0,1), and (1,1).
The maximum distance is 1 with pair (0,1).

Example 3:
Input: nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
Output: 2
Explanation: The valid pairs are (2,2), (2,3), (2,4), (3,3), and (3,4).
The maximum distance is 2 with pair (2,4).

Constraints:

1 <= nums1.length, nums2.length <= 10^5
1 <= nums1[i], nums2[j] <= 10^5
Both nums1 and nums2 are non-increasing.
 */
public class MEDIUM_1855_MaximumDistanceBetweenaPairofValues {

    /*
    Runtime: 3 ms, faster than 88.25% of Java online submissions for Maximum Distance Between a Pair of Values.
    Memory Usage: 107.7 MB, less than 19.36% of Java online submissions for Maximum Distance Between a Pair of Values.
    Time O(n + m)
    Space O(1)
     */
    // iterate on nums2
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0, i = 0, n = nums1.length, m = nums2.length;
        for (int j = 0; j < m; ++j) {
            while (i < n && nums1[i] > nums2[j])
                i++;
            if (i == n) break;
            res = Math.max(res, j - i);
        }
        return res;
    }

    /*
    Runtime: 3 ms, faster than 88.25% of Java online submissions for Maximum Distance Between a Pair of Values.
    Memory Usage: 102.5 MB, less than 52.54% of Java online submissions for Maximum Distance Between a Pair of Values.
    Time O(n + m)
    Space O(1)
     */
    // iterate on nums1
    public int maxDistance1(int[] nums1, int[] nums2) {
        int res = 0, j = -1, n = nums1.length, m = nums2.length;
        for (int i = 0; i < n; ++i) {
            while (j + 1 < m && nums1[i] <= nums2[j + 1])
                j++;
            res = Math.max(res, j - i);
        }
        return res;
    }

    /*
    Runtime: 2 ms, faster than 100.00% of Java online submissions for Maximum Distance Between a Pair of Values.
    Memory Usage: 55.3 MB, less than 92.17% of Java online submissions for Maximum Distance Between a Pair of Values.
    Time O(n + m)
    Space O(1)
     */
    // iterate on both nums1 and nums2
    public int maxDistance2(int[] nums1, int[] nums2) {
        int i = 0, j = 0, res = 0, n = nums1.length, m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] > nums2[j])
                i++;
            else
                res = Math.max(res, j++ - i);
        }
        return res;
    }

    /*
    Runtime: 42 ms, faster than 26.27% of Java online submissions for Maximum Distance Between a Pair of Values.
    Memory Usage: 55.3 MB, less than 92.17% of Java online submissions for Maximum Distance Between a Pair of Values.
    Time O(nlogM)
    Space O(1)
     */
    public int maxDistance3(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums1.length; i++)
        {
            int index = getIndex(nums2,i,nums1[i]);
            if(index - i < max)
                continue;
            max = Math.max(max, index-i);
        }
        return max < 0? 0 : max;
    }

    private int getIndex(int[] nums, int start, int target)
    {
        int left = start, right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] >= target)
                left = mid+1;
            else
                right = mid-1 ;
        }
        return right;
    }
}
