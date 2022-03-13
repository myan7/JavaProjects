package com.myjobhunting;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

Constraints:
n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.
 */

/*
[4,5,6,7,0,1,2]
left 0 , mid 3, right 6
 4         7          2
[11,13,15,17]
left 0, mid 1 right 3
11,     13,     17
 */
public class MEDIUM_153_FindMinimuminRotatedSortedArray {

    /*
    After completing LC 33, Search in Rotated Sorted Array
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
    Memory Usage: 42.6 MB, less than 27.89% of Java online submissions for Find Minimum in Rotated Sorted
     */
    public int findMin_33(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;

            if( nums[mid] >= nums[left]) // if left half is increasing
            {
                if(nums[mid] <= nums[right]) // if right half is also increasing
                    right = mid -1;
                else
                    left = mid +1;
            }
            else  // if left half has a peak  [3,1,2]
            {
                if(nums[mid] <= nums[right])
                    right = mid;
                else
                    left = mid+1;
            }
        }
        return nums[left];
    }

    /* LeetCode solution
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
    Memory Usage: 42 MB, less than 54.18% of Java online submissions for Find Minimum in Rotated Sorted Array.
     */
    public int findMin(int[] nums) {
        // If the list has just one element then return that element.
        if (nums.length == 1) {
            return nums[0];
        }

        // initializing left and right pointers.
        int left = 0, right = nums.length - 1;

        // if the last element is greater than the first element then there is no rotation.
        // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
        // Hence the smallest element is first element. A[0]
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // Binary search way
        while (right >= left) {
            // Find the mid element
            int mid = left + (right - left) / 2;

            // if the mid element is greater than its next element then mid+1 element is the smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is the smallest
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with elements
            // greater than nums[0]
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                // if nums[0] is greater than the mid value then this means the smallest value is somewhere to
                // the left
                right = mid - 1;
            }
        }
        return -1;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
    Memory Usage: 41.8 MB, less than 63.36% of Java online submissions for Find Minimum in Rotated Sorted
     */
    public int findMin0(int[] nums) {
        //You must write an algorithm that runs in O(log n) time.
        int left = 0, right = nums.length-1;
        //int ans = Integer.MAX_VALUE;

        while(left < right)
        {
            int mid = left + (right - left)/2;
            // [3,4,5,1,2]
            if(nums[left] < nums[mid] && nums[mid] > nums[right])
            {
                left = mid+1;
            }//[1,2]
            else if(nums[left] < nums[mid] && nums[mid] < nums[right])
            {
                right = mid -1;
            }//[2,1]
            else if(nums[left] >= nums[mid] && nums[mid] > nums[right])
            {
                left = mid+1;
            }//[3,1,2]
            else if(nums[left] >= nums[mid] && nums[mid] < nums[right])
                right = mid;
        }
        return nums[left];
    }
}
