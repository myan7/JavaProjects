package com.myjobhunting;

public class MEDIUM_081_SearchinRotatedSortedArray_II {

    /*
    Runtime: 1 ms, faster than 81.31% of Java online submissions for Search in Rotated Sorted Array II.
    Memory Usage: 44.6 MB, less than 6.43% of Java online submissions for Search in Rotated Sorted Array II.
     */
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end ) {
            if(nums[start] != target )
                start++;
            if(nums[end] != target)
                end--;
            else if(nums[start] == target || nums[end] == target)
                return true;
        }
        return false;
    }

    /*
    Runtime: 1 ms, faster than 81.31% of Java online submissions for Search in Rotated Sorted Array II.
    Memory Usage: 44.7 MB, less than 6.43% of Java online submissions for Search in Rotated Sorted Array II.
     */
    public boolean search0(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = -1;
        while(left <= right)
        {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[right] || nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // If we get here, that means nums[start] == nums[mid] == nums[end],
                // then shifting out any of the two sides won't change the result
                // but can help remove duplicate from consideration,
                // here we just use right-- but left++ works too.
            } else {
                right--;
            }
        }
        return false;
    }
}
